package org.wfp.fittest.web;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wfp.fittest.dto.CountryDto;
import org.wfp.fittest.dto.LanguageDto;
import org.wfp.fittest.service.ActivityService;
import org.wfp.fittest.service.StaffService;
import org.wfp.fittest.service.UtilityService;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = "/")
	public String index(Model model, Locale locale) {
		return "redirect:login";
	}

	@RequestMapping(value = "/login")
	public String login(Model model, Locale locale) {
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(Model model, Locale locale) {
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model, Locale locale) {
		Date currentDate = new Date();
		model.addAttribute("staffBIS", staffService.findStaffBIS(currentDate));
		model.addAttribute("staffAvailable", staffService.findStaffAvailable(currentDate));
		model.addAttribute("staffNotAvailable", staffService.findStaffNotAvailable(currentDate));
		return "dashboard";
	}

	@RequestMapping(value = "/deployment")
	public String deployment(Model model, Locale locale) {
		return "deployment";
	}

	@RequestMapping(value = "/misc")
	public String misc(Model model, Locale locale) {
		List<CountryDto> countries = utilityService.findAllCountries();
		model.addAttribute("allCountries", countries);
		List<LanguageDto> languages = utilityService.findAllLanguages();
		model.addAttribute("allLanguages", languages);
		return "misc";
	}

	@RequestMapping(value = "/country/{id}/view")
	public String countryView(@PathVariable("id") Long id, Model model,
			Locale locale) {
		model.addAttribute("country", utilityService.findCountryById(id));
		return "view/country";
	}

	@RequestMapping(value = "/planning")
	public String planning(Model model, Locale locale) {
		return "planning";
	}

	@RequestMapping(value = "/requirement")
	public String requirement(Model model, Locale locale) {
		return "requirement";
	}

}
