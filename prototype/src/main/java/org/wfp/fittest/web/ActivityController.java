package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.service.UtilityService;

@Controller
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private UtilityService utilityService;

	@RequestMapping("/activity")
	public String activity(Model model, Locale locale) {
		model.addAttribute("allActivities", activityService.findAllActivities());
		model.addAttribute("allActivityTypes",
				activityService.findAllActivityTypes());
		model.addAttribute("allActivityRoles",
				activityService.findAllActivityRoles());
		return "activity";
	}

	@RequestMapping(value = "/activity/{id}/view")
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

	@RequestMapping(value = "/activity/role/{id}/view")
	public String activityRoleView(@PathVariable("id") Long activityRoleId,
			Model model, Locale locale) {
		model.addAttribute("activityRole",
				activityService.findActivityRoleNested(activityRoleId));
		model.addAttribute("allActivities",
				activityService.findAllActivities());
		model.addAttribute("allProfileTypes",
				staffService.findAllProfileTypes());
		model.addAttribute("allStaffRoles", staffService.findAllStaffRoles());
		return "forms/activity-role";
	}
}
