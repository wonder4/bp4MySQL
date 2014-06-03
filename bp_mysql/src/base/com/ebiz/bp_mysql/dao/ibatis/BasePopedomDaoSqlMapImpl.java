package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BasePopedomDao;
import com.ebiz.bp_mysql.domain.BasePopedom;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class BasePopedomDaoSqlMapImpl extends EntityDaoSqlMapImpl<BasePopedom> implements BasePopedomDao {

}
