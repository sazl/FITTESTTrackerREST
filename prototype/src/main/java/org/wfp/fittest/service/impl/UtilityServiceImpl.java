package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.beans.ConfirmedTypeBean;
import org.wfp.fittest.beans.CountryBean;
import org.wfp.fittest.beans.LanguageBean;
import org.wfp.fittest.repository.ConfirmedTypeRepository;
import org.wfp.fittest.repository.CountryRepository;
import org.wfp.fittest.repository.LanguageRepository;
import org.wfp.fittest.service.UtilityService;
import org.wfp.fittest.utility.EntityConverter;

@Service
@Transactional(readOnly = true)
public class UtilityServiceImpl implements UtilityService {

	@Autowired
	private ConfirmedTypeRepository confirmedTypeRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public CountryBean findCountryById(Long id) {
		return EntityConverter.toBean(countryRepository.findOne(id));
	}

	@Override
	public List<CountryBean> findAllCountries() {
		return EntityConverter.toBeanList(countryRepository.findAll());
	}

	@Override
	public LanguageBean findLanguageById(Long id) {
		return EntityConverter.toBean(languageRepository.findOne(id));
	}

	@Override
	public List<LanguageBean> findAllLanguages() {
		return EntityConverter.toBeanList(languageRepository.findAll());
	}

	@Override
	public ConfirmedTypeBean findConfirmedTypeById(Long id) {
		return EntityConverter.toBean(confirmedTypeRepository.findOne(id));
	}

	@Override
	public List<ConfirmedTypeBean> findAllConfirmedTypes() {
		return EntityConverter.toBeanList(confirmedTypeRepository.findAll());
	}

	@Override
	public Boolean deleteCountryById(Long countryId) {
		return countryRepository.deleteCheck(countryId);
	}

	@Override
	public Boolean deleteLanguageById(Long languageId) {
		return languageRepository.deleteCheck(languageId);
	}

	@Override
	public Boolean deleteConfirmedTypeById(Long confirmedTypeId) {
		return confirmedTypeRepository.deleteCheck(confirmedTypeId);
	}

}
