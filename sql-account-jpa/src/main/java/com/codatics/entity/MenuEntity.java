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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.codatics.common.entity.CommonEntity;
import com.codatics.dto.accountservices.Menu;
import com.codatics.dto.accountservices.Privilege;

@Entity
@Table(name = "LI_MENU")
public class MenuEntity extends CommonEntity<Menu> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3098923044453747120L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String menuCode;
	private String title;
	private String url;
	private String tabName;
	private int orderNo;

	@OneToOne
	@JoinColumn(name = "privilegeCode", referencedColumnName = "privilegeCode")
	private PrivilegeEntity privilege;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentCode", referencedColumnName = "menuCode")
	@NotFound(action = NotFoundAction.IGNORE)
	private MenuEntity parentMenu;

	@OneToMany(mappedBy = "parentMenu")
	@OrderBy("orderNo")
	private List<MenuEntity> childMenus = new ArrayList<MenuEntity>();

	public MenuEntity() {
		ignoreList = new String[] { "privilege", "parentMenu", "childMenus" };
	}

	@Override
	public void fromDomain(Menu domain, boolean includeChild) {
		super.fromDomain(domain, includeChild);

		if (domain.getPrivilege() != null) {
			PrivilegeEntity targetPrivilege = new PrivilegeEntity();
			targetPrivilege.fromDomain(domain.getPrivilege(), false);
			setPrivilege(targetPrivilege);
		}

		if (domain.getParentMenu() != null) {
			MenuEntity targetMenu = new MenuEntity();
			targetMenu.fromDomain(domain.getParentMenu(), false);
			setParentMenu(targetMenu);
		}

		if (includeChild) {

			List<MenuEntity> childs = new ArrayList<MenuEntity>();

			if (domain.getChildMenus() != null) {
				for (Menu me : domain.getChildMenus()) {
					MenuEntity targetChildMenu = new MenuEntity();
					targetChildMenu.fromDomain(me);
					childs.add(targetChildMenu);
				}
			}

			setChildMenus(childs);
		}
	}

	@Override
	public Menu toDomain(Class<Menu> clazz, boolean includeChild) {
		Menu result = super.toDomain(clazz, includeChild);

		if (getPrivilege() != null)
			result.setPrivilege(getPrivilege().toDomain(Privilege.class, false));

		if (getParentMenu() != null)
			result.setParentMenu(getParentMenu().toDomain(Menu.class, false));

		if (includeChild) {
			List<Menu> childs = new ArrayList<Menu>();

			if (getChildMenus() != null) {
				for (MenuEntity me : getChildMenus()) {
					childs.add(me.toDomain(Menu.class, true));
				}
			}

			result.setChildMenus(childs);
		}

		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public PrivilegeEntity getPrivilege() {
		return privilege;
	}

	public void setPrivilege(PrivilegeEntity privilege) {
		this.privilege = privilege;
	}

	public MenuEntity getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuEntity parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<MenuEntity> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<MenuEntity> childMenus) {
		this.childMenus = childMenus;
	}

}