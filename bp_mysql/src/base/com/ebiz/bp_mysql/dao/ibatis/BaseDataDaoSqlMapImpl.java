package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseDataDao;
import com.ebiz.bp_mysql.domain.BaseData;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class BaseDataDaoSqlMapImpl extends EntityDaoSqlMapImpl<BaseData> implements BaseDataDao {

}
