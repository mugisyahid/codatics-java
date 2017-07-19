package com.codatics.dto.user;

import java.util.Date;

public class UserSession extends CommonDomain {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7346806089519806548L;
	private User user;
    private String sessionId;
    private String workStation;
    private Date loginTime;
    private Date logoutTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getWorkStation() {
        return workStation;
    }

    public void setWorkStation(String workStation) {
        this.workStation = workStation;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
    
    
}
