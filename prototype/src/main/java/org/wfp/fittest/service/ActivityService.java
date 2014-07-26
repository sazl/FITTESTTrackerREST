package org.wfp.fittest.service;

import java.util.List;

import org.wfp.fittest.dto.ActivityDto;
import org.wfp.fittest.dto.ActivityRoleDto;

public interface ActivityService {
	
	public List<ActivityDto> findAllActivities();

	public List<ActivityRoleDto> findAllActivityRoles();
}
