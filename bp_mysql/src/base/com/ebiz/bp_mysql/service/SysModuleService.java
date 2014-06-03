package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.SysModule;

public interface SysModuleService {

	Integer createSysModule(SysModule t);

	int modifySysModule(SysModule t);

	int removeSysModule(SysModule t);

	SysModule getSysModule(SysModule t);

	List<SysModule> getSysModuleList(SysModule t);

	Integer getSysModuleCount(SysModule t);

	List<SysModule> getSysModulePaginatedList(SysModule t);

	List<SysModule> proGetSysModelParentList(SysModule t);

	List<SysModule> proGetSysModuleSonList(SysModule t);

	// List<SysModule> getSysModuleListForModPopedom(SysModule t);

}