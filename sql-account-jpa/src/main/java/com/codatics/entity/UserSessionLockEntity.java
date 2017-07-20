package com.codatics.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.codatics.common.entity.CommonEntity;
import com.codatics.dto.accountservices.UserSessionLock;

@Entity
@Table(name = "LI_USER_SESSION_LOCK")
public class UserSessionLockEntity extends CommonEntity<UserSessionLock> implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3301015712936296768L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "sessionId", referencedColumnName = "id")
    private UserSessionEntity session;
    
    private String userName;
    private String ipAddress;
    
    public UserSessionLockEntity() {
        ignoreList = new String[] {"session"};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserSessionEntity getSession() {
        return session;
    }

    public void setSession(UserSessionEntity session) {
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    
}
