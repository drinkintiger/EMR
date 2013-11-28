package com.tsoy.emrmock.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/patientsList", method = RequestMethod.GET)
	public String patientList(Locale locale, Model model) {
		logger.info("Welcome to client list! The client locale is {}.", locale);
		
		return "patientsList";
	}
	
	
	@RequestMapping(value = "/home")
	public String home(Locale locale, Model model) {
		logger.info("Welcome to client list! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "/nursing")
	public String nursing(Locale locale, Model model) {
		logger.info("Welcome to client list! The client locale is {}.", locale);
		
		return "nursing";
	}
	
	@RequestMapping(value = "/cna")
	public String cna(Locale locale, Model model) {
		logger.info("Welcome to client list! The client locale is {}.", locale);
		
		return "cna";
	}
	@RequestMapping(value = "/charts")
	public String charts(Locale locale, Model model) {
		logger.info("Welcome to client list! The client locale is {}.", locale);
		
		return "charts";
	}

}
