// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain.patients;

import com.tsoy.emrmock.domain.patients.PatientInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PatientInfo_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager PatientInfo.entityManager;
    
    public static final EntityManager PatientInfo.entityManager() {
        EntityManager em = new PatientInfo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long PatientInfo.countPatientInfoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM PatientInfo o", Long.class).getSingleResult();
    }
    
    public static List<PatientInfo> PatientInfo.findAllPatientInfoes() {
        return entityManager().createQuery("SELECT o FROM PatientInfo o", PatientInfo.class).getResultList();
    }
    
    public static PatientInfo PatientInfo.findPatientInfo(Long id) {
        if (id == null) return null;
        return entityManager().find(PatientInfo.class, id);
    }
    
    public static List<PatientInfo> PatientInfo.findPatientInfoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM PatientInfo o", PatientInfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void PatientInfo.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void PatientInfo.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            PatientInfo attached = PatientInfo.findPatientInfo(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void PatientInfo.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void PatientInfo.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public PatientInfo PatientInfo.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        PatientInfo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
