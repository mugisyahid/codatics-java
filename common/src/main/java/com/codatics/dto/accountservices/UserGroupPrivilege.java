package com.codatics.dto.accountservices;

import com.codatics.common.domain.CommonDomain;
import com.codatics.common.enumerate.AccessType;

public class UserGroupPrivilege extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7001840918381233505L;
	private UserGroup userGroup;
    private Privilege privilege;
    private AccessType accessType;
    private AccessType parentAccessType;
    
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
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
