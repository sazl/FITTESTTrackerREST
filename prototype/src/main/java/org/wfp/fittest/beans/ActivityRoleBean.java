package org.wfp.fittest.beans;

import java.util.Date;
import java.util.List;

public class ActivityRoleBean {
	private Long       id;
	private Date       startDate;
	private Date       endDate;
	private String     location;
	private Long       activityId;
	private Long       profileTypeId;
	private List<Long> staffRoleIds;

	public ActivityRoleBean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getProfileTypeId() {
		return profileTypeId;
	}

	public void setProfileTypeId(Long profileTypeId) {
		this.profileTypeId = profileTypeId;
	}

	public List<Long> getStaffRoleIds() {
		return staffRoleIds;
	}

	public void setStaffRoleIds(List<Long> staffRoleIds) {
		this.staffRoleIds = staffRoleIds;
	}
	
}
