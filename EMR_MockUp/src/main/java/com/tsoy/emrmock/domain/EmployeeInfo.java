package com.tsoy.emrmock.domain;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class EmployeeInfo {

    /**
     */
	@NotNull
    private Integer employee_number;

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
    
	public static EmployeeInfo findUserByName(String name) {
		if (name == null)
			return null;
		
		List<EmployeeInfo> list = entityManager().createQuery("SELECT user FROM EmployeeInfo user where user.employee_id = ?1", EmployeeInfo.class).setParameter(1, name)
				.getResultList();

		EmployeeInfo user =  (list == null || list.size() == 0 ? null : list.get(0));
		if(user != null) {
			user = EmployeeInfo.findUserByName(user.getEmployee_id());
		}
		return user;
	}

	public Integer getEmployee_number() {
		return employee_number;
	}

	public void setEmployee_number(Integer employee_number) {
		this.employee_number = employee_number;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
}
