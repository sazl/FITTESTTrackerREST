package org.wfp.fittest.web;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.dto.ActivityDto;
import org.wfp.fittest.dto.ActivityRoleDto;
import org.wfp.fittest.service.ActivityService;

@Controller
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping("/activity")
	public String activity(Model model, Locale locale) {
		List<ActivityDto> activities = activityService.findAllActivities();
		model.addAttribute("allActivities", activities);
		List<ActivityRoleDto> activityRoles = activityService
				.findAllActivityRoles();
		model.addAttribute("allActivityRoles", activityRoles);
		return "activity";
	}

	@RequestMapping(value = "/activity/{id}/view")
	public String activityView(@PathVariable("id") Long activityId,
			Model model, Locale locale) {
		model.addAttribute("activity", activityService.findActivity(activityId));
		return "forms/activity";
	}
	
	@RequestMapping(value = "/activityRole/{id}/view")
	public String activityRoleView(@PathVariable("id") Long activityRoleId,
			Model model, Locale locale) {
//		model.addAttribute("activity", activityService.findActivity(activityId));
		return "forms/activity-role";
	}
}
