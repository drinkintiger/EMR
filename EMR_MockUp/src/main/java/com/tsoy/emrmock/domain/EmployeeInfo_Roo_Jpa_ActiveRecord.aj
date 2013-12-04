// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain;

import com.tsoy.emrmock.domain.EmployeeInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect EmployeeInfo_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager EmployeeInfo.entityManager;
    
    public static final EntityManager EmployeeInfo.entityManager() {
        EntityManager em = new EmployeeInfo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long EmployeeInfo.countEmployeeInfoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM EmployeeInfo o", Long.class).getSingleResult();
    }
    
    public static List<EmployeeInfo> EmployeeInfo.findAllEmployeeInfoes() {
        return entityManager().createQuery("SELECT o FROM EmployeeInfo o", EmployeeInfo.class).getResultList();
    }
    
    public static EmployeeInfo EmployeeInfo.findEmployeeInfo(Long id) {
        if (id == null) return null;
        return entityManager().find(EmployeeInfo.class, id);
    }
    
    public static List<EmployeeInfo> EmployeeInfo.findEmployeeInfoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM EmployeeInfo o", EmployeeInfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void EmployeeInfo.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void EmployeeInfo.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            EmployeeInfo attached = EmployeeInfo.findEmployeeInfo(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void EmployeeInfo.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void EmployeeInfo.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public EmployeeInfo EmployeeInfo.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        EmployeeInfo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}