package com.tsoy.emrmock.components;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tsoy.emrmock.domain.EmployeeInfo;

@Component
public class EmrUserComponent implements UserDetailsService{
	
	public EmrUserComponent() {
		System.out.println("CREATING EMRUSERCOMPONENT");
	}
	@Override
	public EmployeeInfo loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		
		EmployeeInfo employee = EmployeeInfo.findUserByName(username);
		
		if (employee == null) {
			throw new UsernameNotFoundException("Invalid username/password.");
		}
		
		return employee;
	}

}
