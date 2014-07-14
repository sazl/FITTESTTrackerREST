package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.EventBean;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ActivityRoleRepository;
import org.wfp.fittest.repository.ActivityTypeRepository;
import org.wfp.fittest.repository.EventRepository;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.utility.EntityConverter;

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

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteActivityById(Long id) {
		return activityRepository.deleteCheck(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteActivityTypeById(Long id) {
		return activityTypeRepository.deleteCheck(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteActivityRoleById(Long id) {
		return activityRoleRepository.deleteCheck(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteEventById(Long id) {
		return eventRepository.deleteCheck(id);
	}
}
