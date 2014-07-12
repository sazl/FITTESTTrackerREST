package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.ActivityRole;
import org.wfp.fittest.repository.custom.ActivityRoleRepositoryCustom;

public interface ActivityRoleRepository extends
		CrudRepository<ActivityRole, Long>, ActivityRoleRepositoryCustom {

	public List<ActivityRole> findByStartDateAfter(Date startDate);

	public List<ActivityRole> findByEndDateBefore(Date endDate);

	public List<ActivityRole> findByStartDateBetween(Date startDate, Date endDate);

	public List<ActivityRole> findByEndDateBetween(Date startDate, Date endDate);
	
	public List<ActivityRole> findByLocation(String activityRoleLocation);

	public void deleteByLocation(String activityRoleLocation);
}
