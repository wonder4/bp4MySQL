package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.SysModuleDao;
import com.ebiz.bp_mysql.domain.SysModule;
import com.ebiz.bp_mysql.service.SysModuleService;

@Service
public class SysModuleServiceImpl implements SysModuleService {

	@Resource
	private SysModuleDao sysModuleDao;

	public Integer createSysModule(SysModule t) {
		return this.sysModuleDao.insertEntity(t);
	}

	public SysModule getSysModule(SysModule t) {
		return this.sysModuleDao.selectEntity(t);
	}

	public Integer getSysModuleCount(SysModule t) {
		return this.sysModuleDao.selectEntityCount(t);
	}

	public List<SysModule> getSysModuleList(SysModule t) {
		return this.sysModuleDao.selectEntityList(t);
	}

	public int modifySysModule(SysModule t) {
		return this.sysModuleDao.updateEntity(t);
	}

	public int removeSysModule(SysModule t) {
		return this.sysModuleDao.deleteEntity(t);
	}

	public List<SysModule> getSysModulePaginatedList(SysModule t) {
		return this.sysModuleDao.selectEntityPaginatedList(t);
	}

	public List<SysModule> proGetSysModelParentList(SysModule t) {
		return this.sysModuleDao.procedureGetSysModelParentList(t);
	}

	public List<SysModule> proGetSysModuleSonList(SysModule t) {
		return this.sysModuleDao.procedureGetSysModelSonList(t);
	}

	// public List<SysModule> getSysModuleListForModPopedom(SysModule t) {
	// return sysModuleDao.selectSysModuleListForModPopedom(t);
	// }

}
