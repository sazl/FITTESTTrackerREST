package org.wfp.fittest.beans;

import java.util.Date;
import java.util.List;

public class DeploymentCriteriaBean {
	private Boolean confirmedOnly;
	private Date startDate;
	private Date endDate;
	private List<ActivityBean> activities;
	private List<StaffTypeBean> staffTypes;

	public Boolean getConfirmedOnly() {
		return confirmedOnly;
	}

	public void setConfirmedOnly(Boolean confirmedOnly) {
		this.confirmedOnly = confirmedOnly;
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

	public List<ActivityBean> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityBean> activities) {
		this.activities = activities;
	}

	public List<StaffTypeBean> getStaffTypes() {
		return staffTypes;
	}

	public void setStaffTypes(List<StaffTypeBean> staffTypes) {
		this.staffTypes = staffTypes;
	}
}
