package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdInfoCustomFieldContentDao;
import com.ebiz.bp_mysql.domain.PdInfoCustomFieldContent;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class PdInfoCustomFieldContentDaoSqlMapImpl extends EntityDaoSqlMapImpl<PdInfoCustomFieldContent> implements
		PdInfoCustomFieldContentDao {

}
