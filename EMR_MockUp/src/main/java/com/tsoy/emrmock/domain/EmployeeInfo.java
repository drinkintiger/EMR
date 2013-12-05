package com.tsoy.emrmock.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class EmployeeInfo implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     */
	@NotNull
    private Long employee_number;

    /**
     */
    @NotNull
    @Size(min = 2, max = 45)
    private String last_name;

    /**
     */
    @NotNull
    @Size(min = 2, max = 45)
    private String first_name;

    /**
     */
    @NotNull
    @Size(min = 2, max = 255)
    private String email;

    /**
     */
    @NotNull
    @Size(max = 128)
    private String password;
    
    @NotNull
    private String employee_id;
    
    private Long id;
    private Integer version;
    
	public static EmployeeInfo findUserByName(String name) {
		if (name == null)
			return null;
		
		List<EmployeeInfo> list = entityManager().createQuery("SELECT user FROM EmployeeInfo user where user.employee_id = ?1", EmployeeInfo.class).setParameter(1, name).getResultList();
		
		EmployeeInfo employee = (list == null || list.size() == 0 ? null : list.get(0));
		
		if (employee != null) {
			employee = EmployeeInfo.findEmployeeInfo(employee.getEmployee_number());
		}
		return employee;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return this.employee_id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
}
