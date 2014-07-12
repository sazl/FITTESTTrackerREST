package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.repository.custom.StaffRoleRepositoryCustom;

public interface StaffRoleRepository extends CrudRepository<StaffRole, Long>,
		StaffRoleRepositoryCustom {

}
