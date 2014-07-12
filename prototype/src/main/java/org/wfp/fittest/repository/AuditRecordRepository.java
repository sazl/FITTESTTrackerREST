package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.AuditRecord;
import org.wfp.fittest.repository.custom.AuditRecordRepositoryCustom;

public interface AuditRecordRepository extends
		CrudRepository<AuditRecord, Long>, AuditRecordRepositoryCustom {
}
