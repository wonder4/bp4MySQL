package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.Role;

public interface RoleService {

	Integer createRole(Role t);

	int modifyRole(Role t);

	int removeRole(Role t);

	Role getRole(Role t);

	List<Role> getRoleList(Role t);

	Integer getRoleCount(Role t);

	List<Role> getRolePaginatedList(Role t);

}