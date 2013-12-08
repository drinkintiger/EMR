package com.tsoy.emrmock.utils;

import java.io.Serializable;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class FluidOutput implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer ml;
	private Integer timesVoided;
	private String emesis;
	
	public static class Builder {
		private Integer ml;
		private Integer timesVoided;
		private String emesis;
		
		public Builder ml(Integer ml) {
			this.ml = ml;
			return this;
		}
		
		public Builder timesVoided(Integer timesVoided) {
			this.timesVoided = timesVoided;
			return this;
		}
		
		public Builder emesis(String emesis) {
			this.emesis = emesis;
			return this;
		}
		
		public FluidOutput build() {
			return new FluidOutput(this);
		}
	}
	
	private FluidOutput(Builder b) {
		this.ml = b.ml;
		this.timesVoided = b.timesVoided;
		this.emesis = b.emesis;
	}
}
