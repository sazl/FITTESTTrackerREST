package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.OperationType;
import org.wfp.fittest.repository.custom.OperationTypeRepositoryCustom;

public interface OperationTypeRepository extends
		CrudRepository<OperationType, Long>, OperationTypeRepositoryCustom {
}
