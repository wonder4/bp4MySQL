package com.ebiz.bp_mysql.dao;

import org.springframework.dao.DataAccessException;

import com.ebiz.bp_mysql.domain.DeptInfo;
import com.ebiz.ssi.dao.EntityDao;

public interface DeptInfoDao extends EntityDao<DeptInfo> {

	Integer selectDeptInfoWithLevelNumber(DeptInfo t) throws DataAccessException;

}
