package org.wfp.fittest.service;

import java.util.List;

import org.wfp.fittest.beans.ProfileTypeBean;
import org.wfp.fittest.beans.RequirementCriteriaBean;
import org.wfp.fittest.beans.StaffBean;
import org.wfp.fittest.beans.StaffRoleBean;
import org.wfp.fittest.beans.StaffTypeBean;

public interface StaffService {
	public StaffBean findStaffById(Long id);

	public List<StaffBean> findAllStaff();

	public StaffRoleBean findStaffRoleById(Long id);
	
	public List<StaffRoleBean> findStaffRolesByIds(List<Long> ids);

	public List<StaffRoleBean> findAllStaffRoles();

	public StaffTypeBean findStaffTypeById(Long id);

	public List<StaffTypeBean> findAllStaffTypes();

	public ProfileTypeBean findProfileTypeById(Long id);

	public List<ProfileTypeBean> findAllProfileTypes();

	public Boolean deleteStaffById(Long staffId);

	public Boolean deleteStaffRoleById(Long staffRoleId);

	public Boolean deleteStaffTypeById(Long staffTypeId);

	public Boolean deleteProfileTypeById(Long profileTypeId);
	
	public StaffBean saveOrUpdateStaff(StaffBean staffBean);
	
	public StaffRoleBean saveOrUpdateStaffRole(StaffRoleBean staffRoleBean);
	
	public StaffTypeBean saveOrUpdateStaffType(StaffTypeBean staffTypeBean);
	
	public ProfileTypeBean saveOrUpdateProfileType(ProfileTypeBean profileTypeBean);
	
	public List<StaffBean> findStaffRequirements(RequirementCriteriaBean criteria);
}
