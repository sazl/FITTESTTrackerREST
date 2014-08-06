package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.converter.DtoConverter;
import org.wfp.fittest.dto.ProfileTypeDto;
import org.wfp.fittest.dto.StaffDto;
import org.wfp.fittest.dto.StaffRoleDto;
import org.wfp.fittest.dto.StaffTypeDto;
import org.wfp.fittest.repository.ProfileTypeRepository;
import org.wfp.fittest.repository.StaffRepository;
import org.wfp.fittest.repository.StaffRoleRepository;
import org.wfp.fittest.repository.StaffTypeRepository;
import org.wfp.fittest.service.StaffService;

@Service
@Transactional(readOnly = true)
public class StaffServiceImpl implements StaffService {

	@Autowired
	private DtoConverter converter;

	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private StaffRoleRepository staffRoleRepository;
	@Autowired
	private StaffTypeRepository staffTypeRepository;
	@Autowired
	private ProfileTypeRepository profileTypeRepository;

	@Override
	public StaffDto findStaffNested(Long staffId) {
		return converter.entityToDtoNested(staffRepository.findOne(staffId));
	}

	@Override
	public List<StaffDto> findAllStaff() {
		return converter.entitiesToDtos(staffRepository.findAll());
	}

	@Override
	public StaffRoleDto findStaffRoleNested(Long staffRoleId) {
		return converter.entityToDtoNested(staffRoleRepository
				.findOne(staffRoleId));
	}

	@Override
	public List<StaffRoleDto> findAllStaffRoles() {
		return converter.entitiesToDtos(staffRoleRepository.findAll());
	}

	@Override
	public List<StaffDto> findBISStaff() {
		return null;
	}

	@Override
	public StaffDto findStaffById(Long staffId) {
		return converter.entityToDto(staffRepository.findOne(staffId));
	}

	@Override
	public List<ProfileTypeDto> findAllProfileTypes() {
		return converter.entitiesToDtos(profileTypeRepository.findAll());
	}

	@Override
	public List<StaffTypeDto> findAllStaffTypes() {
		return converter.entitiesToDtos(staffTypeRepository.findAll());
	}
}
