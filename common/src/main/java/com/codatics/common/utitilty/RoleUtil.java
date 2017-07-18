package com.codatics.common.utitilty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.codatics.common.enumerate.Role;

public class RoleUtil {

	public static Set<String> RoleToSet(List<Role> role) {
		Set<String> set = new HashSet<String>(role.size());

		for (Role r : role) {
			set.add(r.name());
		}

		return set;
	}

}
