package org.wfp.fittest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityRoleDto extends AbstractDto {
	private Long Id;

	private Date startDate;
	private Date endDate;
	private String location;

	private ActivityDto activityDto = new ActivityDto();
	private ProfileTypeDto profileTypeDto = new ProfileTypeDto();
	private List<StaffRoleDto> staffRoleDtos = new ArrayList<StaffRoleDto>();

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

	public ActivityDto getActivityDto() {
		return activityDto;
	}

	public void setActivityDto(ActivityDto activityDto) {
		this.activityDto = activityDto;
	}

	public ProfileTypeDto getProfileTypeDto() {
		return profileTypeDto;
	}

	public void setProfileTypeDto(ProfileTypeDto profileTypeDto) {
		this.profileTypeDto = profileTypeDto;
	}

	public List<StaffRoleDto> getStaffRoleDtos() {
		return staffRoleDtos;
	}

	public void setStaffRoleDtos(List<StaffRoleDto> staffRoleDtos) {
		this.staffRoleDtos = staffRoleDtos;
	}
	
	@Override
	public String toString() {
		return activityDescription + " | " + profileTypeDescription;
	}
}
