package com.codatics.entity.user;

import com.codatics.entity.common.CommonEntity;
import com.codatics.dto.user.UserGroup;
import com.codatics.dto.user.UserGroupPrivilege;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LI_USERGROUP")
public class UserGroupEntity extends CommonEntity<UserGroup> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 962876384434484776L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String groupCode;
    private String groupName;
    private String groupDescription;

    @OneToMany(mappedBy = "userGroup")
    private List<UserGroupPrivilegeEntity> privileges;

    public UserGroupEntity() {
        ignoreList = new String[]{"privileges"};
    }

    @Override
    public void fromDomain(UserGroup domain, boolean includeChild) {
        super.fromDomain(domain, includeChild);

        if (includeChild) {
            List<UserGroupPrivilegeEntity> childs = new ArrayList<>();

            if (domain.getPrivileges() != null) {
                for (UserGroupPrivilege me : domain.getPrivileges()) {
                    UserGroupPrivilegeEntity targetChild = new UserGroupPrivilegeEntity();
                    targetChild.setUserGroup(this);
                    //targetChild.fromDomain(me);
                    childs.add(targetChild);
                }
            }

            setPrivileges(childs);
        }
    }

    @Override
    public UserGroup toDomain(Class<UserGroup> clazz, boolean includePrivilege) {
        UserGroup result = super.toDomain(clazz, includePrivilege);

        if (includePrivilege && (getPrivileges() != null)) {

            List<UserGroupPrivilege> targetPrivileges = new ArrayList<>();

            for (UserGroupPrivilegeEntity privEntity : getPrivileges()) {
               // targetPrivileges.add(privEntity.toDomain(UserGroupPrivilege.class));
            }

            result.setPrivileges(targetPrivileges);
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    private List<UserGroupPrivilegeEntity> getPrivileges() {
        return privileges;
    }

    private void setPrivileges(List<UserGroupPrivilegeEntity> privileges) {
        this.privileges = privileges;
    }

}
