package com.codatics.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.codatics.common.entity.CommonEntity;
import com.codatics.dto.accountservices.Privilege;

@Entity
@Table(name = "LI_PRIVILEGE")
public class PrivilegeEntity extends CommonEntity<Privilege> implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5864336866837304361L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
            
    private String privilegeCode;
    private String privilegeName;
    
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parentCode", referencedColumnName = "privilegeCode")
    private PrivilegeEntity parentPrivilege;

    @OneToMany(mappedBy="parentPrivilege")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<PrivilegeEntity> childPrivileges = new ArrayList<PrivilegeEntity>();

    public PrivilegeEntity() {
        ignoreList = new String[]{"parentPrivilege", "childPrivileges"};
    }

    @Override
    public void fromDomain(Privilege domain, boolean includeChild) {
        super.fromDomain(domain, includeChild);
        
        if (domain.getParentPrivilege() != null) {
            PrivilegeEntity targetPrivilege = new PrivilegeEntity();
            targetPrivilege.fromDomain(domain.getParentPrivilege(), false);
            setParentPrivilege(targetPrivilege);
        }
        
        if (includeChild) {
            List<PrivilegeEntity> childs = new ArrayList<PrivilegeEntity>();

            if (domain.getChildPrivileges() != null) {
                for (Privilege me : domain.getChildPrivileges()) {
                    PrivilegeEntity targetChild = new PrivilegeEntity();
                    targetChild.fromDomain(me);
                    childs.add(targetChild);
                }
            }
            
            setChildPrivileges(childs);
        }
    }

    @Override
    public Privilege toDomain(Class<Privilege> clazz, boolean includeChild) {
        Privilege result = super.toDomain(clazz, includeChild);
        
        if (getParentPrivilege() != null)
            result.setParentPrivilege(getParentPrivilege().toDomain(Privilege.class, false));

        if (includeChild) {
            List<Privilege> childs = new ArrayList<Privilege>();

            if (getChildPrivileges() != null) {
                for (PrivilegeEntity me : getChildPrivileges()) {
                    childs.add(me.toDomain(Privilege.class, includeChild));
                }
            }

            result.setChildPrivileges(childs);

        }
        
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public PrivilegeEntity getParentPrivilege() {
        return parentPrivilege;
    }

    public void setParentPrivilege(PrivilegeEntity parentPrivilege) {
        this.parentPrivilege = parentPrivilege;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public List<PrivilegeEntity> getChildPrivileges() {
        return childPrivileges;
    }

    public void setChildPrivileges(List<PrivilegeEntity> childPrivileges) {
        this.childPrivileges = childPrivileges;
    }    
}
