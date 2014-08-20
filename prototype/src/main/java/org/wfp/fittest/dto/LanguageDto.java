package org.wfp.fittest.dto;

import java.util.List;

public class LanguageDto extends AbstractDto {
	private Long id;
	private String language;
	
	private List<Long> staffByLanguageIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Long> getStaffByLanguageIds() {
		return staffByLanguageIds;
	}

	public void setStaffByLanguageIds(List<Long> staffByLanguageIds) {
		this.staffByLanguageIds = staffByLanguageIds;
	}
	
	@Override
	public String toString() {
		return language;
	}

}
