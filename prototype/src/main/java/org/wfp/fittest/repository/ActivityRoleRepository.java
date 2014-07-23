package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wfp.fittest.entity.ActivityRole;
import org.wfp.fittest.utility.AbstractRepository;

@RepositoryRestResource(path = "activityRoles")
public interface ActivityRoleRepository extends
		AbstractRepository<ActivityRole, Long> {

	public List<ActivityRole> findByActivity_Id(
			@Param("activityId") Long activityId);

	public List<ActivityRole> findByStartDateAfter(Date startDate);

	public List<ActivityRole> findByEndDateBefore(Date endDate);

	public List<ActivityRole> findByStartDateBetween(Date startDate,
			Date endDate);

	public List<ActivityRole> findByEndDateBetween(Date startDate, Date endDate);

	public List<ActivityRole> findByLocation(String activityRoleLocation);

	public void deleteByLocation(String activityRoleLocation);
}
