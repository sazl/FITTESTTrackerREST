package org.wfp.fittest.beans;

import java.util.List;

public class StaffTypeBean {
	private Long id;
	private String staffType;
	private List<Long> staffIds;

	public StaffTypeBean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	
	public List<Long> getStaffIds() {
		return staffIds;
	}

	public void setStaffIds(List<Long> staffIds) {
		this.staffIds = staffIds;
	}
}
