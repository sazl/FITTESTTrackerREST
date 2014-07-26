package org.wfp.fittest.dto;

import java.util.List;

public class ActivityDto extends AbstractDto {
	private Long id;
	private String description;
	private String etcServiceMap;

	private Long confirmedTypeId;
	private Long activityTypeId;
	private List<Long> countryIds;
	private List<Long> activityRoleIds;

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

	public Long getConfirmedTypeId() {
		return confirmedTypeId;
	}

	public void setConfirmedTypeId(Long confirmedTypeId) {
		this.confirmedTypeId = confirmedTypeId;
	}

	public Long getActivityTypeId() {
		return activityTypeId;
	}

	public void setActivityTypeId(Long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public List<Long> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Long> countryIds) {
		this.countryIds = countryIds;
	}

	public List<Long> getActivityRoleIds() {
		return activityRoleIds;
	}

	public void setActivityRoleIds(List<Long> activityRoleIds) {
		this.activityRoleIds = activityRoleIds;
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

}
