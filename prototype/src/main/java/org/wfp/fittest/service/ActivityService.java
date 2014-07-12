package org.wfp.fittest.service;

import org.wfp.fittest.beans.ActivityBean;
import org.wfp.fittest.beans.ActivityRoleBean;
import org.wfp.fittest.beans.ActivityTypeBean;
import org.wfp.fittest.beans.EventBean;
import org.wfp.fittest.utility.BeanListWrapper;


public interface ActivityService {
	public ActivityBean findActivityById(Long id);
	
	public BeanListWrapper<ActivityBean> findAllActivities();
	
	public ActivityTypeBean findActivityTypeById(Long id);

	public BeanListWrapper<ActivityTypeBean> findAllActivityTypes();
	
	public ActivityRoleBean findActivityRoleById(Long id);
	
	public BeanListWrapper<ActivityRoleBean> findAllActivityRoles();
	
	public EventBean findEventById(Long id);
	
	public BeanListWrapper<EventBean> findAllEvents();
}
