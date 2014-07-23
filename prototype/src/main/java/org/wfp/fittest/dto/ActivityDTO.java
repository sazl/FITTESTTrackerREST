package org.wfp.fittest.dto;

import java.util.HashSet;
import java.util.Set;

import org.wfp.fittest.entity.ActivityRole;
import org.wfp.fittest.entity.ActivityType;
import org.wfp.fittest.entity.ConfirmedType;
import org.wfp.fittest.entity.Country;

public class ActivityDTO {
	private Long id;
	private String description;
	private ActivityType activityType;
	private String etcServiceMap;
	private Set<Country> countries = new HashSet<Country>();
	private Set<ActivityRole> activityRoles = new HashSet<ActivityRole>();
	private ConfirmedType confirmedType;
}
