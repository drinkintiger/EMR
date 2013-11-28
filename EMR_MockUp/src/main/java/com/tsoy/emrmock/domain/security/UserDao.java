package com.tsoy.emrmock.domain.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	private Map<String, User> byUsername;
	private Map<Long, User> byId;
	private IdGenerator ids;
	
	private static class IdGenerator {
		long id = 0;
		public synchronized Long getNextId() {
			id = id + 1;
			return id;
		}
	}
			
	public UserDao() {
		System.out.println("CONSTRUCTING USERDAO");
		byUsername = new HashMap<String, User>();
		byId = new HashMap<Long, User>();
		ids = new IdGenerator();
		
		List<Role> authorities = new ArrayList<Role>(2);
		authorities.add(new Role("ROLE_USER"));

		// password is 123
		User u1 = new User.Builder().firstName("Kenny").lastName("Hunt").username("cs402").password("$2a$10$1RALYtVaCaM0EcIkVQ1.6.nwtuWv.yRKLsv4aU3jJk2NkpbDOpva6").authorities(authorities).build();
		addUser(u1);
		
		authorities = new ArrayList<Role>(authorities);				
		authorities.add(new Role("ROLE_ADMIN"));
		
		for(Role r : authorities) {
			System.out.println(r);
		}
		// password is 456
		User u2 = new User.Builder().firstName("Karen").lastName("Hunt").username("cs502").password("$2a$10$X6DCAVpiVmbC/qAA563MOuV.udKsaTCnnDIcUVg7ETay6Yduq7zZW").authorities(authorities).build();
		addUser(u2);
	}
	
	public User findUserById(Long id) {
		return byId.get(id);
	}
	
	public void addUser(User user) {
		if(user == null || user.getUsername() == null || user.getPassword() == null || user.getId() != null || byUsername.containsKey(user.getUsername())) {
			throw new IllegalStateException("Error adding user");
		}
		
		user.setId(ids.getNextId());
		
		if(user.getAuthorities() == null || user.getAuthorities().isEmpty()) {
			List<Role> authorities = new ArrayList<Role>(1);
			authorities.add(new Role("ROLE_USER"));	
			user.setAuthorities(authorities);
		}
		
		System.out.println("added(" + user + ")");
		
		byUsername.put(user.getUsername(), user);
		byId.put(user.getId(), user);
	}
	
	public User findUserByUsername(String name) {
		System.out.println("finding(" + name + ")");
		printAll();		
		return byUsername.get(name);
	}
	
	public void removeUser(Long id) {
		User user = byId.get(id);
		byId.remove(id);		
		byUsername.remove(user.getUsername());
	}
	
	public void printAll() {
		System.out.println("by-username");
		for(String username : byUsername.keySet()) {
			System.out.println(username + ":" + byUsername.get(username));
		}
		System.out.println("by-id");
		for(Long id : byId.keySet()) {
			System.out.println(id + ":" + byId.get(id));
		}
		System.out.println("=========================");
	}
}