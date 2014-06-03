package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseDataDao;
import com.ebiz.bp_mysql.domain.BaseData;
import com.ebiz.bp_mysql.service.BaseDataService;

@Service
public class BaseDataServiceImpl implements BaseDataService {

	@Resource
	private BaseDataDao baseDataDao;

	public Integer createBaseData(BaseData t) {
		int id = this.baseDataDao.insertEntity(t);
		BaseData baseData = new BaseData();
		baseData.setId(id);
		baseData.setType_value(String.valueOf(id));
		this.baseDataDao.updateEntity(baseData);
		return id;
	}

	public BaseData getBaseData(BaseData t) {
		return this.baseDataDao.selectEntity(t);
	}

	public Integer getBaseDataCount(BaseData t) {
		return this.baseDataDao.selectEntityCount(t);
	}

	public List<BaseData> getBaseDataList(BaseData t) {
		return this.baseDataDao.selectEntityList(t);
	}

	public int modifyBaseData(BaseData t) {
		return this.baseDataDao.updateEntity(t);
	}

	public int removeBaseData(BaseData t) {
		return this.baseDataDao.deleteEntity(t);
	}

	public List<BaseData> getBaseDataPaginatedList(BaseData t) {
		return this.baseDataDao.selectEntityPaginatedList(t);
	}

}
