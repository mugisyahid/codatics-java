package com.codatics.common.domain;

import com.codatics.common.state.ActiveStatus;
import com.codatics.common.state.DeleteStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ligar.syahid
 */
public class CommonDomain implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6340616151777267244L;
    private String createdBy;
    private Date createdTime;
    private String lastUpdatedBy;
    private Date lastUpdatedTime;
    private String lastApprovedBy;
    private Date lastApprovedTime;
    private DeleteStatus deleteStatus = DeleteStatus.NOT_DELETED;
    private ActiveStatus activeStatus = ActiveStatus.ACTIVE;
    private boolean rejected;
    private int id;

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
