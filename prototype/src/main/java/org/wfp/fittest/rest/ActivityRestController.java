package org.wfp.fittest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.EventBean;
import org.wfp.fittest.converter.BeanListWrapper;
import org.wfp.fittest.converter.BeanWrapper;
import org.wfp.fittest.service.ActivityService;
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
	public BeanListWrapper<ActivityBean> activity(
			
			) {
		return JsonUtility.toBeanListWrapper("activities",
				activityService.findAllActivities());
	}

	@RequestMapping(value = "/activities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityBean> activityCreate(
			@RequestBody BeanWrapper<ActivityBean> activityWrapper) {
		ActivityBean activityBean = activityWrapper.get("activity");
		return JsonUtility.beanWrapper("activity",
				activityService.saveOrUpdateActivity(activityBean));
	}

	@RequestMapping(value = "/activities/{activityId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityBean> activity(
			@PathVariable("activityId") Long activityId) {
		return JsonUtility.beanWrapper("activity",
				activityService.findActivityById(activityId));
	}

	@RequestMapping(value = "/activities/{activityId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityBean> activityUpdate(
			@PathVariable("activityId") Long activityId,
			@RequestBody BeanWrapper<ActivityBean> activityWrapper) {
		ActivityBean activityBean = activityWrapper.get("activity");
		activityBean.setId(activityId);
		return JsonUtility.beanWrapper("activity",
				activityService.saveOrUpdateActivity(activityBean));
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
	public BeanListWrapper<ActivityRoleBean> activityRoles(
			@RequestParam(value = "ids[]", required = false) List<Long> ids) {
		if (ids != null) {
			return JsonUtility.toBeanListWrapper("activityRoles",
					activityService.findActivityRolesByIds(ids));
		} else {
			return JsonUtility.toBeanListWrapper("activityRoles",
					activityService.findAllActivityRoles());
		}
	}

	@RequestMapping(value = "/activityRoles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityRoleBean> activityRoleCreate(
			@RequestBody BeanWrapper<ActivityRoleBean> activityRoleWrapper) {
		ActivityRoleBean activityRoleBean = activityRoleWrapper
				.get("activityRole");
		return JsonUtility.beanWrapper("activityRole",
				activityService.saveOrUpdateActivityRole(activityRoleBean));
	}

	@RequestMapping(value = "/activityRoles/{activityRoleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityRoleBean> activityRole(
			@PathVariable("activityRoleId") Long activityRoleId) {
		return JsonUtility.beanWrapper("activityRole",
				activityService.findActivityRoleById(activityRoleId));
	}

	@RequestMapping(value = "/activityRoles/{activityRoleId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityRoleBean> activityRoleUpdate(
			@PathVariable("activityRoleId") Long activityRoleId,
			@RequestBody BeanWrapper<ActivityRoleBean> activityRoleWrapper) {
		ActivityRoleBean activityRoleBean = activityRoleWrapper
				.get("activityRole");
		activityRoleBean.setId(activityRoleId);
		return JsonUtility.beanWrapper("activityRole",
				activityService.saveOrUpdateActivityRole(activityRoleBean));
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

	@RequestMapping(value = "/activityTypes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityTypeBean> activityTypeCreate(
			@RequestBody BeanWrapper<ActivityTypeBean> activityTypeWrapper) {
		ActivityTypeBean activityTypeBean = activityTypeWrapper
				.get("activityType");
		return JsonUtility.beanWrapper("activityType",
				activityService.saveOrUpdateActivityType(activityTypeBean));
	}

	@RequestMapping(value = "/activityTypes", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ActivityTypeBean> activityTypeCreate(
			@PathVariable("activityTypeId") Long activityTypeId,
			@RequestBody BeanWrapper<ActivityTypeBean> activityTypeWrapper) {
		ActivityTypeBean activityTypeBean = activityTypeWrapper
				.get("activityType");
		activityTypeBean.setId(activityTypeId);
		return JsonUtility.beanWrapper("activityType",
				activityService.saveOrUpdateActivityType(activityTypeBean));
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

	@RequestMapping(value = "/events", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<EventBean> eventCreate(
			@RequestBody BeanWrapper<EventBean> eventWrapper) {
		EventBean event = eventWrapper.get("event");
		return JsonUtility.beanWrapper("event",
				activityService.saveOrUpdateEvent(event));
	}

	@RequestMapping(value = "/events/{eventId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<EventBean> eventUpdate(
			@PathVariable("eventId") Long eventId,
			@RequestBody BeanWrapper<EventBean> eventWrapper) {
		EventBean event = eventWrapper.get("event");
		event.setId(eventId);
		return JsonUtility.beanWrapper("event",
				activityService.saveOrUpdateEvent(event));
	}

	@RequestMapping(value = "/events/{eventId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> eventDelete(
			@PathVariable("eventId") Long eventId) {
		return HttpUtility.deleteResponse(activityService
				.deleteEventById(eventId));
	}
	
}
