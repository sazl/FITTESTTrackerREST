package org.wfp.fittest.dto;

import java.util.Date;
import java.util.List;

public class ActivityRoleDto extends AbstractDto {
	private Long Id;

	private Date startDate;
	private Date endDate;
	private String location;

	private Long activityId;
	private Long profileTypeId;
	private List<Long> staffRoleIds;

	private String activityDescription;
	private String profileTypeDescription;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getProfileTypeDescription() {
		return profileTypeDescription;
	}

	public void setProfileTypeDescription(String profileTypeDescription) {
		this.profileTypeDescription = profileTypeDescription;
	}
}
