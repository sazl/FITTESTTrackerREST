package org.wfp.fittest.web;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.dto.StaffDto;
import org.wfp.fittest.dto.StaffRoleDto;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.service.UtilityService;

@Controller
public class StaffController extends AbstractController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = "/staffList")
	public String staff(Model model, Locale locale) {
		List<StaffDto> staff = staffService.findAllStaff();
		model.addAttribute("allStaff", staff);
		List<StaffRoleDto> staffRoles = staffService.findAllStaffRoles();
		model.addAttribute("allStaffRoles", staffRoles);
		return "staff";
	}

	@RequestMapping(value = "/staffList/{id}/view")
	public String staffView(@PathVariable("id") Long id, Model model,
			Locale locale) {
		model.addAttribute("staff", staffService.findStaffNested(id));
		model.addAttribute("allStaffTypes", staffService.findAllStaffTypes());
		model.addAttribute("allProfileTypes",
				staffService.findAllProfileTypes());
		model.addAttribute("allNationalities",
				utilityService.findAllCountries());
		model.addAttribute("allLanguages", utilityService.findAllLanguages());
		return "forms/staff";
	}

	@RequestMapping(value = "/staffList/role/{id}/view")
	public String staffRoleView(@PathVariable("id") Long id, Model model,
			Locale locale) {
		model.addAttribute("staffRole", staffService.findStaffRoleNested(id));
		model.addAttribute("allConfirmedTypes",
				utilityService.findAllConfirmedTypes());
		model.addAttribute("allActivityRoles",
				activityService.findAllActivityRoles());
		model.addAttribute("allStaff", staffService.findAllStaff());
		return "forms/staff-role";
	}
}
