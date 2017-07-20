/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codatics.common.domain;

import com.codatics.common.state.ActiveStatus;
import com.codatics.common.state.DeleteStatus;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ligar.syahid
 */
public class CommonDomain implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6340616151777267244L;
	private int id;
    protected String createdBy;
    protected Date createdTime;
    protected String lastUpdatedBy;
    protected Date lastUpdatedTime;
    protected String lastApprovedBy;
    protected Date lastApprovedTime;
    protected DeleteStatus deleteStatus = DeleteStatus.NOT_DELETED;
    protected ActiveStatus activeStatus = ActiveStatus.ACTIVE;
    protected boolean rejected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
