// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain.users;

import com.tsoy.emrmock.domain.users.EmployeeInfo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect EmployeeInfo_Roo_Jpa_Entity {
    
    declare @type: EmployeeInfo: @Entity;
    
    declare @type: EmployeeInfo: @Table(name = "employee_info");
    
    @Version
    @Column(name = "version")
    private Integer EmployeeInfo.version;
    
    public Integer EmployeeInfo.getVersion() {
        return this.version;
    }
    
    public void EmployeeInfo.setVersion(Integer version) {
        this.version = version;
    }
    
}