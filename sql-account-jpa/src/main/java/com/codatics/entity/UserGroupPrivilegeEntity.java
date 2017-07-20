package com.codatics.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.codatics.common.entity.CommonEntity;
import com.codatics.common.enumerate.AccessType;
import com.codatics.dto.accountservices.Privilege;
import com.codatics.dto.accountservices.UserGroup;
import com.codatics.dto.accountservices.UserGroupPrivilege;

@Entity
@Table(name = "LI_USERGROUP_PRIVILEGES")
public class UserGroupPrivilegeEntity extends CommonEntity<UserGroupPrivilege> implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5384080100276059235L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "userGroupId", referencedColumnName = "id")
    private UserGroupEntity userGroup;
    
    @ManyToOne
    @JoinColumn(name = "privilegeId", referencedColumnName = "id")
    private PrivilegeEntity privilege;
    
    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @Enumerated(EnumType.STRING)
    private AccessType parentAccessType;

    public UserGroupPrivilegeEntity() {
        ignoreList = new String[] {"userGroup", "privilege"};
    }

    @Override
    public void fromDomain(UserGroupPrivilege domain, boolean includeChild) {
        super.fromDomain(domain, includeChild);
        
        if (domain.getUserGroup() != null) {
            UserGroupEntity targetGroup = new UserGroupEntity();
            targetGroup.fromDomain(domain.getUserGroup(), false);
            setUserGroup(targetGroup);
        }
        
        if (domain.getPrivilege()!= null) {
            PrivilegeEntity targetPrivilege = new PrivilegeEntity();
            targetPrivilege.fromDomain(domain.getPrivilege(), false);
            setPrivilege(targetPrivilege);
        }
    }

    @Override
    public UserGroupPrivilege toDomain(Class<UserGroupPrivilege> clazz, boolean includeChild) {
        UserGroupPrivilege result = super.toDomain(clazz, includeChild);
        
        if (getUserGroup() != null)
            result.setUserGroup(getUserGroup().toDomain(UserGroup.class, false));
        
        if (getPrivilege()!= null)
            result.setPrivilege(getPrivilege().toDomain(Privilege.class, false));
        
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
    }

    public PrivilegeEntity getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeEntity privilege) {
        this.privilege = privilege;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public AccessType getParentAccessType() {
        return parentAccessType;
    }

    public void setParentAccessType(AccessType parentAccessType) {
        this.parentAccessType = parentAccessType;
    }
    
    
}
