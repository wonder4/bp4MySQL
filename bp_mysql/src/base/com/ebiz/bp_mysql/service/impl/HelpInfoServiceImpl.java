package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.HelpContentDao;
import com.ebiz.bp_mysql.dao.HelpInfoDao;
import com.ebiz.bp_mysql.domain.HelpContent;
import com.ebiz.bp_mysql.domain.HelpInfo;
import com.ebiz.bp_mysql.service.HelpInfoService;

@Service
public class HelpInfoServiceImpl implements HelpInfoService {

	@Resource
	private HelpInfoDao helpInfoDao;

	@Resource
	private HelpContentDao helpContentDao;

	public Integer createHelpInfo(HelpInfo t) {
		Integer id = this.helpInfoDao.insertEntity(t);

		HelpContent helpContent = new HelpContent();
		helpContent.setId(id);
		helpContent.setContent(t.getContent());
		this.helpContentDao.insertEntity(helpContent);

		return id;
	}

	public HelpInfo getHelpInfo(HelpInfo t) {
		return this.helpInfoDao.selectEntity(t);
	}

	public Integer getHelpInfoCount(HelpInfo t) {
		return this.helpInfoDao.selectEntityCount(t);
	}

	public List<HelpInfo> getHelpInfoList(HelpInfo t) {
		return this.helpInfoDao.selectEntityList(t);
	}

	public int modifyHelpInfo(HelpInfo t) {

		if (null != t.getContent()) {
			HelpContent helpContent = new HelpContent();
			helpContent.setId(t.getId());
			helpContent.setContent(t.getContent());
			this.helpContentDao.updateEntity(helpContent);
		}

		return this.helpInfoDao.updateEntity(t);
	}

	public int removeHelpInfo(HelpInfo t) {

		// HelpContent helpContent = new HelpContent();
		// helpContent.setId(t.getId());
		// this.helpContentDao.deleteEntity(helpContent);

		return this.helpInfoDao.deleteEntity(t);
	}

	public List<HelpInfo> getHelpInfoPaginatedList(HelpInfo t) {
		return this.helpInfoDao.selectEntityPaginatedList(t);
	}

}
