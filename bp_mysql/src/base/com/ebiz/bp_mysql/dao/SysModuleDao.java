package com.ebiz.bp_mysql.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ebiz.bp_mysql.domain.SysModule;
import com.ebiz.ssi.dao.EntityDao;

public interface SysModuleDao extends EntityDao<SysModule> {

	List<SysModule> procedureGetSysModelParentList(SysModule sysModule) throws DataAccessException;

	List<SysModule> procedureGetSysModelSonList(SysModule sysModule) throws DataAccessException;

	// List<SysModule> selectSysModuleListForModPopedom(SysModule sysModule) throws DataAccessException;

}
