package org.wfp.fittest.beans;

import java.util.List;

public class ConfirmedTypeBean {
	private Long id;
	private String confirmedType;
	private String confirmedColorCode;
	private List<Long> staffRoleIds;
	private List<Long> activityRoleIds;
	
	public ConfirmedTypeBean() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmedType() {
		return confirmedType;
	}

	public void setConfirmedType(String confirmedType) {
		this.confirmedType = confirmedType;
	}

	public String getConfirmedColorCode() {
		return confirmedColorCode;
	}

	public void setConfirmedColorCode(String confirmedColorCode) {
		this.confirmedColorCode = confirmedColorCode;
	}

	public List<Long> getStaffRoleIds() {
		return staffRoleIds;
	}

	public void setStaffRoleIds(List<Long> staffRoleIds) {
		this.staffRoleIds = staffRoleIds;
	}

	public List<Long> getActivityRoleIds() {
		return activityRoleIds;
	}

	public void setActivityRoleIds(List<Long> activityRoleIds) {
		this.activityRoleIds = activityRoleIds;
	}
	
}
