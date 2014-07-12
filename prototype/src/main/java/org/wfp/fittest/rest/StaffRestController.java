package org.wfp.fittest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ProfileTypeBean;
import org.wfp.fittest.beans.StaffBean;
import org.wfp.fittest.beans.StaffRoleBean;
import org.wfp.fittest.beans.StaffTypeBean;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.utility.BeanListWrapper;
import org.wfp.fittest.utility.BeanWrapper;
import org.wfp.fittest.utility.JSONUtility;

@Controller
@RequestMapping("/rest")
public class StaffRestController {

	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/stafflist", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<StaffBean> staff() {
		return staffService.findAllStaff();
	}

	@RequestMapping(value = "/stafflist/{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<StaffBean> staff(@PathVariable("staffId") Long staffId) {
		return JSONUtility.beanWrapper("staff",
				staffService.findStaffById(staffId));
	}

	@RequestMapping(value = "/staffRoles", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<StaffRoleBean> staffRole() {
		return staffService.findAllStaffRoles();
	}

	@RequestMapping(value = "/staffRoles/{staffRoleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<StaffRoleBean> staffRole(
			@PathVariable("staffRoleId") Long staffRoleId) {
		return JSONUtility.beanWrapper("staffRole",
				staffService.findStaffRoleById(staffRoleId));
	}

	@RequestMapping(value = "/staffTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<StaffTypeBean> staffType() {
		return staffService.findAllStaffTypes();
	}

	@RequestMapping(value = "/staffTypes/{staffTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<StaffTypeBean> staffType(
			@PathVariable("staffTypeId") Long staffTypeId) {
		return JSONUtility.beanWrapper("staffType",
				staffService.findStaffTypeById(staffTypeId));
	}

	@RequestMapping(value = "/profileTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ProfileTypeBean> staffProfileType() {
		return staffService.findAllProfileTypes();
	}

	@RequestMapping(value = "/profileTypes/{profileTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ProfileTypeBean> staffProfileType(
			@PathVariable("profileTypeId") Long profileTypeId) {
		return JSONUtility.beanWrapper("profileType",
				staffService.findProfileTypeById(profileTypeId));
	}
}
