package org.wfp.fittest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.ConfirmedType;
import org.wfp.fittest.repository.custom.ConfirmedTypeRepositoryCustom;

public interface ConfirmedTypeRepository extends
		CrudRepository<ConfirmedType, Long>, ConfirmedTypeRepositoryCustom {
	public List<ConfirmedType> findByConfirmedType(String confirmedType);
}
