package org.wfp.fittest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.wfp.fittest.entity.ProfileType;
import org.wfp.fittest.utility.AbstractRepository;

@RepositoryRestResource(path = "profileTypes")
public interface ProfileTypeRepository extends
		AbstractRepository<ProfileType, Long> {

}
