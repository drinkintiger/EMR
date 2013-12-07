package com.tsoy.emrmock.domain.users;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class AD_Roles implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
    @NotNull
    @Size(min = 2)
    private String role_name;
    
    public AD_Roles(String n) {
    	this.role_name = n;
    }
    
	@Override
	public String getAuthority() {
		return this.role_name;
	}
}
