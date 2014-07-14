package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.beans.ProfileTypeBean;
import org.wfp.fittest.beans.StaffBean;
import org.wfp.fittest.beans.StaffRoleBean;
import org.wfp.fittest.beans.StaffTypeBean;
import org.wfp.fittest.repository.ProfileTypeRepository;
import org.wfp.fittest.repository.StaffRepository;
import org.wfp.fittest.repository.StaffRoleRepository;
import org.wfp.fittest.repository.StaffTypeRepository;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.utility.EntityConverter;

@Service
@Transactional(readOnly = true)
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffRoleRepository staffRoleRepository;

	@Autowired
	private StaffTypeRepository staffTypeRepository;

	@Autowired
	private ProfileTypeRepository profileTypeRepository;

	@Override
	public StaffBean findStaffById(Long id) {
		return EntityConverter.toBean(staffRepository.findOne(id));
	}

	@Override
	public List<StaffBean> findAllStaff() {
		return EntityConverter.toBeanList(staffRepository.findAll());
	}

	@Override
	public StaffRoleBean findStaffRoleById(Long id) {
		return EntityConverter.toBean(staffRoleRepository.findOne(id));
	}

	@Override
	public List<StaffRoleBean> findAllStaffRoles() {
		return EntityConverter.toBeanList(staffRoleRepository.findAll());
	}

	@Override
	public StaffTypeBean findStaffTypeById(Long id) {
		return EntityConverter.toBean(staffTypeRepository.findOne(id));
	}

	@Override
	public List<StaffTypeBean> findAllStaffTypes() {
		return EntityConverter.toBeanList(staffTypeRepository.findAll());
	}

	@Override
	public ProfileTypeBean findProfileTypeById(Long id) {
		return EntityConverter.toBean(profileTypeRepository.findOne(id));
	}

	@Override
	public List<ProfileTypeBean> findAllProfileTypes() {
		return EntityConverter.toBeanList(profileTypeRepository.findAll());
	}

	@Override
	public Boolean deleteStaffById(Long staffId) {
		return staffRepository.deleteCheck(staffId);
	}

	@Override
	public Boolean deleteStaffRoleById(Long staffRoleId) {
		return staffRoleRepository.deleteCheck(staffRoleId);
	}

	@Override
	public Boolean deleteStaffTypeById(Long staffTypeId) {
		return staffTypeRepository.deleteCheck(staffTypeId);
	}

	@Override
	public Boolean deleteProfileTypeById(Long profileTypeId) {
		return profileTypeRepository.deleteCheck(profileTypeId);
	}

}
