package org.wfp.fittest.service;

import java.util.List;

import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.EventBean;


public interface ActivityService {
	public ActivityBean findActivityById(Long id);
	
	public List<ActivityBean> findAllActivities();
	
	public Boolean deleteActivityById(Long id);	
	
	public ActivityTypeBean findActivityTypeById(Long id);

	public List<ActivityTypeBean> findAllActivityTypes();
	
	public Boolean deleteActivityTypeById(Long id);
	
	public ActivityRoleBean findActivityRoleById(Long id);
	
	public List<ActivityRoleBean> findAllActivityRoles();

	public Boolean deleteActivityRoleById(Long id);
	
	public EventBean findEventById(Long id);
	
	public List<EventBean> findAllEvents();
	
	public Boolean deleteEventById(Long id);
}
