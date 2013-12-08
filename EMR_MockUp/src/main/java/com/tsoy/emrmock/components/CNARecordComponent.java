package com.tsoy.emrmock.components;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tsoy.emrmock.domain.CNA_Record;
import com.tsoy.emrmock.domain.patients.PatientInfo;

@Component
@Transactional
public class CNARecordComponent {
	
	public CNARecordComponent() {
		System.out.println("MAKING CNA_RECORD COMPONENT");
	}
	
	public Set<CNA_Record> getRecords(Long id) {
		PatientInfo patient = PatientInfo.findPatientInfo(id);
		if(patient == null) return null;
		
		return patient.getCnaRecords();
	}
	
	public void createRecord(PatientInfo patient, CNA_Record record) {
		record.setPatient(patient);
		patient.getCnaRecords().add(record);
		patient.merge();
		System.out.println("created record(" + record + ")");
		System.out.println("for patient" + patient + ")");
	}
}
