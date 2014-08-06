package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.converter.DtoConverter;
import org.wfp.fittest.dto.ActivityDto;
import org.wfp.fittest.dto.ActivityRoleDto;
import org.wfp.fittest.dto.ActivityTypeDto;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ActivityRoleRepository;
import org.wfp.fittest.repository.ActivityTypeRepository;
import org.wfp.fittest.service.ActivityService;

@Service
@Transactional(readOnly = true)
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private DtoConverter converter;

	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private ActivityRoleRepository activityRoleRepository;
	@Autowired
	private ActivityTypeRepository activityTypeRepository;

	@Override
	public List<ActivityDto> findAllActivities() {
		return converter.entitiesToDtos(activityRepository.findAll());
	}

	@Override
	public ActivityDto findActivity(Long activityId) {
		return converter.entityToDto(activityRepository.findOne(activityId));
	}

	@Override
	public ActivityDto findActivityNested(Long activityId) {
		return converter.entityToDtoNested(activityRepository
				.findOne(activityId));
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteActivity(ActivityDto activityDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteActivityById(Long activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public ActivityDto saveOrUpdateActivity(ActivityDto activityDto) {
		Activity activity = converter.dtoToEntity(activityDto);
		activityRepository.save(activity);
		return null;
	}

	@Override
	public List<ActivityRoleDto> findAllActivityRoles() {
		return converter.entitiesToDtos(activityRoleRepository.findAll());
	}

	@Override
	public ActivityRoleDto findActivityRole(Long activityRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityRoleDto findActivityRoleNested(Long activityRoleId) {
		return converter.entityToDtoNested(activityRoleRepository
				.findOne(activityRoleId));
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteActivityRole(ActivityRoleDto activityRoleDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteActivityRoleById(Long activityRoleId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public ActivityRoleDto saveOrUpdateActivityRole(
			ActivityRoleDto activityRoleDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityTypeDto> findAllActivityTypes() {
		return converter.entitiesToDtos(activityTypeRepository.findAll());
	}

	@Override
	public ActivityTypeDto findActivityType(Long activityTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteActivityType(ActivityTypeDto activityTypeDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteActivityTypeById(Long activityTypeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public ActivityTypeDto saveOrUpdateActivityType(
			ActivityTypeDto activityTypeDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
