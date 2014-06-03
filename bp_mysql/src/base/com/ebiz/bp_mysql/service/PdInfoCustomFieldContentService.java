package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.PdInfoCustomFieldContent;

public interface PdInfoCustomFieldContentService {

	Integer createPdInfoCustomFieldContent(PdInfoCustomFieldContent t);

	int modifyPdInfoCustomFieldContent(PdInfoCustomFieldContent t);

	int removePdInfoCustomFieldContent(PdInfoCustomFieldContent t);

	PdInfoCustomFieldContent getPdInfoCustomFieldContent(PdInfoCustomFieldContent t);

	List<PdInfoCustomFieldContent> getPdInfoCustomFieldContentList(PdInfoCustomFieldContent t);

	Integer getPdInfoCustomFieldContentCount(PdInfoCustomFieldContent t);

	List<PdInfoCustomFieldContent> getPdInfoCustomFieldContentPaginatedList(PdInfoCustomFieldContent t);

}