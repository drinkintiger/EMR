// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.tsoy.emrmock.domain;

import com.tsoy.emrmock.domain.CNA_Record;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CNA_Record_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CNA_Record.entityManager;
    
    public static final EntityManager CNA_Record.entityManager() {
        EntityManager em = new CNA_Record().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CNA_Record.countCNA_Records() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CNA_Record o", Long.class).getSingleResult();
    }
    
    public static List<CNA_Record> CNA_Record.findAllCNA_Records() {
        return entityManager().createQuery("SELECT o FROM CNA_Record o", CNA_Record.class).getResultList();
    }
    
    public static CNA_Record CNA_Record.findCNA_Record(Long id) {
        if (id == null) return null;
        return entityManager().find(CNA_Record.class, id);
    }
    
    public static List<CNA_Record> CNA_Record.findCNA_RecordEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CNA_Record o", CNA_Record.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CNA_Record.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CNA_Record.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CNA_Record attached = CNA_Record.findCNA_Record(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CNA_Record.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CNA_Record.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CNA_Record CNA_Record.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CNA_Record merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
