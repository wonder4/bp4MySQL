package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.SysSetting;

public interface SysSettingService {

	Integer createSysSetting(SysSetting t);

	int modifySysSetting(SysSetting t);

	int removeSysSetting(SysSetting t);

	SysSetting getSysSetting(SysSetting t);

	List<SysSetting> getSysSettingList(SysSetting t);

	Integer getSysSettingCount(SysSetting t);

	List<SysSetting> getSysSettingPaginatedList(SysSetting t);

}