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
import org.wfp.fittest.service.StaffService;

@Controller
public class StaffController extends AbstractController {

	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/staffList")
	public String staff(Model model, Locale locale) {
		List<StaffDto> staff = staffService.findAllStaff();
		model.addAttribute("allStaff", staff);
		List<StaffRoleDto> staffRoles = staffService.findAllStaffRoles();
		model.addAttribute("allStaffRoles", staffRoles);
		return "staff";
	}
	
	@RequestMapping(value="/staffList/{id}/view")
	public String staffView(@PathVariable("id") Long id, Model model, Locale locale) {
		model.addAttribute("staff", staffService.findStaffById(id));
		return "forms/staff";
	}
	
	@RequestMapping(value="/staffRole/{id}/view")
	public String staffRoleView(@PathVariable("id") Long id, Model model, Locale locale) {
//		model.addAttribute("staffRole", staffService.findStaffRoleById(id));
		return "forms/staff-role";
	}
}
