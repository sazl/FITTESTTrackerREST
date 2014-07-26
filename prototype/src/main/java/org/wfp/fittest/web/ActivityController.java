package org.wfp.fittest.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.service.ActivityService;

@Controller
@RequestMapping("/activity")
@ExposesResourceFor(Activity.class)
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;



}
