package com.ebiz.bp_mysql.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.SysModuleDao;
import com.ebiz.bp_mysql.domain.SysModule;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class SysModuleDaoSqlMapImpl extends EntityDaoSqlMapImpl<SysModule> implements SysModuleDao {

	@SuppressWarnings("unchecked")
	public List<SysModule> procedureGetSysModelParentList(SysModule sysModule) throws DataAccessException {
		return super.getSqlMapClientTemplate().queryForList("procedureGetSysModelParentList", sysModule);
	}

	@SuppressWarnings("unchecked")
	public List<SysModule> procedureGetSysModelSonList(SysModule sysModule) throws DataAccessException {
		return super.getSqlMapClientTemplate().queryForList("procedureGetSysModelSonList", sysModule);
	}

	// @SuppressWarnings("unchecked")
	// public List<SysModule> selectSysModuleListForModPopedom(SysModule sysModule) throws DataAccessException {
	// return super.getSqlMapClientTemplate().queryForList("selectSysModuleListForModPopedom", sysModule);
	// }
}
