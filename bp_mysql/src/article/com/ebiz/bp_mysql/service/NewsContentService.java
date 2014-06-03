package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.NewsContent;

public interface NewsContentService {

	Integer createNewsContent(NewsContent t);

	int modifyNewsContent(NewsContent t);

	int removeNewsContent(NewsContent t);

	NewsContent getNewsContent(NewsContent t);

	List<NewsContent> getNewsContentList(NewsContent t);

	Integer getNewsContentCount(NewsContent t);

	List<NewsContent> getNewsContentPaginatedList(NewsContent t);

}