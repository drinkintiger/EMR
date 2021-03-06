package com.tsoy.emrmock.components;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tsoy.emrmock.domain.Assessment;
import com.tsoy.emrmock.domain.patients.PatientInfo;

@Component
@Transactional
public class AssessmentComponent {
	public AssessmentComponent() {
		System.out.println("MAKING ASSESSMENT COMPONENT");
	}
	
	public Set<Assessment> getAssessments(Long id) {
		PatientInfo patient = PatientInfo.findPatientInfo(id);
		if(patient == null) return null;
		
		return patient.getAssessments();
	}
	
	public void create(PatientInfo patient, Assessment assessment) {
		System.out.println("Creating assessment(" + patient + assessment);
		
		assessment.setPatient(patient);
		
		System.out.println("saved assessment(" + assessment + ")");
		patient.getAssessments().add(assessment);
		patient.merge();
		System.out.println("created assessment(" + assessment + ")");
		System.out.println("for patient" + patient + ")");
	}
}
