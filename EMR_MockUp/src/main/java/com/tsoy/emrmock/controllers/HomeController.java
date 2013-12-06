package com.tsoy.emrmock.controllers;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsoy.emrmock.components.AssessmentComponent;
import com.tsoy.emrmock.components.EmrUserComponent;
import com.tsoy.emrmock.components.PatientInfoComponent;
import com.tsoy.emrmock.domain.users.EmployeeInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	EmrUserComponent employee;
	
	@Autowired
	AssessmentComponent assessmentComponent;
	
	@Autowired
	PatientInfoComponent patientInfoComponent;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController () {
		logger.info("HomeController is created!");
	}
	
	private void updateModel(Principal principal, ModelMap model, boolean isAdmin) {	
		EmployeeInfo user = EmployeeInfo.findUserByName(principal.getName());
		if(user == null) return;
		
		model.addAttribute("patients", patientInfoComponent.getAllPatients());
		
		if (!isAdmin) {
			model.addAttribute("assessments", assessmentComponent.getAssessments(user.getEmployee_number()));
		}
		model.addAttribute("user", user.getUsername());
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/patientsList", method = RequestMethod.GET)
	public String patientList(Principal principal, ModelMap model, Locale locale) {
		logger.info("Welcome to client list! The client locale is {}.", locale);
		updateModel(principal, model, false);
		return "patientsList";
	}
	
	
	@RequestMapping(value = "/home")
	public String home(Locale locale, Model model) {
		logger.info("Welcome to home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "/nursing")
	public String nursing(Locale locale, Model model) {
		logger.info("Welcome to nursing! The client locale is {}.", locale);
		
		return "nursing";
	}
	
	@RequestMapping(value = "/cna")
	public String cna(Locale locale, Model model) {
		logger.info("Welcome to cna! The client locale is {}.", locale);
		
		return "cna";
	}
	@RequestMapping(value = "/charts")
	public String charts(Locale locale, Model model) {
		logger.info("Welcome to charts! The client locale is {}.", locale);
		
		return "charts";
	}
	
}
