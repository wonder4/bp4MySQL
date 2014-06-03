package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseAttributeDao;
import com.ebiz.bp_mysql.domain.BaseAttribute;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class BaseAttributeDaoSqlMapImpl extends EntityDaoSqlMapImpl<BaseAttribute> implements BaseAttributeDao {

}
