package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdInfoDao;
import com.ebiz.bp_mysql.domain.PdInfo;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class PdInfoDaoSqlMapImpl extends EntityDaoSqlMapImpl<PdInfo> implements PdInfoDao {

}
