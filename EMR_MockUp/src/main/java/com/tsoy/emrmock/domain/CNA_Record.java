package com.tsoy.emrmock.domain;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.tsoy.emrmock.domain.patients.PatientInfo;
import com.tsoy.emrmock.utils.ActivitiesOfDailyLivining;
import com.tsoy.emrmock.utils.FluidIntake;
import com.tsoy.emrmock.utils.FluidOutput;
import com.tsoy.emrmock.utils.FoodIntake;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class CNA_Record {
	
	@Lob
    private FoodIntake FoodIntake;
	@Lob
    private FluidIntake FluidIntake;
	@Lob
    private FluidOutput FluidOutput;
    private String BowelMovement;
    @Lob
    private ActivitiesOfDailyLivining activities;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date CreatedDate;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private PatientInfo patient;
    
    public static class Builder {
    	private FoodIntake FoodIntake;
        private FluidIntake FluidIntake;
        private Date CreatedDate;
        private PatientInfo patient;
        private FluidOutput FluidOutput;
        private String BowelMovement;
        private ActivitiesOfDailyLivining activities;
        
        public Builder FoodIntake(FoodIntake FoodIntake) {
        	this.FoodIntake = FoodIntake;
        	return this;
        }
        
        public Builder FluidIntake(FluidIntake FluidIntake) {
        	this.FluidIntake = FluidIntake;
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
        
        public Builder FluidOutput(FluidOutput FluidOutput) {
        	this.FluidOutput = FluidOutput;
        	return this;
        }
        
        public Builder BowelMovement(String BowelMovement) {
        	this.BowelMovement = BowelMovement;
        	return this;
        }
        
        public Builder ActivitiesOfDailyLiving(ActivitiesOfDailyLivining activities) {
        	this.activities = activities;
        	return this;
        }
        
        public CNA_Record build() {
        	return new CNA_Record(this);
        }
    }
    
    private CNA_Record(Builder b) {
    	this.FoodIntake = b.FoodIntake;
    	this.FluidIntake = b.FluidIntake;
    	this.FluidOutput = b.FluidOutput;
    	this.CreatedDate = b.CreatedDate;
    	this.BowelMovement = b.BowelMovement;
    	this.patient = b.patient;
    	this.activities = b.activities;
    }
}
