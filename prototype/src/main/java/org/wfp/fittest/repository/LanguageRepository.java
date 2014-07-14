package org.wfp.fittest.repository;

import org.wfp.fittest.entity.Language;
import org.wfp.fittest.repository.custom.LanguageRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

public interface LanguageRepository extends AbstractRepository<Language, Long>,
		LanguageRepositoryCustom {

}
