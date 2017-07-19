package com.codatics.entity.user;

import com.codatics.entity.common.CommonEntity;
import com.codatics.dto.user.UserPasswordHistory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LI_USER_PASSWORD_HISTORY")
class UserPasswordHistoryEntity extends CommonEntity<UserPasswordHistory> implements Serializable {

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
