package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.PdInfo;

public interface PdInfoService {

	Integer createPdInfo(PdInfo t);

	int modifyPdInfo(PdInfo t);

	int removePdInfo(PdInfo t);

	PdInfo getPdInfo(PdInfo t);

	List<PdInfo> getPdInfoList(PdInfo t);

	Integer getPdInfoCount(PdInfo t);

	List<PdInfo> getPdInfoPaginatedList(PdInfo t);

}