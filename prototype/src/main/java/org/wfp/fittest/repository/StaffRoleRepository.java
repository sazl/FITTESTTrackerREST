package org.wfp.fittest.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wfp.fittest.entity.StaffRole;
import org.wfp.fittest.repository.custom.StaffRoleRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

@RepositoryRestResource(path = "staffRoles")
public interface StaffRoleRepository extends
		AbstractRepository<StaffRole, Long>, StaffRoleRepositoryCustom {

}
