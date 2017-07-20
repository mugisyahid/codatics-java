package com.codatics.common.utitilty;

import com.codatics.common.enumerate.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleUtil {

	public static Set<String> RoleToSet(List<Role> role) {
		Set<String> set = new HashSet<String>(role.size());

		for (Role r : role) {
			set.add(r.name());
		}

		return set;
	}

}
