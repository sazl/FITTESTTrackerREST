package org.wfp.fittest.repository;

import org.wfp.fittest.entity.ProfileType;
import org.wfp.fittest.repository.custom.ProfileTypeRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

public interface ProfileTypeRepository extends
		AbstractRepository<ProfileType, Long>, ProfileTypeRepositoryCustom {

}
