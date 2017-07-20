package com.codatics.dto.accountservices;

import java.util.ArrayList;
import java.util.List;

import com.codatics.common.domain.CommonDomain;
import com.codatics.common.state.ActiveStatus;

public class UserGroup extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2784979466221536990L;
	private String groupCode;
    private String groupName;
    private String groupDescription;
    private ActiveStatus activeStatus;
            
    private List<UserGroupPrivilege> privileges = new ArrayList<>();
    
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
    
    public List<UserGroupPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<UserGroupPrivilege> privileges) {
        this.privileges = privileges;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }
    
    
}
