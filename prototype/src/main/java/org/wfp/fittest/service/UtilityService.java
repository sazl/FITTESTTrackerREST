package org.wfp.fittest.service;

import java.util.List;

import org.wfp.fittest.beans.ConfirmedTypeBean;
import org.wfp.fittest.beans.CountryBean;
import org.wfp.fittest.beans.LanguageBean;


public interface UtilityService {
	public CountryBean findCountryById(Long id);
	
	public List<CountryBean> findAllCountries();
	
	public LanguageBean findLanguageById(Long id);
	
	public List<LanguageBean> findAllLanguages();
	
	public ConfirmedTypeBean findConfirmedTypeById(Long id);
	
	public List<ConfirmedTypeBean> findAllConfirmedTypes();
	
	public Boolean deleteCountryById(Long countryId);
	
	public Boolean deleteLanguageById(Long languageId);
	
	public Boolean deleteConfirmedTypeById(Long confirmedTypeId);
	
	public CountryBean saveOrUpdateCountry(CountryBean countryBean);
	
	public LanguageBean saveOrUpdateLanguage(LanguageBean languageBean);
}
