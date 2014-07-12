package org.wfp.fittest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.Staff;
import org.wfp.fittest.entity.StaffType;
import org.wfp.fittest.repository.custom.StaffRepositoryCustom;

public interface StaffRepository extends CrudRepository<Staff, Long>,
		StaffRepositoryCustom {

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

}
