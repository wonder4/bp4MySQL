package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.NewsAttachment;

public interface NewsAttachmentService {

	Integer createNewsAttachment(NewsAttachment t);

	int modifyNewsAttachment(NewsAttachment t);

	int removeNewsAttachment(NewsAttachment t);

	NewsAttachment getNewsAttachment(NewsAttachment t);

	List<NewsAttachment> getNewsAttachmentList(NewsAttachment t);

	Integer getNewsAttachmentCount(NewsAttachment t);

	List<NewsAttachment> getNewsAttachmentPaginatedList(NewsAttachment t);

}