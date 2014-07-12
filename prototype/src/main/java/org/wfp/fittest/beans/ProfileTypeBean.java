package org.wfp.fittest.beans;

import java.util.List;

public class ProfileTypeBean {
	private Long id;
	private String profileType;
	private List<Long> staffIds;
	private List<Long> activityRoleIds;
	
	public ProfileTypeBean() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public List<Long> getStaffIds() {
		return staffIds;
	}

	public void setStaffIds(List<Long> staffIds) {
		this.staffIds = staffIds;
	}

	public List<Long> getActivityRoleIds() {
		return activityRoleIds;
	}

	public void setActivityRoleIds(List<Long> activityRoleIds) {
		this.activityRoleIds = activityRoleIds;
	}
	
	
}
