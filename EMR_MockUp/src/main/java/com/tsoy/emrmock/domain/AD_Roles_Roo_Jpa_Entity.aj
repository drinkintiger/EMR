// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain;

import com.tsoy.emrmock.domain.AD_Roles;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect AD_Roles_Roo_Jpa_Entity {
    
    declare @type: AD_Roles: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long AD_Roles.id;
    
    @Version
    @Column(name = "version")
    private Integer AD_Roles.version;
    
    public Long AD_Roles.getId() {
        return this.id;
    }
    
    public void AD_Roles.setId(Long id) {
        this.id = id;
    }
    
    public Integer AD_Roles.getVersion() {
        return this.version;
    }
    
    public void AD_Roles.setVersion(Integer version) {
        this.version = version;
    }
    
}
