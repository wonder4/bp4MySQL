package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseProvinceDao;
import com.ebiz.bp_mysql.domain.BaseProvince;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class BaseProvinceDaoSqlMapImpl extends EntityDaoSqlMapImpl<BaseProvince> implements BaseProvinceDao {

}
