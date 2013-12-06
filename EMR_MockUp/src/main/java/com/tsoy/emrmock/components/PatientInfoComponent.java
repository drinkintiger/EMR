package com.tsoy.emrmock.components;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tsoy.emrmock.domain.patients.PatientInfo;

@Component
@Transactional
public class PatientInfoComponent {
	public PatientInfoComponent() {
		System.out.println("MAKING PATIENTINFO COMPONENT");
	}
	
	public List<PatientInfo> getAllPatients() {
		return PatientInfo.findAllPatientInfoes();
	}
}
