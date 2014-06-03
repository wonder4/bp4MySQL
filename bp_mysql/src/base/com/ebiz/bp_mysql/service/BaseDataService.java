package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseData;

public interface BaseDataService {

	Integer createBaseData(BaseData t);

	int modifyBaseData(BaseData t);

	int removeBaseData(BaseData t);

	BaseData getBaseData(BaseData t);

	List<BaseData> getBaseDataList(BaseData t);

	Integer getBaseDataCount(BaseData t);

	List<BaseData> getBaseDataPaginatedList(BaseData t);

}