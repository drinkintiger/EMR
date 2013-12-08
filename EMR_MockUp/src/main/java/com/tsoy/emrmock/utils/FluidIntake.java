package com.tsoy.emrmock.utils;

import java.io.Serializable;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class FluidIntake implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer breakfast;
	private Integer lunch;
	private Integer supper;
	private Integer other;
	
	public static class Builder {
		private Integer breakfast;
		private Integer lunch;
		private Integer supper;
		private Integer other;
		
		public Builder breakfast(Integer breakfast) {
			this.breakfast = breakfast;
			return this;
		}
		
		public Builder lunch(Integer lunch) {
			this.lunch = lunch;
			return this;
		}
		
		public Builder supper(Integer supper) {
			this.supper = supper;
			return this;
		}
		
		public Builder other(Integer other) {
			this.other = other;
			return this;
		}
		
		public FluidIntake build() {
			return new FluidIntake(this);
		}	
	}
	
	private FluidIntake(Builder builder) {
		this.breakfast = builder.breakfast;
		this.lunch = builder.lunch;
		this.supper = builder.supper;
		this.other = builder.other;
	}
}
