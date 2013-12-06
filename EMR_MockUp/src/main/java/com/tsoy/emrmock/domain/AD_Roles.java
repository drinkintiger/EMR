package com.tsoy.emrmock.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class AD_Roles {
	
	@NotNull
	private Long role_id;
	
    /**
     */
    @NotNull
    @Size(min = 2)
    private String role_name;
}
