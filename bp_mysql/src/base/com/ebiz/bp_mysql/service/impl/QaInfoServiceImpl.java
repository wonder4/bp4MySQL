package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.QaInfoDao;
import com.ebiz.bp_mysql.domain.QaInfo;
import com.ebiz.bp_mysql.service.QaInfoService;

@Service
public class QaInfoServiceImpl implements QaInfoService {

	@Resource
	private QaInfoDao qaInfoDao;

	public Integer createQaInfo(QaInfo t) {
		return this.qaInfoDao.insertEntity(t);
	}

	public QaInfo getQaInfo(QaInfo t) {
		return this.qaInfoDao.selectEntity(t);
	}

	public Integer getQaInfoCount(QaInfo t) {
		return this.qaInfoDao.selectEntityCount(t);
	}

	public List<QaInfo> getQaInfoList(QaInfo t) {
		return this.qaInfoDao.selectEntityList(t);
	}

	public int modifyQaInfo(QaInfo t) {
		return this.qaInfoDao.updateEntity(t);
	}

	public int removeQaInfo(QaInfo t) {
		return this.qaInfoDao.deleteEntity(t);
	}

	public List<QaInfo> getQaInfoPaginatedList(QaInfo t) {
		return this.qaInfoDao.selectEntityPaginatedList(t);
	}

}
