package org.wfp.fittest.beans;

import java.util.Date;
import java.util.List;

public class StaffRoleBean {
	private Long id;
	private Date startDate;
	private Date endDate;
	private String location;
	private String comments;
	private Long confirmedTypeId;
	private Long activityRoleId;
	private List<Long> staffIds;

	public StaffRoleBean() {

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getConfirmedTypeId() {
		return confirmedTypeId;
	}

	public void setConfirmedTypeId(Long confirmedTypeId) {
		this.confirmedTypeId = confirmedTypeId;
	}

	public Long getActivityRoleId() {
		return activityRoleId;
	}

	public void setActivityRoleId(Long activityRoleId) {
		this.activityRoleId = activityRoleId;
	}

	public List<Long> getStaffIds() {
		return staffIds;
	}

	public void setStaffIds(List<Long> staffIds) {
		this.staffIds = staffIds;
	}

}
