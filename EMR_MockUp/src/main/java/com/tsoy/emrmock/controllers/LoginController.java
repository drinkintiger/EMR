package com.tsoy.emrmock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	public LoginController () {
		logger.info("LoginController is created!");
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login(
			@RequestParam(value="error", required=false) Boolean isError,
			ModelMap model) {
		
		if(isError != null && isError) {
			model.addAttribute("error", isError);
		}
		return "login";
	}	
}
