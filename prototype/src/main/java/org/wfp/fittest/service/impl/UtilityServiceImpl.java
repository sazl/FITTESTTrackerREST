package org.wfp.fittest.service.impl;

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
import org.wfp.fittest.utility.BeanListWrapper;
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
	public BeanListWrapper<CountryBean> findAllCountries() {
		return EntityConverter.toBeanListWrapper("countries",
				countryRepository.findAll());
	}

	@Override
	public LanguageBean findLanguageById(Long id) {
		return EntityConverter.toBean(languageRepository.findOne(id));
	}

	@Override
	public BeanListWrapper<LanguageBean> findAllLanguages() {
		return EntityConverter.toBeanListWrapper("languages",
				languageRepository.findAll());
	}

	@Override
	public ConfirmedTypeBean findConfirmedTypeById(Long id) {
		return EntityConverter.toBean(confirmedTypeRepository.findOne(id));
	}

	@Override
	public BeanListWrapper<ConfirmedTypeBean> findAllConfirmedTypes() {
		return EntityConverter.toBeanListWrapper("confirmedTypes",
				confirmedTypeRepository.findAll());
	}

}
