package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdInfoCustomAttrContentDao;
import com.ebiz.bp_mysql.domain.PdInfoCustomAttrContent;
import com.ebiz.bp_mysql.service.PdInfoCustomAttrContentService;

@Service
public class PdInfoCustomAttrContentServiceImpl implements PdInfoCustomAttrContentService {

	@Resource
	private PdInfoCustomAttrContentDao pdInfoCustomAttrContentDao;

	public Integer createPdInfoCustomAttrContent(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.insertEntity(t);
	}

	public PdInfoCustomAttrContent getPdInfoCustomAttrContent(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.selectEntity(t);
	}

	public Integer getPdInfoCustomAttrContentCount(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.selectEntityCount(t);
	}

	public List<PdInfoCustomAttrContent> getPdInfoCustomAttrContentList(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.selectEntityList(t);
	}

	public int modifyPdInfoCustomAttrContent(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.updateEntity(t);
	}

	public int removePdInfoCustomAttrContent(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.deleteEntity(t);
	}

	public List<PdInfoCustomAttrContent> getPdInfoCustomAttrContentPaginatedList(PdInfoCustomAttrContent t) {
		return this.pdInfoCustomAttrContentDao.selectEntityPaginatedList(t);
	}

}
