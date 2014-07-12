package org.wfp.fittest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.EventBean;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.utility.BeanListWrapper;
import org.wfp.fittest.utility.BeanWrapper;
import org.wfp.fittest.utility.JSONUtility;

@Controller
@RequestMapping("/rest")
public class ActivityRestController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "/activities", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ActivityBean> activity() {
		return activityService.findAllActivities();
	}

	@RequestMapping(value = "/activities/{activityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityBean> activity(
			@PathVariable("activityId") Long activityId) {
		return JSONUtility.beanWrapper("activity",
				activityService.findActivityById(activityId));
	}

	@RequestMapping(value = "/activityRoles", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ActivityRoleBean> activityRole() {
		return activityService.findAllActivityRoles();
	}

	@RequestMapping(value = "/activityRoles/{activityRoleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityRoleBean> activityRole(
			@PathVariable("activityRoleId") Long activityRoleId) {
		return JSONUtility.beanWrapper("activityRole",
				activityService.findActivityRoleById(activityRoleId));
	}

	@RequestMapping(value = "/activityTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ActivityTypeBean> activityType() {
		return activityService.findAllActivityTypes();
	}

	@RequestMapping(value = "/activityTypes/{activityTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityTypeBean> activityType(
			@PathVariable("activityTypeId") Long activityTypeId) {
		return JSONUtility.beanWrapper("activityType",
				activityService.findActivityTypeById(activityTypeId));
	}

	@RequestMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<EventBean> event() {
		return activityService.findAllEvents();
	}

	@RequestMapping(value = "/events/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<EventBean> event(@PathVariable("eventId") Long eventId) {
		return JSONUtility.beanWrapper("event",
				activityService.findEventById(eventId));
	}
}
