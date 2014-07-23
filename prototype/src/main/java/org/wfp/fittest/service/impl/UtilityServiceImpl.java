package org.wfp.fittest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.beans.ConfirmedTypeBean;
import org.wfp.fittest.beans.CountryBean;
import org.wfp.fittest.beans.LanguageBean;
import org.wfp.fittest.converter.EntityConverter;
import org.wfp.fittest.entity.Country;
import org.wfp.fittest.entity.Language;
import org.wfp.fittest.repository.ConfirmedTypeRepository;
import org.wfp.fittest.repository.CountryRepository;
import org.wfp.fittest.repository.LanguageRepository;
import org.wfp.fittest.service.UtilityService;

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

//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteCountryById(Long countryId) {
//		return countryRepository.deleteCheck(countryId);
//	}
//
//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteLanguageById(Long languageId) {
//		return languageRepository.deleteCheck(languageId);
//	}
//
//	@Override
//	@Transactional(readOnly = false)
//	public Boolean deleteConfirmedTypeById(Long confirmedTypeId) {
//		return confirmedTypeRepository.deleteCheck(confirmedTypeId);
//	}

	@Override
	@Transactional(readOnly = false)
	public CountryBean saveOrUpdateCountry(CountryBean countryBean) {
		Country country = EntityConverter.toEntity(countryBean);
		return EntityConverter.toBean(countryRepository.save(country));
	}

	@Override
	@Transactional(readOnly = false)
	public LanguageBean saveOrUpdateLanguage(LanguageBean languageBean) {
		Language language = EntityConverter.toEntity(languageBean);
		return EntityConverter.toBean(languageRepository.save(language));
	}

	@Override
	public List<LanguageBean> findLanguagesByIds(List<Long> ids) {
		return EntityConverter.toBeanList(languageRepository.findAll(ids));
	}

	@Override
	public List<CountryBean> findCountriesByIds(List<Long> ids) {
		return EntityConverter.toBeanList(countryRepository.findAll(ids));
	}

	@Override
	public Boolean deleteCountryById(Long countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteLanguageById(Long languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteConfirmedTypeById(Long confirmedTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
