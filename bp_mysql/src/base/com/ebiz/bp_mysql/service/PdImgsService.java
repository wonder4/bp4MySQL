package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.PdImgs;

public interface PdImgsService {

	Integer createPdImgs(PdImgs t);

	int modifyPdImgs(PdImgs t);

	int removePdImgs(PdImgs t);

	PdImgs getPdImgs(PdImgs t);

	List<PdImgs> getPdImgsList(PdImgs t);

	Integer getPdImgsCount(PdImgs t);

	List<PdImgs> getPdImgsPaginatedList(PdImgs t);

}