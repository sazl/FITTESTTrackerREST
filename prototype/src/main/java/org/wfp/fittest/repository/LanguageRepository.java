package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.Language;
import org.wfp.fittest.repository.custom.LanguageRepositoryCustom;

public interface LanguageRepository extends CrudRepository<Language, Long>,
		LanguageRepositoryCustom {
}
