package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.RoleUser;

public interface RoleUserService {

	Integer createRoleUser(RoleUser t);

	int modifyRoleUser(RoleUser t);

	int removeRoleUser(RoleUser t);

	RoleUser getRoleUser(RoleUser t);

	List<RoleUser> getRoleUserList(RoleUser t);

	Integer getRoleUserCount(RoleUser t);

	List<RoleUser> getRoleUserPaginatedList(RoleUser t);

}