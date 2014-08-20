package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.converter.DtoConverter;
import org.wfp.fittest.dto.ConfirmedTypeDto;
import org.wfp.fittest.dto.CountryDto;
import org.wfp.fittest.dto.LanguageDto;
import org.wfp.fittest.repository.ConfirmedTypeRepository;
import org.wfp.fittest.repository.CountryRepository;
import org.wfp.fittest.repository.LanguageRepository;
import org.wfp.fittest.service.UtilityService;

@Service
@Transactional(readOnly = true)
public class UtilityServiceImpl implements UtilityService {

	@Autowired
	private DtoConverter converter;

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ConfirmedTypeRepository confirmedTypeRepository;

	@Override
	public List<CountryDto> findAllCountries() {
		return converter.entitiesToDtos(countryRepository.findAll());
	}

	@Override
	public CountryDto findCountryById(Long countryId) {
		return converter.entityToDto(countryRepository.findOne(countryId));
	}

	@Override
	public List<LanguageDto> findAllLanguages() {
		return converter.entitiesToDtos(languageRepository.findAll());
	}

	@Override
	public List<ConfirmedTypeDto> findAllConfirmedTypes() {
		return converter.entitiesToDtos(confirmedTypeRepository.findAll(
				new Sort("confirmedType")));
	}

}
