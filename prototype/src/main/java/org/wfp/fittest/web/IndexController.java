package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.service.ActivityService;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/")
	public String index(Model model, Locale locale) {
		return "index";
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model, Locale locale) {
		return "dashboard";
	}
	
	@RequestMapping(value = "/deployment")
	public String deployment(Model model, Locale locale) {
		return "deployment";
	}
	
	@RequestMapping(value = "/misc")
	public String misc(Model model, Locale locale) {
		return "misc";
	}
	
	@RequestMapping(value = "/planning")
	public String planning(Model model, Locale locale) {
		return "planning";
	}
	
	@RequestMapping(value = "/requirement")
	public String requirement(Model model, Locale locale) {
		return "requirement";
	}
	
	@RequestMapping(value = "/staffList")
	public String staff(Model model, Locale locale) {
		return "staff";
	}
	
	@RequestMapping(value = "/activity")
	public String activity(Model model, Locale locale) {
		model.addAttribute("allActivities", activityService.findAllActivities());
		model.addAttribute("allActivityRoles",
				activityService.findAllActivityRoles());
		return "activity";
	}
	
	@RequestMapping(value = "/activity/{id}")
	public String activity(@PathVariable("id") Activity activity, Model model, Locale locale) {
		model.addAttribute("activity", activity);
		return "activity";
	}

}
