package com.codatics.entity.user;

import com.codatics.entity.common.CommonEntity;
import com.codatics.dto.user.UserSession;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LI_USER_SESSION")
public class UserSessionEntity extends CommonEntity<UserSession> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 626495568408444825L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    private String sessionId;
    private String workStation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutTime;

    public UserSessionEntity() {
        ignoreList = new String[]{"user"};
    }

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


}
