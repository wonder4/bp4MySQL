package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.QaInfoDao;
import com.ebiz.bp_mysql.domain.QaInfo;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class QaInfoDaoSqlMapImpl extends EntityDaoSqlMapImpl<QaInfo> implements QaInfoDao {

}
