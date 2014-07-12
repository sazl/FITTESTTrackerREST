package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.StaffType;
import org.wfp.fittest.repository.custom.StaffTypeRepositoryCustom;

public interface StaffTypeRepository extends CrudRepository<StaffType, Long>,
		StaffTypeRepositoryCustom {
}
