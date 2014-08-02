package org.wfp.fittest.dto;

import java.util.List;

public class CountryDto extends AbstractDto {

	private Long id;
	private String isoCode;
	private String fullName;
	private String region;
	private List<Long> staffByNationalityIds;
	private List<Long> activityIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Long> getStaffByNationalityIds() {
		return staffByNationalityIds;
	}

	public void setStaffByNationalityIds(List<Long> staffByNationalityIds) {
		this.staffByNationalityIds = staffByNationalityIds;
	}

	public List<Long> getActivityIds() {
		return activityIds;
	}

	public void setActivityIds(List<Long> activityIds) {
		this.activityIds = activityIds;
	}

}
