package com.tsoy.emrmock.utils;

import java.io.Serializable;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class FoodIntake implements Serializable {

	private static final long serialVersionUID = 1L;
	private Float breakfast;
	private Float lunch;
	private Float supper;
	private Float snack;
	
	public static class Builder {
		private Float breakfast;
		private Float lunch;
		private Float supper;
		private Float snack;
		
		public Builder breakfast(Float breakfast) {
			this.breakfast = breakfast;
			return this;
		}
		
		public Builder lunch(Float lunch) {
			this.lunch = lunch;
			return this;
		}
		
		public Builder supper(Float supper) {
			this.supper = supper;
			return this;
		}
		
		public Builder snack(Float snack) {
			this.snack = snack;
			return this;
		}
		
		public FoodIntake build() {
			return new FoodIntake(this);
		}	
	}
	
	private FoodIntake(Builder builder) {
		this.breakfast = builder.breakfast;
		this.lunch = builder.lunch;
		this.supper = builder.supper;
		this.snack = builder.snack;
	}
}
