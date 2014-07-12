package org.wfp.fittest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.entity.ActivityType;
import org.wfp.fittest.entity.ConfirmedType;
import org.wfp.fittest.repository.custom.ActivityRepositoryCustom;

public interface ActivityRepository extends CrudRepository<Activity, Long>,
		ActivityRepositoryCustom {

	public List<Activity> findByConfirmedType(ConfirmedType confirmedType);

	public List<Activity> findByActivityType(ActivityType activityType);

	public List<Activity> findByDescription(String description);

	public void deleteByActivityType(ActivityType activityType);

	public void deleteByDescription(String description);
}
