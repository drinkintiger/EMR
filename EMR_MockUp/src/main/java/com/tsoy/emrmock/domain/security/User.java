package com.tsoy.emrmock.domain.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Long id;
 
    private List<Role> authorities;
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private Boolean enabled = true;
         
    private User(Builder b) { 
        username = b.username;
        password = b.password;
        email = b.email;        
        firstName = b.firstName;
        lastName = b.lastName;
        id = b.id; 

        authorities = b.authorities;
        accountNonExpired = b.accountNonExpired;
        accountNonLocked = b.accountNonLocked;
        credentialsNonExpired = b.credentialsNonExpired;
        enabled = b.enabled;
    }
    
    public static class Builder {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private Long id;
     

        private List<Role> authorities;
        private boolean accountNonExpired = true;
        private boolean accountNonLocked = true;
        private boolean credentialsNonExpired = true;
        private boolean enabled = true;
        
        public Builder username(String u) {
        	this.username = u;
        	return this;
        }
        
        public Builder password(String p) {
        	this.password = p;
        	return this;
        }
        
        public Builder email(String em) {
        	this.email = em;
        	return this;
        }
        
        public Builder firstName(String fn) {
        	this.firstName = fn;
        	return this;
        }
        
        public Builder lastName(String ln) {
        	this.lastName = ln;
        	return this;
        }
        
        public Builder id(Long id) {
        	this.id = id;
        	return this;
        }
        
        public Builder authorities(List<Role> authorities) {
        	this.authorities = new ArrayList<Role>(authorities);
        	return this;
        }
        
        public Builder accountNonExpired(Boolean b) {
        	this.accountNonExpired = b;
        	return this;
        }
        
        public Builder accountNonLocked(Boolean b) {
        	this.accountNonLocked = b;
        	return this;
        }
        
        public Builder credentialsNonExpired(Boolean b) {
        	this.credentialsNonExpired = b;
        	return this;
        }
        
        public Builder enabled(Boolean b) {
        	this.enabled = b;
        	return this;
        }
        
        public User build() {
        	return new User(this);
        }
    }
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
     
    @Override
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
     
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
     
    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }
     
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }
     
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }
     
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
 
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [username=");
        builder.append(username);
        builder.append(", id=");
        builder.append(id);
        builder.append(", email=");
        builder.append(email);
        builder.append(", password=");
        builder.append(password);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", authorities=");
        builder.append(authorities);
        builder.append(", accountNonExpired=");
        builder.append(accountNonExpired);
        builder.append(", accountNonLocked=");
        builder.append(accountNonLocked);
        builder.append(", credentialsNonExpired=");
        builder.append(credentialsNonExpired);
        builder.append(", enabled=");
        builder.append(enabled);
        builder.append("]");
        return builder.toString();
    }
}
