package org.wfp.fittest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ProfileTypeBean;
import org.wfp.fittest.beans.StaffBean;
import org.wfp.fittest.beans.StaffRoleBean;
import org.wfp.fittest.beans.StaffTypeBean;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.utility.BeanListWrapper;
import org.wfp.fittest.utility.BeanWrapper;
import org.wfp.fittest.utility.HttpUtility;
import org.wfp.fittest.utility.JsonUtility;

@Controller
@RequestMapping("/rest")
public class StaffRestController {

	@Autowired
	private StaffService staffService;

	/*------------------------------------------------------------------------*
	 * Staff                                                                  *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/staffList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<StaffBean> staff() {
		return JsonUtility.toBeanListWrapper("staffList",
				staffService.findAllStaff());
	}

	@RequestMapping(value = "/staffList/{staffId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<StaffBean> staff(@PathVariable("staffId") Long staffId) {
		return JsonUtility.beanWrapper("staff",
				staffService.findStaffById(staffId));
	}

	@RequestMapping(value = "/staffList/{staffId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> staffDelete(
			@PathVariable("staffId") Long staffId) {
		return HttpUtility
				.deleteResponse(staffService.deleteStaffById(staffId));
	}

	/*------------------------------------------------------------------------*
	 * Staff Role                                                             *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/staffRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<StaffRoleBean> staffRole() {
		return JsonUtility.toBeanListWrapper("staffRoles",
				staffService.findAllStaffRoles());
	}

	@RequestMapping(value = "/staffRoles/{staffRoleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<StaffRoleBean> staffRole(
			@PathVariable("staffRoleId") Long staffRoleId) {
		return JsonUtility.beanWrapper("staffRole",
				staffService.findStaffRoleById(staffRoleId));
	}

	@RequestMapping(value = "/staffRoles/{staffRoleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> staffRoleDelete(
			@PathVariable("staffRoleId") Long staffRoleId) {
		return HttpUtility.deleteResponse(staffService
				.deleteStaffRoleById(staffRoleId));
	}

	/*------------------------------------------------------------------------*
	 * Staff Type                                                             *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/staffTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<StaffTypeBean> staffType() {
		return JsonUtility.toBeanListWrapper("staffTypes",
				staffService.findAllStaffTypes());
	}

	@RequestMapping(value = "/staffTypes/{staffTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<StaffTypeBean> staffType(
			@PathVariable("staffTypeId") Long staffTypeId) {
		return JsonUtility.beanWrapper("staffType",
				staffService.findStaffTypeById(staffTypeId));
	}

	@RequestMapping(value = "/staffTypes/{staffTypeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> staffTypeDelete(
			@PathVariable("staffTypeId") Long staffTypeId) {
		return HttpUtility.deleteResponse(staffService
				.deleteStaffTypeById(staffTypeId));
	}

	/*------------------------------------------------------------------------*
	 * Profile Type                                                           *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/profileTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ProfileTypeBean> staffProfileType() {
		return JsonUtility.toBeanListWrapper("profileTypes",
				staffService.findAllProfileTypes());
	}

	@RequestMapping(value = "/profileTypes/{profileTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ProfileTypeBean> staffProfileType(
			@PathVariable("profileTypeId") Long profileTypeId) {
		return JsonUtility.beanWrapper("profileType",
				staffService.findProfileTypeById(profileTypeId));
	}

	@RequestMapping(value = "/profileTypes/{profileTypeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> staffProfileTypeDelete(
			@PathVariable("profileTypeId") Long profileTypeId) {
		return HttpUtility.deleteResponse(staffService
				.deleteProfileTypeById(profileTypeId));
	}
}
