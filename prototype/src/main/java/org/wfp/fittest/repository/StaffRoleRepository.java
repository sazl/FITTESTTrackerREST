package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.utility.AbstractRepository;

@RepositoryRestResource(path = "staffRoles")
public interface StaffRoleRepository extends
		AbstractRepository<StaffRole, Long> {

	@Query("select sr from StaffRole sr where :startDate >= sr.startDate"
			+ " and :endDate <= sr.endDate"
			+ " and :activityId = sr.activityRole.activity.id"
			+ " and :staffTypeId = sr.staff.staffType.id")
	List<StaffRole> findDeployments(@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			@Param("activityId") Long activityId,
			@Param("staffTypeId") Long staffTypeId);
}
