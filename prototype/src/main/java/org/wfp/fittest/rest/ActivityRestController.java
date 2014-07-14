package org.wfp.fittest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.EventBean;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.utility.BeanListWrapper;
import org.wfp.fittest.utility.BeanWrapper;
import org.wfp.fittest.utility.HttpUtility;
import org.wfp.fittest.utility.JsonUtility;

@Controller
@RequestMapping("/rest")
public class ActivityRestController {

	@Autowired
	private ActivityService activityService;

	/*------------------------------------------------------------------------*
	 * Activity                                                               *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/activities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ActivityBean> activity() {
		return JsonUtility.toBeanListWrapper("activities",
				activityService.findAllActivities());
	}

	@RequestMapping(value = "/activities/{activityId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityBean> activity(
			@PathVariable("activityId") Long activityId) {
		return JsonUtility.beanWrapper("activity",
				activityService.findActivityById(activityId));
	}

	@RequestMapping(value = "/activities/{activityId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> activityDelete(
			@PathVariable("activityId") Long activityId) {
		return HttpUtility.deleteResponse(activityService
				.deleteActivityById(activityId));
	}

	/*------------------------------------------------------------------------*
	 * Activity Role                                                          *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/activityRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ActivityRoleBean> activityRole() {
		return JsonUtility.toBeanListWrapper("activityRoles",
				activityService.findAllActivityRoles());
	}

	@RequestMapping(value = "/activityRoles/{activityRoleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityRoleBean> activityRole(
			@PathVariable("activityRoleId") Long activityRoleId) {
		return JsonUtility.beanWrapper("activityRole",
				activityService.findActivityRoleById(activityRoleId));
	}

	@RequestMapping(value = "/activityRoles/{activityRoleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> activityRoleDelete(
			@PathVariable("activityRoleId") Long activityRoleId) {
		return HttpUtility.deleteResponse(activityService
				.deleteActivityRoleById(activityRoleId));
	}

	/*------------------------------------------------------------------------*
	 * Activity Type                                                          *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/activityTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ActivityTypeBean> activityType() {
		return JsonUtility.toBeanListWrapper("activityTypes",
				activityService.findAllActivityTypes());
	}

	@RequestMapping(value = "/activityTypes/{activityTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityTypeBean> activityType(
			@PathVariable("activityTypeId") Long activityTypeId) {
		return JsonUtility.beanWrapper("activityType",
				activityService.findActivityTypeById(activityTypeId));
	}

	@RequestMapping(value = "/activityTypes/{activityTypeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> activityTypeDelete(
			@PathVariable("activityTypeId") Long activityTypeId) {
		return HttpUtility.deleteResponse(activityService
				.deleteActivityTypeById(activityTypeId));
	}

	/*------------------------------------------------------------------------*
	 * Event                                                                  *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<EventBean> event() {
		return JsonUtility.toBeanListWrapper("events",
				activityService.findAllEvents());
	}

	@RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<EventBean> event(@PathVariable("eventId") Long eventId) {
		return JsonUtility.beanWrapper("event",
				activityService.findEventById(eventId));
	}

	@RequestMapping(value = "/events/{eventId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> eventDelete(
			@PathVariable("eventId") Long eventId) {
		return HttpUtility.deleteResponse(activityService
				.deleteEventById(eventId));
	}
}
