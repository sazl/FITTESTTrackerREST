package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.converter.DtoConverter;
import org.wfp.fittest.dto.ActivityDto;
import org.wfp.fittest.dto.ActivityRoleDto;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ActivityRoleRepository;
import org.wfp.fittest.service.ActivityService;

@Service
@Transactional(readOnly = true)
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private DtoConverter converter;
	
	@Autowired private ActivityRepository activityRepository;
	@Autowired private ActivityRoleRepository activityRoleRepository;
	
	@Override
	public List<ActivityDto> findAllActivities() {
		return converter.entitiesToDtos(activityRepository.findAll());
	}
	
	@Override
	public List<ActivityRoleDto> findAllActivityRoles() {
		return converter.entitiesToDtos(activityRoleRepository.findAll());
	}

}
