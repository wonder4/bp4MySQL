package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdContentDao;
import com.ebiz.bp_mysql.domain.PdContent;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class PdContentDaoSqlMapImpl extends EntityDaoSqlMapImpl<PdContent> implements PdContentDao {

}
