package org.wfp.fittest.service;

import org.wfp.fittest.beans.ProfileTypeBean;
import org.wfp.fittest.beans.StaffBean;
import org.wfp.fittest.beans.StaffRoleBean;
import org.wfp.fittest.beans.StaffTypeBean;
import org.wfp.fittest.utility.BeanListWrapper;



public interface StaffService {
	public StaffBean findStaffById(Long id);
	
	public BeanListWrapper<StaffBean> findAllStaff();

	public StaffRoleBean findStaffRoleById(Long id);
	
	public BeanListWrapper<StaffRoleBean> findAllStaffRoles();
	
	public StaffTypeBean findStaffTypeById(Long id);
	
	public BeanListWrapper<StaffTypeBean> findAllStaffTypes();
	
	public ProfileTypeBean findProfileTypeById(Long id);
	
	public BeanListWrapper<ProfileTypeBean> findAllProfileTypes();
}
