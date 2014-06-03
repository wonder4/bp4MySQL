package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.DeptInfoDao;
import com.ebiz.bp_mysql.domain.DeptInfo;
import com.ebiz.bp_mysql.service.DeptInfoService;

@Service
public class DeptInfoServiceImpl implements DeptInfoService {

	@Resource
	private DeptInfoDao deptInfoDao;

	public Integer createDeptInfo(DeptInfo t) {
		return this.deptInfoDao.insertEntity(t);
	}

	public DeptInfo getDeptInfo(DeptInfo t) {
		return this.deptInfoDao.selectEntity(t);
	}

	public Integer getDeptInfoCount(DeptInfo t) {
		return this.deptInfoDao.selectEntityCount(t);
	}

	public List<DeptInfo> getDeptInfoList(DeptInfo t) {
		return this.deptInfoDao.selectEntityList(t);
	}

	public int modifyDeptInfo(DeptInfo t) {
		return this.deptInfoDao.updateEntity(t);
	}

	public int removeDeptInfo(DeptInfo t) {
		return this.deptInfoDao.deleteEntity(t);
	}

	public List<DeptInfo> getDeptInfoPaginatedList(DeptInfo t) {
		return this.deptInfoDao.selectEntityPaginatedList(t);
	}

	public Integer getDeptInfoWithLevelNumber(DeptInfo t) {
		return this.deptInfoDao.selectDeptInfoWithLevelNumber(t);
	}

}
