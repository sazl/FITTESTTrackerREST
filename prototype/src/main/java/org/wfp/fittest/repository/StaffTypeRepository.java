package org.wfp.fittest.repository;

import org.wfp.fittest.entity.StaffType;
import org.wfp.fittest.repository.custom.StaffTypeRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

public interface StaffTypeRepository extends
		AbstractRepository<StaffType, Long>, StaffTypeRepositoryCustom {

}
