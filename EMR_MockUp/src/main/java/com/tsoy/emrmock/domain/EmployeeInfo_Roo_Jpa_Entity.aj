// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain;

import com.tsoy.emrmock.domain.EmployeeInfo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect EmployeeInfo_Roo_Jpa_Entity {
    
    declare @type: EmployeeInfo: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_")
    private Long EmployeeInfo.id_;
    
    @Version
    @Column(name = "version_")
    private Integer EmployeeInfo.version_;
    
    public Long EmployeeInfo.getId_() {
        return this.id_;
    }
    
    public void EmployeeInfo.setId_(Long id) {
        this.id_ = id;
    }
    
    public Integer EmployeeInfo.getVersion_() {
        return this.version_;
    }
    
    public void EmployeeInfo.setVersion_(Integer version) {
        this.version_ = version;
    }
    
}
