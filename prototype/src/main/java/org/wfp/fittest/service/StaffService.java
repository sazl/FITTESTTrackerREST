package org.wfp.fittest.service;

import java.util.List;

import org.wfp.fittest.dto.StaffDto;
import org.wfp.fittest.dto.StaffRoleDto;


public interface StaffService {
	public List<StaffDto> findAllStaff();
	
	public List<StaffRoleDto> findAllStaffRoles();
}
