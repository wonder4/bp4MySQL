package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.RoleUserDao;
import com.ebiz.bp_mysql.domain.RoleUser;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class RoleUserDaoSqlMapImpl extends EntityDaoSqlMapImpl<RoleUser> implements RoleUserDao {

}
