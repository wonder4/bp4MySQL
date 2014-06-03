package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseProvince;

public interface BaseProvinceService {

	Integer createBaseProvince(BaseProvince t);

	int modifyBaseProvince(BaseProvince t);

	int removeBaseProvince(BaseProvince t);

	BaseProvince getBaseProvince(BaseProvince t);

	List<BaseProvince> getBaseProvinceList(BaseProvince t);

	Integer getBaseProvinceCount(BaseProvince t);

	List<BaseProvince> getBaseProvincePaginatedList(BaseProvince t);

}