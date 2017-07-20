package com.codatics.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.codatics.common.entity.CommonEntity;
import com.codatics.dto.accountservices.UserGroup;
import com.codatics.dto.accountservices.UserGroupPrivilege;

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
		ignoreList = new String[] { "privileges" };
	}

	@Override
	public void fromDomain(UserGroup domain, boolean includeChild) {
		super.fromDomain(domain, includeChild);

		if (includeChild) {
			List<UserGroupPrivilegeEntity> childs = new ArrayList<UserGroupPrivilegeEntity>();

			if (domain.getPrivileges() != null) {
				for (UserGroupPrivilege me : domain.getPrivileges()) {
					UserGroupPrivilegeEntity targetChild = new UserGroupPrivilegeEntity();
					targetChild.setUserGroup(this);
					targetChild.fromDomain(me);
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

			List<UserGroupPrivilege> targetPrivileges = new ArrayList<UserGroupPrivilege>();

			for (UserGroupPrivilegeEntity privEntity : getPrivileges()) {
				targetPrivileges.add(privEntity.toDomain(UserGroupPrivilege.class));
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

	public List<UserGroupPrivilegeEntity> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<UserGroupPrivilegeEntity> privileges) {
		this.privileges = privileges;
	}

}
