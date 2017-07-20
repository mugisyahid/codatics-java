package com.codatics.dto.accountservices;

import java.util.ArrayList;
import java.util.List;

import com.codatics.common.domain.CommonDomain;

public class Privilege extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6897837080836307216L;
	private String privilegeCode;
    private String privilegeName;

    private String displayName;
    
    private Privilege parentPrivilege;
    private List<Privilege> childPrivileges = new ArrayList<Privilege>();

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Privilege getParentPrivilege() {
        return parentPrivilege;
    }

    public void setParentPrivilege(Privilege parentPrivilege) {
        this.parentPrivilege = parentPrivilege;
    }

    public List<Privilege> getChildPrivileges() {
        return childPrivileges;
    }

    public void setChildPrivileges(List<Privilege> childPrivileges) {
        this.childPrivileges = childPrivileges;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
