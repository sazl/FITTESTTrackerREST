package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.utility.AbstractRepository;

@RepositoryRestResource(path = "staffRoles")
public interface StaffRoleRepository extends
		AbstractRepository<StaffRole, Long> {

	@Query("select sr from StaffRole sr where sr.startDate >= :startDate"
			+ " and  sr.endDate <= :endDate"
			+ " and sr.activityRole.activity.id in :activityIds"
			+ " and sr.staff.staffType.id in :staffTypeIds")
	List<StaffRole> findDeployments(@Param("startDate") @DateTimeFormat(iso = ISO.DATE) Date startDate,
			@Param("endDate") @DateTimeFormat(iso = ISO.DATE) Date endDate,
			@Param("activityIds") List<Long> activityIds,
			@Param("staffTypeIds") List<Long> staffTypeIds);
}
