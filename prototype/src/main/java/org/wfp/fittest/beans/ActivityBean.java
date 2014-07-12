package org.wfp.fittest.beans;

import java.util.List;

public class ActivityBean {
	private Long id;
	private String description;
	private String etcServiceMap;
	private Long activityTypeId;
	private Long confirmedTypeId;
	private List<Long> countryIds;
	private List<Long> activityRoleIds;

	public ActivityBean() {

	}

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

	public Long getActivityTypeId() {
		return activityTypeId;
	}

	public void setActivityTypeId(Long activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public Long getConfirmedTypeId() {
		return confirmedTypeId;
	}

	public void setConfirmedTypeId(Long confirmedTypeId) {
		this.confirmedTypeId = confirmedTypeId;
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

}
