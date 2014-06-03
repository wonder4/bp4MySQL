package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.PdInfoCustomAttrContent;

public interface PdInfoCustomAttrContentService {

	Integer createPdInfoCustomAttrContent(PdInfoCustomAttrContent t);

	int modifyPdInfoCustomAttrContent(PdInfoCustomAttrContent t);

	int removePdInfoCustomAttrContent(PdInfoCustomAttrContent t);

	PdInfoCustomAttrContent getPdInfoCustomAttrContent(PdInfoCustomAttrContent t);

	List<PdInfoCustomAttrContent> getPdInfoCustomAttrContentList(PdInfoCustomAttrContent t);

	Integer getPdInfoCustomAttrContentCount(PdInfoCustomAttrContent t);

	List<PdInfoCustomAttrContent> getPdInfoCustomAttrContentPaginatedList(PdInfoCustomAttrContent t);

}