package org.net.eboutique.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}

	@RequestMapping(value="/errors_404")
	public String pageErrors(){
		return "errors_404";
	}
}
