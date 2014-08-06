package org.wfp.fittest.service;

import java.util.Date;
import java.util.List;

import org.wfp.fittest.dto.ProfileTypeDto;
import org.wfp.fittest.dto.StaffDto;
import org.wfp.fittest.dto.StaffRoleDto;
import org.wfp.fittest.dto.StaffTypeDto;


public interface StaffService {
	
	public StaffDto findStaffById(Long staffId);
	
	public StaffDto findStaffNested(Long staffId);
	
	public List<StaffDto> findAllStaff();
	
	public List<StaffDto> findStaffByActivityTypeInDate(String activityType, Date date);
	
	public List<StaffDto> findStaffBIS(Date date);
	
	public List<StaffDto> findStaffAvailable(Date date);
	
	public List<StaffDto> findStaffNotAvailable(Date date);
	
	public StaffRoleDto findStaffRoleNested(Long staffRoleId);
	
	public List<StaffRoleDto> findAllStaffRoles();
	
	public List<StaffTypeDto> findAllStaffTypes();
	
	public List<ProfileTypeDto> findAllProfileTypes();
}
