package com.tsoy.emrmock.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsoy.emrmock.domain.patients.PatientInfo;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Assessment {
	
	@Lob
    private String VitalSigns;
	@Lob
    private String CardioSystem;
	@Lob
    private String DigestiveSystem;
	@Lob
    private String EndocrineSystem;
	@Lob
    private String UrinarySystem;
	@Lob
    private String MuscularSystem;
	@Lob
    private String NervousSystem;
	@Lob
    private String RespiratorySystem;
    @Lob
    private String Behavior;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-", pattern="MM-dd-yyyy")
    private Date CreatedDate;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private PatientInfo patient;
    
    public Assessment findByDate(Date date){
    	if(date == null) return null;
    	
    	Assessment assessment = entityManager().createQuery("SELECT assessment FROM Assessment assessment WHERE assessment.CreatedDate = :date", Assessment.class).setParameter("date", date, TemporalType.DATE).getSingleResult();
    	
    	return assessment;
    }
    
    public static class Builder {
        private String VitalSigns;
        private String CardioSystem;
        private String DigestiveSystem;
        private String EndocrineSystem;
        private String UrinarySystem;
        private String MuscularSystem;
        private String NervousSystem;
        private String RespiratorySystem;
        private String Behavior;
        private Date CreatedDate;
        private PatientInfo patient;
        
        public Builder VitalSigns(String VitalSings) {
        	this.VitalSigns = VitalSings;
        	return this;
        }
        
        public Builder CardioSystem(String CardioSystem) {
        	this.CardioSystem = CardioSystem;
        	return this;
        }
        
        public Builder DigestiveSystem(String DigestiveSystem) {
        	this.DigestiveSystem = DigestiveSystem;
        	return this;
        }
        
        public Builder EndocrineSystem(String EndocrineSystem) {
        	this.EndocrineSystem = EndocrineSystem;
        	return this;
        }
        
        public Builder UrinarySystem(String UrinarySystem) {
        	this.UrinarySystem = UrinarySystem;
        	return this;
        }
        
        public Builder MuscularSystem(String MuscularSystem) {
        	this.MuscularSystem = MuscularSystem;
        	return this;
        }
        
        public Builder NervousSystem(String NervousSystem) {
        	this.NervousSystem = NervousSystem;
        	return this;
        }
        
        public Builder RespiratorySystem(String RespiratorySystem) {
        	this.RespiratorySystem = RespiratorySystem;
        	return this;
        }
        
        public Builder Behavior(String Behavior) {
        	this.Behavior = Behavior;
        	return this;
        }
        
        public Builder CreatedDate(Date CreatedDate) {
        	this.CreatedDate = CreatedDate;
        	return this;
        }
        
        public Builder patient(PatientInfo patient) {
        	this.patient = patient;
        	return this;
        }
        public Assessment build() {
        	return new Assessment(this);
        }
    }
    
    private Assessment(Builder b) {
    	this.VitalSigns = b.VitalSigns;
    	this.CardioSystem = b.CardioSystem;
    	this.DigestiveSystem = b.DigestiveSystem;
    	this.EndocrineSystem = b.EndocrineSystem;
    	this.UrinarySystem = b.UrinarySystem;
    	this.MuscularSystem = b.MuscularSystem;
    	this.NervousSystem = b.NervousSystem;
    	this.RespiratorySystem = b.RespiratorySystem;
    	this.Behavior = b.Behavior;
    	this.CreatedDate = b.CreatedDate;
    	this.patient = b.patient;
    }
}
