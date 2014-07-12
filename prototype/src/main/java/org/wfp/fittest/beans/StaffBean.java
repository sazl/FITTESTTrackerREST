package org.wfp.fittest.beans;

import java.util.Date;
import java.util.List;

public class StaffBean {
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String title;
	private String mobile;
	private String thuraya;
	private String staffColorCode;
	private Long staffTypeId;
	private List<Long> profileTypeIds;
	private List<Long> nationalityIds;
	private List<Long> languageIds;
	private List<Long> staffRoleIds;

	public StaffBean() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getThuraya() {
		return thuraya;
	}

	public void setThuraya(String thuraya) {
		this.thuraya = thuraya;
	}

	public String getStaffColorCode() {
		return staffColorCode;
	}

	public void setStaffColorCode(String staffColorCode) {
		this.staffColorCode = staffColorCode;
	}

	public Long getStaffTypeId() {
		return staffTypeId;
	}

	public void setStaffTypeId(Long staffTypeId) {
		this.staffTypeId = staffTypeId;
	}

	public List<Long> getProfileTypeIds() {
		return profileTypeIds;
	}

	public void setProfileTypeIds(List<Long> profileTypeIds) {
		this.profileTypeIds = profileTypeIds;
	}

	public List<Long> getNationalityIds() {
		return nationalityIds;
	}

	public void setNationalityIds(List<Long> nationalityIds) {
		this.nationalityIds = nationalityIds;
	}

	public List<Long> getLanguageIds() {
		return languageIds;
	}

	public void setLanguageIds(List<Long> languageIds) {
		this.languageIds = languageIds;
	}

	public List<Long> getStaffRoleIds() {
		return staffRoleIds;
	}

	public void setStaffRoleIds(List<Long> staffRoleIds) {
		this.staffRoleIds = staffRoleIds;
	}

}
