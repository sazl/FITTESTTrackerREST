package org.wfp.fittest.dto;

import java.util.ArrayList;
import java.util.List;

public class ActivityDto extends AbstractDto {
	private Long id;
	private String description;
	private String etcServiceMap;

	private ConfirmedTypeDto confirmedTypeDto = new ConfirmedTypeDto();
	private ActivityTypeDto activityTypeDto = new ActivityTypeDto();
	private List<CountryDto> countryDtos = new ArrayList<CountryDto>();
	private List<ActivityRoleDto> activityRoleDtos = new ArrayList<ActivityRoleDto>();

	private String confirmedTypeDescription;
	private String confirmedTypeColorCode;
	private String activityTypeDescription;
	private List<String> countryNames;
	private List<String> activityRoleProfileTypeDescriptions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtcServiceMap() {
		return etcServiceMap;
	}

	public void setEtcServiceMap(String etcServiceMap) {
		this.etcServiceMap = etcServiceMap;
	}

	public ConfirmedTypeDto getConfirmedTypeDto() {
		return confirmedTypeDto;
	}

	public void setConfirmedTypeDto(ConfirmedTypeDto confirmedTypeDto) {
		this.confirmedTypeDto = confirmedTypeDto;
	}

	public ActivityTypeDto getActivityTypeDto() {
		return activityTypeDto;
	}

	public void setActivityTypeDto(ActivityTypeDto activityTypeDto) {
		this.activityTypeDto = activityTypeDto;
	}

	public List<CountryDto> getCountryDtos() {
		return countryDtos;
	}

	public void setCountryDtos(List<CountryDto> countryDtos) {
		this.countryDtos = countryDtos;
	}

	public List<ActivityRoleDto> getActivityRoleDtos() {
		return activityRoleDtos;
	}

	public void setActivityRoleDtos(List<ActivityRoleDto> activityRoleDtos) {
		this.activityRoleDtos = activityRoleDtos;
	}

	public String getConfirmedTypeDescription() {
		return confirmedTypeDescription;
	}

	public void setConfirmedTypeDescription(String confirmedTypeDescription) {
		this.confirmedTypeDescription = confirmedTypeDescription;
	}

	public String getConfirmedTypeColorCode() {
		return confirmedTypeColorCode;
	}

	public void setConfirmedTypeColorCode(String confirmedTypeColorCode) {
		this.confirmedTypeColorCode = confirmedTypeColorCode;
	}

	public String getActivityTypeDescription() {
		return activityTypeDescription;
	}

	public void setActivityTypeDescription(String activityTypeDescription) {
		this.activityTypeDescription = activityTypeDescription;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public List<String> getActivityRoleProfileTypeDescriptions() {
		return activityRoleProfileTypeDescriptions;
	}

	public void setActivityRoleProfileTypeDescriptions(
			List<String> activityRoleProfileTypeDescriptions) {
		this.activityRoleProfileTypeDescriptions = activityRoleProfileTypeDescriptions;
	}
	
	@Override
	public String toString() {
		return description;
	}

}
