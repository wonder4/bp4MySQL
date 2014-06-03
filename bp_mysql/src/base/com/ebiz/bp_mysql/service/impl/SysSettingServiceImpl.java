package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.SysSettingDao;
import com.ebiz.bp_mysql.domain.SysSetting;
import com.ebiz.bp_mysql.service.SysSettingService;

@Service
public class SysSettingServiceImpl implements SysSettingService {

	@Resource
	private SysSettingDao sysSettingDao;

	public Integer createSysSetting(SysSetting t) {
		return this.sysSettingDao.insertEntity(t);
	}

	public SysSetting getSysSetting(SysSetting t) {
		return this.sysSettingDao.selectEntity(t);
	}

	public Integer getSysSettingCount(SysSetting t) {
		return this.sysSettingDao.selectEntityCount(t);
	}

	public List<SysSetting> getSysSettingList(SysSetting t) {
		return this.sysSettingDao.selectEntityList(t);
	}

	public int modifySysSetting(SysSetting t) {
		return this.sysSettingDao.updateEntity(t);
	}

	public int removeSysSetting(SysSetting t) {
		return this.sysSettingDao.deleteEntity(t);
	}

	public List<SysSetting> getSysSettingPaginatedList(SysSetting t) {
		return this.sysSettingDao.selectEntityPaginatedList(t);
	}

}
