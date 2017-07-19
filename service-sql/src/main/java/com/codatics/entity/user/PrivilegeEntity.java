package com.codatics.entity.user;

import com.codatics.entity.common.CommonEntity;
import com.codatics.dto.user.Privilege;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parentCode", referencedColumnName = "privilegeCode")
    private PrivilegeEntity parentPrivilege;

    @OneToMany(mappedBy = "parentPrivilege")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<PrivilegeEntity> childPrivileges = new ArrayList<>();

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
            List<PrivilegeEntity> childs = new ArrayList<>();

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
            List<Privilege> childs = new ArrayList<>();

            if (getChildPrivileges() != null) {
                for (PrivilegeEntity me : getChildPrivileges()) {
                    childs.add(me.toDomain(Privilege.class, true));
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

    private PrivilegeEntity getParentPrivilege() {
        return parentPrivilege;
    }

    private void setParentPrivilege(PrivilegeEntity parentPrivilege) {
        this.parentPrivilege = parentPrivilege;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    private List<PrivilegeEntity> getChildPrivileges() {
        return childPrivileges;
    }

    private void setChildPrivileges(List<PrivilegeEntity> childPrivileges) {
        this.childPrivileges = childPrivileges;
    }
}
