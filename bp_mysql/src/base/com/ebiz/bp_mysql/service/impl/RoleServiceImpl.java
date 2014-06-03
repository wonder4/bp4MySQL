package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.RoleDao;
import com.ebiz.bp_mysql.domain.Role;
import com.ebiz.bp_mysql.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	public Integer createRole(Role t) {
		return this.roleDao.insertEntity(t);
	}

	public Role getRole(Role t) {
		return this.roleDao.selectEntity(t);
	}

	public Integer getRoleCount(Role t) {
		return this.roleDao.selectEntityCount(t);
	}

	public List<Role> getRoleList(Role t) {
		return this.roleDao.selectEntityList(t);
	}

	public int modifyRole(Role t) {
		return this.roleDao.updateEntity(t);
	}

	public int removeRole(Role t) {
		return this.roleDao.deleteEntity(t);
	}

	public List<Role> getRolePaginatedList(Role t) {
		return this.roleDao.selectEntityPaginatedList(t);
	}

}
