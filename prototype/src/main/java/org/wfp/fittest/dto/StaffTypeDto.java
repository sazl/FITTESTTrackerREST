package org.wfp.fittest.dto;

import java.util.ArrayList;
import java.util.List;

public class StaffTypeDto extends AbstractDto {
	private Long id;
	private String staffType;
	
	private List<StaffDto> staffDto = new ArrayList<>();

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

	public List<StaffDto> getStaffDto() {
		return staffDto;
	}

	public void setStaffDto(List<StaffDto> staffDto) {
		this.staffDto = staffDto;
	}
	
	@Override
	public String toString() {
		return staffType;
	}
	
}
