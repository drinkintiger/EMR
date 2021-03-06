package com.tsoy.emrmock.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tsoy.emrmock.components.AssessmentComponent;
import com.tsoy.emrmock.components.CNARecordComponent;
import com.tsoy.emrmock.components.EmrUserComponent;
import com.tsoy.emrmock.components.PatientInfoComponent;
import com.tsoy.emrmock.domain.Assessment;
import com.tsoy.emrmock.domain.CNA_Record;
import com.tsoy.emrmock.domain.patients.PatientInfo;
import com.tsoy.emrmock.domain.users.EmployeeInfo;
import com.tsoy.emrmock.utils.ActivitiesOfDailyLivining;
import com.tsoy.emrmock.utils.FluidIntake;
import com.tsoy.emrmock.utils.FluidOutput;
import com.tsoy.emrmock.utils.FoodIntake;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("selectedPatient")
public class HomeController {
	
	@Autowired
	EmrUserComponent employee;
	
	@Autowired
	AssessmentComponent assessmentComponent;
	
	@Autowired
	PatientInfoComponent patientInfoComponent;
	
	@Autowired
	CNARecordComponent cnaRecordComponent;
	
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
		model.addAttribute("user", user);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/patientsList", method = RequestMethod.GET)
	public String patientList(Principal principal, ModelMap model, Locale locale) {
		updateModel(principal, model, false);
		return "patientsList"; 
	}
	
	@RequestMapping(value = "/patientsList", method = RequestMethod.POST)
	public String retrievePatient(ModelMap model, Principal principal) {
		return "patientsList";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String postToHome(HttpServletRequest request, ModelMap model) {
		Long selectedPatientID = Long.parseLong(request.getParameter("selectedPatientID"));
		PatientInfo selectedPatient = PatientInfo.findPatientInfo(selectedPatientID);
		System.out.println("Selected patient is: " + selectedPatient);
		model.addAttribute("selectedPatient", selectedPatient);
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
	
	@RequestMapping(value = "/saveAssessment", method = RequestMethod.POST)
	public String saveAssessment(@RequestParam(value = "VitalSigns", required = false) String VitalSigns,
								 @RequestParam(value = "CardioSystem", required = false) String CardioSystem,
								 @RequestParam(value = "DigestiveSystem", required = false) String DigestiveSystem,
								 @RequestParam(value = "EndocrineSystem", required = false) String EndocrineSystem,
								 @RequestParam(value = "UrinarySystem", required = false) String UrinarySystem,
								 @RequestParam(value = "MuscularSystem", required = false) String MuscularSystem,
								 @RequestParam(value = "NervousSystem", required = false) String NervousSystem,
								 @RequestParam(value = "RespiratorySystem", required = false) String RespiratorySystem,
								 @RequestParam(value = "Behavior", required = false) String Behavior,
								 @ModelAttribute("selectedPatient") PatientInfo selectedPatient,
								 SessionStatus session,
								 ModelMap model, Principal principal) {
		if (principal == null) return "logout";
		Calendar cal = Calendar.getInstance();
		Date currentDate = new Date(cal.getTimeInMillis());
		System.out.println("This assessment record belongs to " + selectedPatient);
		Assessment assessment = new Assessment.Builder().VitalSigns(VitalSigns).CardioSystem(CardioSystem)
														.DigestiveSystem(DigestiveSystem)
														.EndocrineSystem(EndocrineSystem)
														.UrinarySystem(UrinarySystem)
														.MuscularSystem(MuscularSystem)
														.NervousSystem(NervousSystem)
														.RespiratorySystem(RespiratorySystem)
														.Behavior(Behavior)
														.CreatedDate(currentDate)
														.patient(selectedPatient)
														.build();
		assessmentComponent.create(selectedPatient, assessment);
		//need to know the patient that been selected from the table 
		System.out.println("This is the current assessment: " + assessment);
		session.setComplete();
		return "redirect:/patientsList";
									 
	}
	
	@RequestMapping(value = "/saveCNARecord", method = RequestMethod.GET)
	public String saveCNARecord(@RequestParam(value = "breakfastFood", required = false) Float breakfastFood,
								@RequestParam(value = "lunchFood", required = false) Float lunchFood,
								@RequestParam(value = "supperFood", required = false) Float supperFood,
								@RequestParam(value = "snackFood", required = false) Float snackFood,
								@RequestParam(value = "breakfastFluid", required = false) Integer breakfastFluid,
								@RequestParam(value = "lunchFluid", required = false) Integer lunchFluid,
								@RequestParam(value = "supperFluid", required = false) Integer supperFluid,
								@RequestParam(value = "otherFluid", required = false) Integer otherFluid,
								@RequestParam(value = "emesis", required = false) String emesis,
								@RequestParam(value = "urineOutput", required = false) Integer urineOutput,
								@RequestParam(value = "timesVoided", required = false) Integer timesVoided,
								@RequestParam(value = "bowelMovement", required = false) String bowelMovement,
								@RequestParam(value = "bathing", required = false) String bathing,
								@RequestParam(value = "dressing", required = false) String dressing,
								@RequestParam(value = "oralCare", required = false) String oralCare,
								@RequestParam(value = "eating", required = false) String eating,
								@RequestParam(value = "transferring", required = false) String transferring,
								@RequestParam(value = "ambulationDistance", required = false) Integer ambulationDistance,
								@RequestParam(value = "ambulation", required = false) String ambulation,
								@ModelAttribute("selectedPatient") PatientInfo selectedPatient,
								SessionStatus session
								) {
		FoodIntake foodIntake = new FoodIntake.Builder().breakfast(breakfastFood)
														.lunch(lunchFood)
														.supper(supperFood)
														.snack(snackFood)
														.build();
		FluidIntake fluidIntake = new FluidIntake.Builder().breakfast(breakfastFluid)
														   .lunch(lunchFluid)
														   .supper(supperFluid)
														   .other(otherFluid)
														   .build();
		FluidOutput fluidOutput = new FluidOutput.Builder().ml(urineOutput)
														   .timesVoided(timesVoided)
														   .emesis(emesis)
														   .build();
		Calendar cal = Calendar.getInstance();
		Date currentDate = new Date(cal.getTimeInMillis());
		ActivitiesOfDailyLivining activities = new ActivitiesOfDailyLivining.Builder().Bathing(bathing)
																					  .Dressing(dressing)
																					  .OralCare(oralCare)
																					  .Eating(eating)
																					  .Transferring(transferring)
																					  .AmbulatioDistance(ambulationDistance)
																					  .AmbulationType(ambulation)
																					  .build();
		CNA_Record record = new CNA_Record.Builder().FoodIntake(foodIntake)
													.FluidIntake(fluidIntake)
													.FluidOutput(fluidOutput)
													.CreatedDate(currentDate)
													.patient(selectedPatient)
													.BowelMovement(bowelMovement)
													.ActivitiesOfDailyLiving(activities)
													.build();
		cnaRecordComponent.createRecord(selectedPatient, record);
		session.setComplete();
		System.out.println("Food intake was: " + foodIntake);
		System.out.println("Fluid intake was: " + fluidIntake);
		System.out.println("Emesis value is: " + emesis);
		System.out.println("This is CNA record " + record);
		return "redirect:/patientsList";
	}
}
