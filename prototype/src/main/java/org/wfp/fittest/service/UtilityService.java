package org.wfp.fittest.service;

import org.wfp.fittest.beans.ConfirmedTypeBean;
import org.wfp.fittest.beans.CountryBean;
import org.wfp.fittest.beans.LanguageBean;
import org.wfp.fittest.utility.BeanListWrapper;


public interface UtilityService {
	public CountryBean findCountryById(Long id);
	
	public BeanListWrapper<CountryBean> findAllCountries();
	
	public LanguageBean findLanguageById(Long id);
	
	public BeanListWrapper<LanguageBean> findAllLanguages();
	
	public ConfirmedTypeBean findConfirmedTypeById(Long id);
	
	public BeanListWrapper<ConfirmedTypeBean> findAllConfirmedTypes();
}
