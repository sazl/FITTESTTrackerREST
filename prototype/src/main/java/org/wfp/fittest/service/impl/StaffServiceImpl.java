package org.wfp.fittest.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.beans.ProfileTypeBean;
import org.wfp.fittest.beans.RequirementCriteriaBean;
import org.wfp.fittest.beans.StaffBean;
import org.wfp.fittest.beans.StaffRoleBean;
import org.wfp.fittest.beans.StaffTypeBean;
import org.wfp.fittest.converter.EntityConverter;
import org.wfp.fittest.entity.Country;
import org.wfp.fittest.entity.Language;
import org.wfp.fittest.entity.ProfileType;
import org.wfp.fittest.entity.Staff;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ActivityRoleRepository;
import org.wfp.fittest.repository.ActivityTypeRepository;
import org.wfp.fittest.repository.ConfirmedTypeRepository;
import org.wfp.fittest.repository.CountryRepository;
import org.wfp.fittest.repository.EventRepository;
import org.wfp.fittest.repository.LanguageRepository;
import org.wfp.fittest.repository.ProfileTypeRepository;
import org.wfp.fittest.repository.StaffRepository;
import org.wfp.fittest.repository.StaffRoleRepository;
import org.wfp.fittest.repository.StaffTypeRepository;
import org.wfp.fittest.service.StaffService;

@Service
@Transactional(readOnly = true)
public class StaffServiceImpl implements StaffService {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActivityRoleRepository activityRoleRepository;

	@Autowired
	private ActivityTypeRepository activityTypeRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ConfirmedTypeRepository confirmedTypeRepository;

	@Autowired
	private ProfileTypeRepository profileTypeRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffRoleRepository staffRoleRepository;

	@Autowired
	private StaffTypeRepository staffTypeRepository;

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
	@Transactional(readOnly = false)
	public Boolean deleteStaffById(Long staffId) {
		return staffRepository.deleteCheck(staffId);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteStaffRoleById(Long staffRoleId) {
		return staffRoleRepository.deleteCheck(staffRoleId);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteStaffTypeById(Long staffTypeId) {
		return staffTypeRepository.deleteCheck(staffTypeId);
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteProfileTypeById(Long profileTypeId) {
		return profileTypeRepository.deleteCheck(profileTypeId);
	}

	@Override
	@Transactional(readOnly = false)
	public StaffBean saveOrUpdateStaff(StaffBean staffBean) {
		Staff staff = EntityConverter.toEntity(staffBean);
//		staff.setStaffType(staffTypeRepository.findOne(staffBean
//				.getStaffTypeId()));
//		staff.setProfileTypes(new HashSet<ProfileType>(profileTypeRepository
//				.findAll(staffBean.getProfileTypeIds())));
//		staff.setNationalities(new HashSet<Country>(countryRepository
//				.findAll(staffBean.getNationalityIds())));
//		staff.setLanguages(new HashSet<Language>(languageRepository
//				.findAll(staffBean.getLanguageIds())));
//		staff.setStaffRoles(new HashSet<StaffRole>(staffRoleRepository
//				.findAll(staffBean.getStaffRoleIds())));
//		return EntityConverter.toBean(staffRepository.save(staff));
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public StaffRoleBean saveOrUpdateStaffRole(StaffRoleBean staffRoleBean) {
//		StaffRole staffRole = EntityConverter.toEntity(staffRoleBean);
//		staffRole.setConfirmedType(confirmedTypeRepository.findOne(staffRole
//				.getConfirmedTypeId()));
//		staffRole.setActivityRole(activityRoleRepository.findOne(staffRoleBean
//				.getActivityRoleId()));
//		staffRole.setStaff(new HashSet<Staff>(staffRepository
//				.findAll(staffRoleBean.getStaffIds())));
//		return EntityConverter.toBean(staffRoleRepository.save(staffRole));
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public StaffTypeBean saveOrUpdateStaffType(StaffTypeBean staffTypeBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public ProfileTypeBean saveOrUpdateProfileType(
			ProfileTypeBean profileTypeBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffBean> findStaffRequirements(
			RequirementCriteriaBean criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StaffRoleBean> findStaffRolesByIds(List<Long> ids) {
		return EntityConverter.toBeanList(staffRoleRepository.findAll(ids));
	}

}
