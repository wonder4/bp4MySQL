package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.NewsInfo;

public interface NewsInfoService {

	Integer createNewsInfo(NewsInfo t);

	int modifyNewsInfo(NewsInfo t);

	int removeNewsInfo(NewsInfo t);

	NewsInfo getNewsInfo(NewsInfo t);

	List<NewsInfo> getNewsInfoList(NewsInfo t);

	Integer getNewsInfoCount(NewsInfo t);

	List<NewsInfo> getNewsInfoPaginatedList(NewsInfo t);

}