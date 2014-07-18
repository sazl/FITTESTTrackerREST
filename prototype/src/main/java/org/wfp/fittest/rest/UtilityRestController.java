package org.wfp.fittest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wfp.fittest.beans.ConfirmedTypeBean;
import org.wfp.fittest.beans.CountryBean;
import org.wfp.fittest.beans.LanguageBean;
import org.wfp.fittest.service.UtilityService;
import org.wfp.fittest.utility.BeanListWrapper;
import org.wfp.fittest.utility.BeanWrapper;
import org.wfp.fittest.utility.HttpUtility;
import org.wfp.fittest.utility.JsonUtility;

@Controller
@RequestMapping("/rest")
public class UtilityRestController {

	@Autowired
	private UtilityService utilityService;

	/*------------------------------------------------------------------------*
	 * Country                                                                *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<CountryBean> country() {
		return JsonUtility.toBeanListWrapper("countries",
				utilityService.findAllCountries());
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<CountryBean> countryCreate(
			@RequestBody BeanWrapper<CountryBean> countryWrapper) {
		CountryBean countryBean = countryWrapper.get("country");
		return JsonUtility.beanWrapper("country",
				utilityService.saveOrUpdateCountry(countryBean));
	}
	
	@RequestMapping(value = "/countries/{countryId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<CountryBean> countryUpdate(
			@PathVariable("countryId") Long countryId,
			@RequestBody BeanWrapper<CountryBean> countryWrapper) {
		CountryBean countryBean = countryWrapper.get("country");
		countryBean.setId(countryId);
		return JsonUtility.beanWrapper("country",
				utilityService.saveOrUpdateCountry(countryBean));
	}
	
	@RequestMapping(value = "/countries/{countryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<CountryBean> country(
			@PathVariable("countryId") Long countryId) {
		return JsonUtility.beanWrapper("country",
				utilityService.findCountryById(countryId));
	}

	@RequestMapping(value = "/countries/{countryId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> countryDelete(
			@PathVariable("countryId") Long countryId) {
		return HttpUtility.deleteResponse(utilityService
				.deleteCountryById(countryId));
	}

	/*------------------------------------------------------------------------*
	 * Confirmed Type                                                         *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/confirmedTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<ConfirmedTypeBean> confirmedType() {
		return JsonUtility.toBeanListWrapper("confirmedTypes",
				utilityService.findAllConfirmedTypes());
	}

	@RequestMapping(value = "/confirmedTypes/{confirmedtypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<ConfirmedTypeBean> confirmedType(
			@PathVariable("confirmedtypeId") Long confirmedtypeId) {
		return JsonUtility.beanWrapper("confirmedType",
				utilityService.findConfirmedTypeById(confirmedtypeId));
	}

	@RequestMapping(value = "/confirmedTypes/{confirmedtypeId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> confirmedTypeDelete(
			@PathVariable("confirmedtypeId") Long confirmedtypeId) {
		return HttpUtility.deleteResponse(utilityService
				.deleteConfirmedTypeById(confirmedtypeId));
	}

	/*------------------------------------------------------------------------*
	 * Language                                                               *
	 *------------------------------------------------------------------------*/

	@RequestMapping(value = "/languages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanListWrapper<LanguageBean> language() {
		return JsonUtility.toBeanListWrapper("languages",
				utilityService.findAllLanguages());
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<LanguageBean> languageCreate(
			@RequestBody BeanWrapper<LanguageBean> languageWrapper) {
		LanguageBean languageBean = languageWrapper.get("language");
		return JsonUtility.beanWrapper("language",
				utilityService.saveOrUpdateLanguage(languageBean));
	}

	@RequestMapping(value = "/languages/{languageId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<LanguageBean> languageUpdate(
			@PathVariable("languageId") Long languageId,
			@RequestBody BeanWrapper<LanguageBean> languageWrapper) {
		LanguageBean languageBean = languageWrapper.get("language");
		languageBean.setId(languageId);
		return JsonUtility.beanWrapper("language",
				utilityService.saveOrUpdateLanguage(languageBean));
	}
	
	@RequestMapping(value = "/languages/{languageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BeanWrapper<LanguageBean> language(
			@PathVariable("languageId") Long languageId) {
		return JsonUtility.beanWrapper("language",
				utilityService.findLanguageById(languageId));
	}

	@RequestMapping(value = "/languages/{languageId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> languageDelete(
			@PathVariable("languageId") Long languageId) {
		return HttpUtility.deleteResponse(utilityService
				.deleteLanguageById(languageId));
	}
}