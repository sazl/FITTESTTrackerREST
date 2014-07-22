package org.wfp.fittest.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ActivityBean {
	private Long id;
	private String description;
	private String etcServiceMap;

	private Long activityTypeId;
	private ActivityTypeBean activityType;

	private Long confirmedTypeId;
	private ConfirmedTypeBean confirmedType;

	private List<Long> countryIds;
	private List<CountryBean> countries;
	private List<Long> activityRoleIds;
	private List<ActivityRoleBean> activityRoles;

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
	
	@JsonIgnore
	public ActivityTypeBean getActivityTypeBean() {
		return activityType;
	}

	public void setActivityTypeBean(ActivityTypeBean activityType) {
		this.activityType = activityType;
	}

	public Long getConfirmedTypeId() {
		return confirmedTypeId;
	}

	public void setConfirmedTypeId(Long confirmedTypeId) {
		this.confirmedTypeId = confirmedTypeId;
	}

	@JsonIgnore
	public ConfirmedTypeBean getConfirmedTypeBean() {
		return confirmedType;
	}

	public void setConfirmedTypeBean(ConfirmedTypeBean confirmedType) {
		this.confirmedType = confirmedType;
	}

	public List<Long> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Long> countryIds) {
		this.countryIds = countryIds;
	}

	@JsonIgnore
	public List<CountryBean> getCountryBeans() {
		return countries;
	}

	public void setCountryBeans(List<CountryBean> countries) {
		this.countries = countries;
	}

	public List<Long> getActivityRoleIds() {
		return activityRoleIds;
	}

	public void setActivityRoleIds(List<Long> activityRoleIds) {
		this.activityRoleIds = activityRoleIds;
	}

	@JsonIgnore
	public List<ActivityRoleBean> getActivityRoleBeans() {
		return activityRoles;
	}

	public void setActivityRoleBeans(List<ActivityRoleBean> activityRoles) {
		this.activityRoles = activityRoles;
	}
}
