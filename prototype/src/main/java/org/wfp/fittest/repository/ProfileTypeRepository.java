package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.ProfileType;
import org.wfp.fittest.repository.custom.ProfileTypeRepositoryCustom;

public interface ProfileTypeRepository extends
		CrudRepository<ProfileType, Long>, ProfileTypeRepositoryCustom {
}
