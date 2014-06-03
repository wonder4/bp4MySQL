package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.QaInfo;

public interface QaInfoService {

	Integer createQaInfo(QaInfo t);

	int modifyQaInfo(QaInfo t);

	int removeQaInfo(QaInfo t);

	QaInfo getQaInfo(QaInfo t);

	List<QaInfo> getQaInfoList(QaInfo t);

	Integer getQaInfoCount(QaInfo t);

	List<QaInfo> getQaInfoPaginatedList(QaInfo t);

}