package org.wfp.fittest.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ActivityTypeBean {
	private Long id;
	private String activityType;
	private String colorCode;
	private List<ActivityBean> activityBeans;
	private List<Long> activityIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<Long> getActivityIds() {
		return activityIds;
	}

	public void setActivityIds(List<Long> activityIds) {
		this.activityIds = activityIds;
	}

	@JsonIgnore
	public List<ActivityBean> getActivityBeans() {
		return activityBeans;
	}

	public void setActivityBeans(List<ActivityBean> activityBeans) {
		this.activityBeans = activityBeans;
	}

}
