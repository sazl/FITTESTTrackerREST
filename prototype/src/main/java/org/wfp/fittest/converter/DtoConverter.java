package org.wfp.fittest.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.dto.AbstractDto;
import org.wfp.fittest.dto.ActivityDto;
import org.wfp.fittest.dto.ActivityRoleDto;
import org.wfp.fittest.dto.ActivityTypeDto;
import org.wfp.fittest.dto.ConfirmedTypeDto;
import org.wfp.fittest.dto.CountryDto;
import org.wfp.fittest.dto.LanguageDto;
import org.wfp.fittest.dto.ProfileTypeDto;
import org.wfp.fittest.dto.StaffDto;
import org.wfp.fittest.dto.StaffRoleDto;
import org.wfp.fittest.dto.StaffTypeDto;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.entity.ActivityRole;
import org.wfp.fittest.entity.EntityId;
import org.wfp.fittest.entity.Staff;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.repository.ActivityRepository;
import org.wfp.fittest.repository.ConfirmedTypeRepository;
import org.wfp.fittest.repository.CountryRepository;
import org.wfp.fittest.repository.StaffRepository;

@Service
@Transactional(readOnly = true)
public class DtoConverter {

	@Autowired
	private ActivityRepository activityRepsository;
	@Autowired
	private ConfirmedTypeRepository confirmedTypeRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StaffRepository staffRepository;

	public <D extends AbstractDto, E extends EntityId> D entityToDto(E entity) {
		return EntityConverter.toBean(entity);
	}

	public <D extends AbstractDto, E extends EntityId> List<D> entitiesToDtos(
			Iterable<E> entities) {
		return EntityConverter.toBeanList(entities);
	}

	@SuppressWarnings("unchecked")
	public ActivityDto entityToDtoNested(Activity activity) {
		ActivityDto activityDto = entityToDto(activity);
		activityDto.setConfirmedTypeDto((ConfirmedTypeDto) entityToDto(activity
				.getConfirmedType()));
		activityDto.setActivityTypeDto((ActivityTypeDto) entityToDto(activity
				.getActivityType()));
		activityDto
				.setActivityRoleDtos((List<ActivityRoleDto>) (List<?>) entitiesToDtos(activity
						.getActivityRoles()));
		activityDto
				.setCountryDtos((List<CountryDto>) (List<?>) entitiesToDtos(activity
						.getCountries()));
		return activityDto;
	}

	@SuppressWarnings("unchecked")
	public ActivityRoleDto entityToDtoNested(ActivityRole activityRole) {
		ActivityRoleDto activityRoleDto = entityToDto(activityRole);
		activityRoleDto.setActivityDto((ActivityDto) entityToDto(activityRole
				.getActivity()));
		activityRoleDto
				.setProfileTypeDto((ProfileTypeDto) entityToDto(activityRole
						.getProfileType()));
		activityRoleDto
				.setStaffRoleDtos((List<StaffRoleDto>) (List<?>) entitiesToDtos(activityRole
						.getStaffRoles()));
		return activityRoleDto;
	}

	@SuppressWarnings("unchecked")
	public StaffDto entityToDtoNested(Staff staff) {
		StaffDto staffDto = entityToDto(staff);
		staffDto.setStaffTypeDto((StaffTypeDto) entityToDto(staff
				.getStaffType()));
		staffDto.setLanguageDtos((List<LanguageDto>) (List<?>) entitiesToDtos(staff
				.getLanguages()));
		staffDto.setNationalityDtos((List<CountryDto>) (List<?>) entitiesToDtos(staff
				.getNationalities()));
		staffDto.setProfileTypeDtos((List<ProfileTypeDto>) (List<?>) entitiesToDtos(staff
				.getProfileTypes()));
		staffDto.setStaffRoleDtos((List<StaffRoleDto>) (List<?>) entitiesToDtos(staff
				.getStaffRoles()));
		return staffDto;
	}

	public StaffRoleDto entityToDtoNested(StaffRole staffRole) {
		StaffRoleDto staffRoleDto = entityToDto(staffRole);
		staffRoleDto.setActivityRoleDto((ActivityRoleDto) entityToDto(staffRole
				.getActivityRole()));
		staffRoleDto
				.setConfirmedTypeDto((ConfirmedTypeDto) entityToDto(staffRole
						.getConfirmedType()));
		staffRoleDto.setStaffDto((StaffDto) entityToDto(staffRole.getStaff()));
		return staffRoleDto;
	}
}
