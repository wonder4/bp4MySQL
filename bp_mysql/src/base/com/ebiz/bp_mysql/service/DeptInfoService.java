package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.DeptInfo;

public interface DeptInfoService {

	Integer createDeptInfo(DeptInfo t);

	int modifyDeptInfo(DeptInfo t);

	int removeDeptInfo(DeptInfo t);

	DeptInfo getDeptInfo(DeptInfo t);

	List<DeptInfo> getDeptInfoList(DeptInfo t);

	Integer getDeptInfoCount(DeptInfo t);

	List<DeptInfo> getDeptInfoPaginatedList(DeptInfo t);

	Integer getDeptInfoWithLevelNumber(DeptInfo t);

}