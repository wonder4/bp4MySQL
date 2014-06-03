package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.PdContent;

public interface PdContentService {

	Integer createPdContent(PdContent t);

	int modifyPdContent(PdContent t);

	int removePdContent(PdContent t);

	PdContent getPdContent(PdContent t);

	List<PdContent> getPdContentList(PdContent t);

	Integer getPdContentCount(PdContent t);

	List<PdContent> getPdContentPaginatedList(PdContent t);

}