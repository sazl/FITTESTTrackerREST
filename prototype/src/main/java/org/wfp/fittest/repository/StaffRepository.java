package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;
import org.wfp.fittest.entity.Staff;
import org.wfp.fittest.entity.StaffType;
import org.wfp.fittest.utility.AbstractRepository;

@Repository
@RepositoryRestResource(path = "staff", collectionResourceRel = "staff")
public interface StaffRepository extends AbstractRepository<Staff, Long> {

	public List<Staff> findByStaffRoles_Id(
			@Param("staffRoleId") Long staffRoleId);

	@Query("select s from Staff s where s.id in :ids")
	public List<Staff> findByIds(@Param("ids") List<Long> ids);

	public List<Staff> findByFirstName(String firstName);

	public List<Staff> findByLastName(String lastName);

	public List<Staff> findByFirstNameAndLastName(String firstName,
			String lastName);

	public List<Staff> findByTitle(String title);

	public List<Staff> findByMobile(String mobile);

	public List<Staff> findByThuraya(String thuraya);

	public List<Staff> findByDateOfBirth(Date dateOfBirth);

	public List<Staff> findByStaffType(StaffType staffType);

	public List<Staff> findByStaffColorCode(String colorCode);

	@Query("select distinct(s) from Staff s"
			+ " join s.staffRoles sr"
			+ " join sr.activityRole ar"
			+ " join ar.activity act"
			+ " join act.activityType at"
		    + " where at.activityType = :activityType"
			+ " and sr.startDate <= :date"
		    + " and sr.endDate >= :date")
	public List<Staff> findByActivityTypeInDate(
			@Param("activityType") String activityType,
			@Param("date") @DateTimeFormat(iso = ISO.DATE) Date date);

}
