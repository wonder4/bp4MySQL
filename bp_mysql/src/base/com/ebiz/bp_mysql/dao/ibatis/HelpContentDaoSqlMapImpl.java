package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.ebiz.bp_mysql.dao.HelpContentDao;
import com.ebiz.bp_mysql.domain.HelpContent;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Repository
public class HelpContentDaoSqlMapImpl extends EntityDaoSqlMapImpl<HelpContent> implements HelpContentDao {

}
