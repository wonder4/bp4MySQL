package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdInfoCustomFieldContentDao;
import com.ebiz.bp_mysql.domain.PdInfoCustomFieldContent;
import com.ebiz.bp_mysql.service.PdInfoCustomFieldContentService;

@Service
public class PdInfoCustomFieldContentServiceImpl implements PdInfoCustomFieldContentService {

	@Resource
	private PdInfoCustomFieldContentDao pdInfoCustomFieldContentDao;

	public Integer createPdInfoCustomFieldContent(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.insertEntity(t);
	}

	public PdInfoCustomFieldContent getPdInfoCustomFieldContent(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.selectEntity(t);
	}

	public Integer getPdInfoCustomFieldContentCount(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.selectEntityCount(t);
	}

	public List<PdInfoCustomFieldContent> getPdInfoCustomFieldContentList(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.selectEntityList(t);
	}

	public int modifyPdInfoCustomFieldContent(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.updateEntity(t);
	}

	public int removePdInfoCustomFieldContent(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.deleteEntity(t);
	}

	public List<PdInfoCustomFieldContent> getPdInfoCustomFieldContentPaginatedList(PdInfoCustomFieldContent t) {
		return this.pdInfoCustomFieldContentDao.selectEntityPaginatedList(t);
	}

}
