package com.tsoy.emrmock.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tsoy.emrmock.domain.Assessment;
import com.tsoy.emrmock.domain.CNA_Record;
import com.tsoy.emrmock.domain.patients.PatientInfo;

@Controller
@SessionAttributes(value= {"selectedPatient", "dateList"})
public class ReportingController {
	
	
	@RequestMapping(value = "/ViewAssessments", method = RequestMethod.POST)
	public String doViewAssessments(HttpServletRequest request, ModelMap model) {
		
		System.out.println("THE PATIENT'S ID IS: " + request.getParameter("viewAssessment"));
		Long selectedPatientID = Long.parseLong(request.getParameter("viewAssessment"));
		PatientInfo selectedPatient = PatientInfo.findPatientInfo(selectedPatientID);
		
		System.out.println("THIS IS THE PATIENT THE REPORTS ARE FOR: " + selectedPatient);
		model.addAttribute("selectedPatient", selectedPatient);
		
		Set<Assessment> patientsAssessments = selectedPatient.getAssessments();
		Set<Date> dateList = new HashSet<Date>();
		
		for (Assessment assessment: patientsAssessments) {
			dateList.add(assessment.getCreatedDate());
		}
		
		model.addAttribute("dateList", dateList);
		return "ViewAssessments";
	}
	
	@RequestMapping(value = "/getAssessment", method = RequestMethod.POST)
	public String showAssessmentForDate(HttpServletRequest request,
										@ModelAttribute("datePicked") Date datePicked,
										@ModelAttribute("dateSelected") String dateSelected,
										@ModelAttribute("selectedPatient") PatientInfo selectedPatient,
										ModelMap model, SessionStatus session) {
		System.out.println("This is picked date: " + datePicked.toString());
		System.out.println("This is real picked date: " + dateSelected);
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime dt = formatter.parseDateTime(dateSelected);
		Date selectedDate = dt.toDate();
		System.out.println("This is parsed picked date: " + selectedDate);
		Assessment selectedAssessment = new Assessment().findByDate(selectedDate);
		model.addAttribute("selectedAssessment", selectedAssessment);		
		return "ViewAssessments";
	}
	
	@RequestMapping(value = "/ViewCharts", method = RequestMethod.POST)
	public String doViewCharts(HttpServletRequest request, ModelMap model) {
		
		System.out.println("THE PATIENT'S ID IS: " + request.getParameter("viewCharts"));
		Long selectedPatientID = Long.parseLong(request.getParameter("viewCharts"));
		PatientInfo selectedPatient = PatientInfo.findPatientInfo(selectedPatientID);
		
		System.out.println("THIS IS THE PATIENT THE REPORTS ARE FOR: " + selectedPatient);
		model.addAttribute("selectedPatient", selectedPatient);
		
		Set<CNA_Record> patientsCharts = selectedPatient.getCnaRecords();
		Set<Date> dateList = new HashSet<Date>();
		
		for (CNA_Record record: patientsCharts) {
			dateList.add(record.getCreatedDate());
		}
		
		model.addAttribute("dateList", dateList);
		return "ViewCharts";
	}
	
	@RequestMapping(value = "/getChart", method = RequestMethod.POST)
	public String showChartForDate(HttpServletRequest request,
										@ModelAttribute("datePicked") Date datePicked,
										@ModelAttribute("dateSelected") String dateSelected,
										@ModelAttribute("selectedPatient") PatientInfo selectedPatient,
										ModelMap model, SessionStatus session) {
		System.out.println("This is picked date: " + datePicked.toString());
		System.out.println("This is real picked date: " + dateSelected);
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime dt = formatter.parseDateTime(dateSelected);
		Date selectedDate = dt.toDate();
		System.out.println("This is parsed picked date: " + selectedDate);
		CNA_Record selectedChart = new CNA_Record().findByDate(selectedDate);
		model.addAttribute("selectedChart", selectedChart);		
		return "ViewCharts";
	}
	
	@RequestMapping(value = "/ViewAssessments", method = RequestMethod.GET)
	public String viewReports(HttpServletRequest request, ModelMap model) {
		System.out.println("HELLO FROM VIEWASSESSMENT GET");
		return "ViewAssessments";
	}
}
