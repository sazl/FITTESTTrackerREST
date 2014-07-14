package org.wfp.fittest.repository;

import org.wfp.fittest.entity.Country;
import org.wfp.fittest.repository.custom.CountryRepositoryCustom;
import org.wfp.fittest.utility.AbstractRepository;

public interface CountryRepository extends AbstractRepository<Country, Long>,
		CountryRepositoryCustom {
	public Country findByISOCode(String code);
}
