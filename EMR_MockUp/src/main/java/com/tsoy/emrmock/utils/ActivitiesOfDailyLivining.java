package com.tsoy.emrmock.utils;

import java.io.Serializable;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class ActivitiesOfDailyLivining implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String Bathing;
	private String Dressing;
	private String OralCare;
	private String Eating;
	private String Transferring;
	private String AmbulationType;
	private Integer AmbulationDistance;
	
	public static class Builder {
		private String Bathing;
		private String Dressing;
		private String OralCare;
		private String Eating;
		private String Transferring;
		private String AmbulationType;
		private Integer AmbulationDistance;
		
		public Builder Bathing(String Bathing) {
			this.Bathing = Bathing;
			return this;
		}
		
		public Builder Dressing(String Dressing) {
			this.Dressing = Dressing;
			return this;
		}
		
		public Builder OralCare(String OralCare) {
			this.OralCare = OralCare;
			return this;
		}
		
		public Builder Eating(String Eating) {
			this.Eating = Eating;
			return this;
		}
		
		public Builder Transferring(String Transferring) {
			this.Transferring = Transferring;
			return this;
		}
		
		public Builder AmbulationType(String type) {
			this.AmbulationType = type;
			return this;
		}
		
		public Builder AmbulatioDistance(Integer distance) {
			this.AmbulationDistance = distance;
			return this;
		}
		
		public ActivitiesOfDailyLivining build(){
			return new ActivitiesOfDailyLivining(this);
		}
	}
	
	private ActivitiesOfDailyLivining(Builder b) {
		this.Bathing = b.Bathing;
		this.Dressing = b.Dressing;
		this.OralCare = b.OralCare;
		this.Eating = b.Eating;
		this.Transferring = b.Transferring;
		this.AmbulationType = b.AmbulationType;
		this.AmbulationDistance = b.AmbulationDistance;
	}

}
