package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.ModPopedomDao;
import com.ebiz.bp_mysql.domain.ModPopedom;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class ModPopedomDaoSqlMapImpl extends EntityDaoSqlMapImpl<ModPopedom> implements ModPopedomDao {

}
