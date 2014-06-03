package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.RoleDao;
import com.ebiz.bp_mysql.domain.Role;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class RoleDaoSqlMapImpl extends EntityDaoSqlMapImpl<Role> implements RoleDao {

}
