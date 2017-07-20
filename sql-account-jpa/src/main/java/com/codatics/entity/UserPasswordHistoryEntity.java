package com.codatics.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.codatics.common.entity.CommonEntity;
import com.codatics.dto.accountservices.UserPasswordHistory;

@Entity
@Table(name = "LI_USER_PASSWORD_HISTORY")
public class UserPasswordHistoryEntity extends CommonEntity<UserPasswordHistory> implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1145889158995038235L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;
    
    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
