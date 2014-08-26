package org.wfp.fittest.web;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.service.UtilityService;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = "/")
	public String index(Model model, Locale locale) {
		return "redirect:login";
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model, Locale locale, HttpServletRequest request) {
		request.getSession().setAttribute("readOnly", true);
		Date currentDate = new Date();
		model.addAttribute("staffAvailable",
				staffService.findStaffAvailable(currentDate));
		model.addAttribute("staffRolesBIS",
				staffService.findStaffRolesBIS(currentDate));
		model.addAttribute("staffRolesNotAvailable",
				staffService.findStaffRolesNotAvailable(currentDate));
		model.addAttribute("countStaffTypes",
				staffService.countStaffByStaffType());
		model.addAttribute("countProfileTypes",
				staffService.countStaffByProfileType());
		model.addAttribute("countStaffAvailability",
				staffService.countStaffAvailability(currentDate));
		return "dashboard";
	}

	@RequestMapping(value = "/deployment")
	public String deployment(Model model, Locale locale, HttpServletRequest request) {
		request.getSession().setAttribute("readOnly", false);
		return "deployment";
	}

	@RequestMapping(value = "/planning")
	public String planning(Model model, Locale locale) {
		return "planning";
	}

	@RequestMapping(value = "/requirement")
	public String requirement(Model model, Locale locale) {
		return "requirement";
	}

}
