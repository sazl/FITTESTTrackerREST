package org.wfp.fittest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ConfirmedTypeBean;
import org.wfp.fittest.beans.CountryBean;
import org.wfp.fittest.beans.LanguageBean;
import org.wfp.fittest.service.UtilityService;
import org.wfp.fittest.utility.BeanListWrapper;
import org.wfp.fittest.utility.BeanWrapper;
import org.wfp.fittest.utility.JSONUtility;

@Controller
@RequestMapping("/rest")
public class UtilityRestController {

	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<CountryBean> country() {
		return utilityService.findAllCountries();
	}

	@RequestMapping(value = "/countries/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<CountryBean> country(
			@PathVariable("countryId") Long countryId) {
		return JSONUtility.beanWrapper("country",
				utilityService.findCountryById(countryId));
	}

	@RequestMapping(value = "/confirmedTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ConfirmedTypeBean> confirmedtype() {
		return utilityService.findAllConfirmedTypes();
	}

	@RequestMapping(value = "/confirmedTypes/{confirmedtypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ConfirmedTypeBean> confirmedtype(
			@PathVariable("confirmedtypeId") Long confirmedtypeId) {
		return JSONUtility.beanWrapper("confirmedType",
				utilityService.findConfirmedTypeById(confirmedtypeId));
	}

	@RequestMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<LanguageBean> language() {
		return utilityService.findAllLanguages();
	}

	@RequestMapping(value = "/languages/{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<LanguageBean> language(
			@PathVariable("languageId") Long languageId) {
		return JSONUtility.beanWrapper("language",
				utilityService.findLanguageById(languageId));
	}
}