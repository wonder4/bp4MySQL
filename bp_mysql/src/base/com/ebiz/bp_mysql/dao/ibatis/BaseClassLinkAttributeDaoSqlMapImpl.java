package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseClassLinkAttributeDao;
import com.ebiz.bp_mysql.domain.BaseClassLinkAttribute;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class BaseClassLinkAttributeDaoSqlMapImpl extends EntityDaoSqlMapImpl<BaseClassLinkAttribute> implements
		BaseClassLinkAttributeDao {

}
