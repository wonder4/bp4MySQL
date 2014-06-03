package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BasePopedom;

public interface BasePopedomService {

	Integer createBasePopedom(BasePopedom t);

	int modifyBasePopedom(BasePopedom t);

	int removeBasePopedom(BasePopedom t);

	BasePopedom getBasePopedom(BasePopedom t);

	List<BasePopedom> getBasePopedomList(BasePopedom t);

	Integer getBasePopedomCount(BasePopedom t);

	List<BasePopedom> getBasePopedomPaginatedList(BasePopedom t);

}