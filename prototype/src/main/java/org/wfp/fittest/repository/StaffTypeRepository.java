package org.wfp.fittest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wfp.fittest.entity.StaffType;
import org.wfp.fittest.repository.custom.StaffTypeRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

@RepositoryRestResource(path = "staffTypes")
public interface StaffTypeRepository extends
		AbstractRepository<StaffType, Long>, StaffTypeRepositoryCustom {

}
