package org.wfp.fittest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "readOnly" })
public abstract class AbstractController {

}
