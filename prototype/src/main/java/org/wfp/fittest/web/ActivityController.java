package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wfp.fittest.dto.ActivityDto;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.service.UtilityService;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private UtilityService utilityService;

	@RequestMapping("")
	public String activity(Model model, Locale locale) {
		model.addAttribute("allActivities", activityService.findAllActivities());
		model.addAttribute("allActivityTypes",
				activityService.findAllActivityTypes());
		model.addAttribute("allActivityRoles",
				activityService.findAllActivityRoles());
		return "activity";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String activitySave(@ModelAttribute ActivityDto activityDto,
			Model model, Locale locale) {
		activityService.saveOrUpdateActivity(activityDto);
		return "redirect:/activity";
	}

	@RequestMapping(value = "/new")
	public String activityNew(Model model, Locale locale) {
		model.addAttribute("activity", new ActivityDto());
		model.addAttribute("allActivityTypes",
				activityService.findAllActivityTypes());
		model.addAttribute("allConfirmedTypes",
				utilityService.findAllConfirmedTypes());
		model.addAttribute("allCountries", utilityService.findAllCountries());
		return "forms/activity";
	}

	@RequestMapping(value = "/{id}/view")
	public String activityView(@PathVariable("id") Long activityId,
			Model model, Locale locale) {
		model.addAttribute("activity",
				activityService.findActivityNested(activityId));
		model.addAttribute("allActivityTypes",
				activityService.findAllActivityTypes());
		model.addAttribute("allConfirmedTypes",
				utilityService.findAllConfirmedTypes());
		model.addAttribute("allCountries", utilityService.findAllCountries());
		return "forms/activity";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public String activityDelete(@PathVariable("id") Long activityId,
			Model model, Locale locale) {
		activityService.deleteActivityById(activityId);
		return "redirect:/activity";
	}

}
