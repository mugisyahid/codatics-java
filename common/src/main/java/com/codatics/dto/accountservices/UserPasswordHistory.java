package com.codatics.dto.accountservices;

import java.util.Date;

import com.codatics.common.domain.CommonDomain;

public class UserPasswordHistory extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6663196482437689004L;
	private User user;
    private String password;
    private Date createDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
}
