package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseBrandInfo;

public interface BaseBrandInfoService {

	Integer createBaseBrandInfo(BaseBrandInfo t);

	int modifyBaseBrandInfo(BaseBrandInfo t);

	int removeBaseBrandInfo(BaseBrandInfo t);

	BaseBrandInfo getBaseBrandInfo(BaseBrandInfo t);

	List<BaseBrandInfo> getBaseBrandInfoList(BaseBrandInfo t);

	Integer getBaseBrandInfoCount(BaseBrandInfo t);

	List<BaseBrandInfo> getBaseBrandInfoPaginatedList(BaseBrandInfo t);

}