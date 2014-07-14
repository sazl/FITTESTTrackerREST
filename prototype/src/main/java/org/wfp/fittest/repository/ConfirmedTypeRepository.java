package org.wfp.fittest.repository;

import java.util.List;

import org.wfp.fittest.entity.ConfirmedType;
import org.wfp.fittest.repository.custom.ConfirmedTypeRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

public interface ConfirmedTypeRepository extends
		AbstractRepository<ConfirmedType, Long>, ConfirmedTypeRepositoryCustom {

	public List<ConfirmedType> findByConfirmedType(String confirmedType);
}
