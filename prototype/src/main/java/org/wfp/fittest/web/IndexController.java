package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.service.ActivityService;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "/")
	public String index(Model model, Locale locale) {
		return "index";
	}


	@RequestMapping(value = "/activity")
	public String activity(Model model, Locale locale) {
		model.addAttribute("allActivities", activityService.findAllActivities());
		model.addAttribute("allActivityRoles",
				activityService.findAllActivityRoles());
		return "activity";
	}
}
