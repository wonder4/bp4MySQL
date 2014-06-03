package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.DeptInfoDao;
import com.ebiz.bp_mysql.domain.DeptInfo;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class DeptInfoDaoSqlMapImpl extends EntityDaoSqlMapImpl<DeptInfo> implements DeptInfoDao {

	public Integer selectDeptInfoWithLevelNumber(DeptInfo t) throws DataAccessException {
		return (Integer) super.getSqlMapClientTemplate().queryForObject("selectDeptInfoWithLevelNumber", t);
	}

}
