package org.wfp.fittest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.ActivityType;
import org.wfp.fittest.repository.custom.ActivityTypeRepositoryCustom;

public interface ActivityTypeRepository extends
		CrudRepository<ActivityType, Long>, ActivityTypeRepositoryCustom {
	
	public List<ActivityType> findByActivityType(String activityType);
		
	public List<ActivityType> findByColorCode(String colorCode);

	public void deleteByActivityType(String activityType);

	public void deleteByColorCode(String colorCode);
}
