package com.codatics.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.codatics.common.entity.CommonEntity;
import com.codatics.common.enumerate.Role;
import com.codatics.dto.accountservices.User;

@Entity
// @ToString(exclude = "password")
@Table(name = "LI_USER")
public class UserEntity extends CommonEntity<User> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 900277849121260778L;

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	protected String userName;
	@Column
	protected String fullName;
	@Column
	@JsonIgnore
	protected String password;
	@Column
	protected String email;
	@Column
	protected String mobilePhone;
	@Column
	protected boolean locked;
	@Column
	protected int loginAttempt;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date loginDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date logoutDate;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date credentialsExpiredDate;
	@Column
	protected String remoteAddress;
	@Column
	protected String remoteHost;
	@Column
	protected String sessionID;

	@Column
	private boolean passwordNeverExpired;

	@Column
	@Enumerated
	@ElementCollection(targetClass = Role.class)
	protected List<Role> role;

	public UserEntity() {
		ignoreList = new String[] { "role" };
	}

	@Override
	public User toDomain(Class<User> clazz) {
		return super.toDomain(clazz, false);
	}

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
		this.password = PASSWORD_ENCODER.encode(password);
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

}
