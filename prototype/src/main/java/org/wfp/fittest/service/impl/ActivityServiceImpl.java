package org.wfp.fittest.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.DeploymentCriteriaBean;
import org.wfp.fittest.beans.EventBean;
import org.wfp.fittest.converter.EntityConverter;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.entity.ActivityRole;
import org.wfp.fittest.entity.ActivityType;
import org.wfp.fittest.entity.Country;
import org.wfp.fittest.entity.Event;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ActivityRoleRepository;
import org.wfp.fittest.repository.ActivityTypeRepository;
import org.wfp.fittest.repository.CountryRepository;
import org.wfp.fittest.repository.EventRepository;
import org.wfp.fittest.repository.ProfileTypeRepository;
import org.wfp.fittest.repository.StaffRoleRepository;
import org.wfp.fittest.service.ActivityService;

@Service
@Transactional(readOnly = true)
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActivityRoleRepository activityRoleRepository;

	@Autowired
	private ActivityTypeRepository activityTypeRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ProfileTypeRepository profileTypeRepository;

	@Autowired
	private StaffRoleRepository staffRoleRepository;

	@Override
	public ActivityBean findActivityById(Long id) {
		return EntityConverter.toBean(activityRepository.findOne(id));
	}

	@Override
	public List<ActivityBean> findAllActivities() {
		return EntityConverter.toBeanList(activityRepository.findAll());
	}

	@Override
	public ActivityTypeBean findActivityTypeById(Long id) {
		return EntityConverter.toBean(activityTypeRepository.findOne(id));
	}

	@Override
	public List<ActivityTypeBean> findAllActivityTypes() {
		return EntityConverter.toBeanList(activityTypeRepository.findAll());
	}

	@Override
	public ActivityRoleBean findActivityRoleById(Long id) {
		return EntityConverter.toBean(activityRoleRepository.findOne(id));
	}

	@Override
	public List<ActivityRoleBean> findAllActivityRoles() {
		return EntityConverter.toBeanList(activityRoleRepository.findAll());
	}

	@Override
	public EventBean findEventById(Long id) {
		return EntityConverter.toBean(eventRepository.findOne(id));
	}

	@Override
	public List<EventBean> findAllEvents() {
		return EntityConverter.toBeanList(eventRepository.findAll());
	}

//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteActivityById(Long id) {
//		return activityRepository.deleteCheck(id);
//	}
//
//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteActivityTypeById(Long id) {
//		return activityTypeRepository.deleteCheck(id);
//	}
//
//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteActivityRoleById(Long id) {
//		return activityRoleRepository.deleteCheck(id);
//	}
//
//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteEventById(Long id) {
//		return eventRepository.deleteCheck(id);
//	}

	@Override
	@Transactional(readOnly = false)
	public EventBean saveOrUpdateEvent(EventBean eventBean) {
		Event event = EntityConverter.toEntity(eventBean);
		Event result = eventRepository.save(event);
		return EntityConverter.toBean(result);
	}

	@Override
	@Transactional(readOnly = false)
	public ActivityBean saveOrUpdateActivity(ActivityBean activityBean) {
//		Activity activity = EntityConverter.toEntity(activityBean);
//		activity.setActivityRoles(new HashSet<ActivityRole>(
//				activityRoleRepository.findAll(activityBean
//						.getActivityRoleIds())));
//		activity.setCountries(new HashSet<Country>(countryRepository
//				.findAll(activityBean.getActivityRoleIds())));
//		return EntityConverter.toBean(activityRepository.save(activity));
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public ActivityRoleBean saveOrUpdateActivityRole(
			ActivityRoleBean activityRoleBean) {
//		ActivityRole activityRole = EntityConverter.toEntity(activityRoleBean);
//		activityRole.setActivity(activityRepository.findOne(activityRoleBean
//				.getActivityId()));
//		activityRole.setProfileType(profileTypeRepository
//				.findOne(activityRoleBean.getProfileTypeId()));
//		activityRole.setStaffRoles(new HashSet<StaffRole>(staffRoleRepository
//				.findAll(activityRoleBean.getStaffRoleIds())));
//		return EntityConverter
//				.toBean(activityRoleRepository.save(activityRole));
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public ActivityTypeBean saveOrUpdateActivityType(
			ActivityTypeBean activityTypeBean) {
//		ActivityType activityType = EntityConverter.toEntity(activityTypeBean);
//		activityType.setActivities(new HashSet<Activity>(activityRepository
//				.findAll(activityTypeBean.getActivityIds())));
//		return EntityConverter
//				.toBean(activityTypeRepository.save(activityType));
		return null;
	}

	@Override
	public List<ActivityBean> findActivityDeployments(
			DeploymentCriteriaBean criteria) {
		return null;
	}

	@Override
	public List<ActivityRoleBean> findActivityRolesByIds(List<Long> ids) {
		return EntityConverter.toBeanList(activityRoleRepository.findAll(ids));
	}

	@Override
	public Boolean deleteActivityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteActivityTypeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteActivityRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEventById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
