package org.wfp.fittest.service;

import java.util.List;

import org.wfp.fittest.dto.ConfirmedTypeDto;
import org.wfp.fittest.dto.CountryDto;
import org.wfp.fittest.dto.LanguageDto;

public interface UtilityService {
	public List<CountryDto> findAllCountries();
	
	public CountryDto findCountryById(Long countryId);
	
	public List<LanguageDto> findAllLanguages();
	
	public List<ConfirmedTypeDto> findAllConfirmedTypes();
}
