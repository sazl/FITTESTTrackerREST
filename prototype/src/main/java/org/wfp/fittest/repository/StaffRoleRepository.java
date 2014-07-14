package org.wfp.fittest.repository;

import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.repository.custom.StaffRoleRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

public interface StaffRoleRepository extends
		AbstractRepository<StaffRole, Long>, StaffRoleRepositoryCustom {

}
