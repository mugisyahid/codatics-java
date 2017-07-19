package com.codatics.dto.user;


import com.codatics.common.domain.CommonDomain;

public class UserSessionLock extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -8368676688302390903L;
	private UserSession session;
    private String userName;
    private String ipAddress;

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
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
