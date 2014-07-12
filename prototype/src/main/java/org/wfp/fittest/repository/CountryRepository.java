package org.wfp.fittest.repository;

import org.springframework.data.repository.CrudRepository;
import org.wfp.fittest.entity.Country;
import org.wfp.fittest.repository.custom.CountryRepositoryCustom;

public interface CountryRepository extends CrudRepository<Country, Long>,
		CountryRepositoryCustom {
	public Country findByISOCode(String code);
}
