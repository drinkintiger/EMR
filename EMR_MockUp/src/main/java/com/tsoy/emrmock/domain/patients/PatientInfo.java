package com.tsoy.emrmock.domain.patients;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.tsoy.emrmock.domain.Assessment;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class PatientInfo {

    /**
     */
    @NotNull
    @Size(min = 2)
    private String LastName;

    /**
     */
    @NotNull
    @Size(min = 2)
    private String FirstName;

    /**
     */
    @NotNull
    private Boolean Active;
    
    @OneToMany(mappedBy="patient", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	private Set<Assessment> assessments = new HashSet<Assessment>();
    
	public static PatientInfo findUserByFirstName(String name) {
		if (name == null)
			return null;
		
		PatientInfo patient = entityManager().createQuery("SELECT user FROM PatientInfo user where user.FirstName = ?1", PatientInfo.class).setParameter(1, name).getSingleResult();
		
		System.out.println(patient);
		return patient;
	}
	
}
