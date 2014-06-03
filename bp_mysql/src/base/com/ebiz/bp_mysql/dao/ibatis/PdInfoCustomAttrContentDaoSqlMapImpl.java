package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdInfoCustomAttrContentDao;
import com.ebiz.bp_mysql.domain.PdInfoCustomAttrContent;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class PdInfoCustomAttrContentDaoSqlMapImpl extends EntityDaoSqlMapImpl<PdInfoCustomAttrContent> implements
		PdInfoCustomAttrContentDao {

}
