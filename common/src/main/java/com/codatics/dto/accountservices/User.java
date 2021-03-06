package com.codatics.dto.accountservices;

import java.util.Date;
import java.util.List;

import com.codatics.common.domain.CommonDomain;
import com.codatics.common.enumerate.Role;

public class User extends CommonDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2562339538325299900L;
	protected String userName;
	protected String fullName;
	protected String password;
	protected String email;
	protected String mobilePhone;

	protected boolean locked;

	protected int loginAttempt;
	protected Date loginDate;
	protected Date logoutDate;
	protected Date credentialsExpiredDate;

	protected String remoteAddress;
	protected String remoteHost;
	protected String sessionID;

	protected List<Role> role;

	private boolean passwordNeverExpired;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Date getCredentialsExpiredDate() {
		return credentialsExpiredDate;
	}

	public void setCredentialsExpiredDate(Date credentialsExpiredDate) {
		this.credentialsExpiredDate = credentialsExpiredDate;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public boolean isPasswordNeverExpired() {
		return passwordNeverExpired;
	}

	public void setPasswordNeverExpired(boolean passwordNeverExpired) {
		this.passwordNeverExpired = passwordNeverExpired;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

}
