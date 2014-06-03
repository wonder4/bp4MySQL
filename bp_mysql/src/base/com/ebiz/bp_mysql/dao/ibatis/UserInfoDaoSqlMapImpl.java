package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.UserInfoDao;
import com.ebiz.bp_mysql.domain.UserInfo;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class UserInfoDaoSqlMapImpl extends EntityDaoSqlMapImpl<UserInfo> implements UserInfoDao {

}
