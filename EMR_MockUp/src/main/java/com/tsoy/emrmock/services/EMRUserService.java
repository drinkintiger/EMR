package com.tsoy.emrmock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsoy.emrmock.domain.security.User;
import com.tsoy.emrmock.domain.security.UserDao;

@Service
public class EMRUserService implements UserDetailsService {
	@Autowired
    private UserDao userDao;
	
	public EMRUserService() {
		System.out.println("MAKING A USERSERVICE");
	}
 
    @Override
    public User loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user =  userDao.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username/password.");
        }

        return user;
    }
}
