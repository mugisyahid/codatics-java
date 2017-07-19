/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codatics.entity.common;


import com.codatics.common.state.ActiveStatus;
import com.codatics.common.state.DeleteStatus;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ligar.syahid
 *         <p>
 *         used to inherit properties, associations, and methods.
 *         <p>
 *         Entity inheritance must be used when you have an entity, and several
 *         sub-entities.
 *         <p>
 *         You can tell if you need one or the other by answering this questions: is
 *         there some other entity in the model which could have an association with the
 *         base class?
 */
@MappedSuperclass
public class CommonEntity<T> {


    /**
     * This annotation specifies that the property or field is not persistent.
     * It is used to annotate a property or field of an entity class, mapped
     * superclass, or embeddable class. does not save property to DB a field is
     * not to be serialized
     */
//    @Transient
//    protected Logger logger = Logger.getLogger(this.getClass());

    @Transient
    protected String[] ignoreList = new String[]{};
    /**
     * TIMESTAMP saving date and time DATE saving date TIME saving time
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Column
    private String lastUpdatedBy;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;
    @Column
    private String lastApprovedBy;
    @Column
    private String createdBy;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastApprovedTime;
    @Column
    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;
    @Column
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;
    @Column
    private boolean rejected;

    protected CommonEntity() {
        ignoreList = new String[]{};
    }

    protected void fromDomain(T domain) {

        fromDomain(domain, true);
    }

    protected void fromDomain(T domain, boolean includeChild) {

        if (domain != null) {
            BeanUtils.copyProperties(domain, this, ignoreList);
        }
    }

    protected T toDomain(Class<T> clazz) {
        return toDomain(clazz, false);
    }

    protected T toDomain(Class<T> clazz, boolean includeChild) {
        T result = null;

        try {
            result = clazz.newInstance();

            BeanUtils.copyProperties(this, result, ignoreList);
        } catch (Exception e) {
            //  logger.debug("error converting to domain :", e);
        }

        return result;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getLastApprovedBy() {
        return lastApprovedBy;
    }

    public void setLastApprovedBy(String lastApprovedBy) {
        this.lastApprovedBy = lastApprovedBy;
    }

    public Date getLastApprovedTime() {
        return lastApprovedTime;
    }

    public void setLastApprovedTime(Date lastApprovedTime) {
        this.lastApprovedTime = lastApprovedTime;
    }

    public DeleteStatus getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(DeleteStatus deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public String[] getIgnoreList() {
        return ignoreList;
    }

    public void setIgnoreList(String[] ignoreList) {
        this.ignoreList = ignoreList;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

}
