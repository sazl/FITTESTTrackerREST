package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.converter.DtoConverter;
import org.wfp.fittest.dto.StaffDto;
import org.wfp.fittest.dto.StaffRoleDto;
import org.wfp.fittest.repository.StaffRepository;
import org.wfp.fittest.repository.StaffRoleRepository;
import org.wfp.fittest.service.StaffService;

@Service
@Transactional(readOnly = true)
public class StaffServiceImpl implements StaffService {

	@Autowired private DtoConverter converter;
	
	@Autowired private StaffRepository staffRepository;
	@Autowired private StaffRoleRepository staffRoleRepository;
	
	@Override
	public List<StaffDto> findAllStaff() {
		return converter.entitiesToDtos(staffRepository.findAll());
	}

	@Override
	public List<StaffRoleDto> findAllStaffRoles() {
		return converter.entitiesToDtos(staffRoleRepository.findAll());
	}
}
