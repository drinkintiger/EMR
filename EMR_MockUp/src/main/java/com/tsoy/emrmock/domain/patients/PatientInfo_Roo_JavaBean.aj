// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain.patients;

import com.tsoy.emrmock.domain.Assessment;
import com.tsoy.emrmock.domain.patients.PatientInfo;
import java.util.Set;

privileged aspect PatientInfo_Roo_JavaBean {
    
    public String PatientInfo.getLastName() {
        return this.LastName;
    }
    
    public void PatientInfo.setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public String PatientInfo.getFirstName() {
        return this.FirstName;
    }
    
    public void PatientInfo.setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    public Boolean PatientInfo.getActive() {
        return this.Active;
    }
    
    public void PatientInfo.setActive(Boolean Active) {
        this.Active = Active;
    }
    
    public Set<Assessment> PatientInfo.getAssessments() {
        return this.assessments;
    }
    
    public void PatientInfo.setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }
    
}