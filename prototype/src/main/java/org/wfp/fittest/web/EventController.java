package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/event")
public class EventController extends AbstractController {
	
	@RequestMapping(value = "")
	public String event(Model model, Locale locale) {
		model.addAttribute("allEvents", activityService.findAllEvents());
		return "event";
	}
}
