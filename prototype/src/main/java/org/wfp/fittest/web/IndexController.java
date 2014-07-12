package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/")
	public String index(Model model, Locale locale) {
		return "index";
	}
}
