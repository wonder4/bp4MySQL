package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.ModPopedomDao;
import com.ebiz.bp_mysql.domain.ModPopedom;
import com.ebiz.bp_mysql.service.ModPopedomService;

@Service
public class ModPopedomServiceImpl implements ModPopedomService {

	@Resource
	private ModPopedomDao modPopedomDao;

	public Integer createModPopedom(ModPopedom t) {
		this.modPopedomDao.deleteEntity(t);

		List<ModPopedom> modPopedomList = t.getModPopedomList();
		if (null != modPopedomList) {
			for (ModPopedom modPopedom : modPopedomList) {
				modPopedom.setUser_id(t.getUser_id());
				modPopedom.setRole_id(t.getRole_id());
				this.modPopedomDao.insertEntity(modPopedom);
			}
		}

		return new Integer(1);
	}

	public ModPopedom getModPopedom(ModPopedom t) {
		return this.modPopedomDao.selectEntity(t);
	}

	public Integer getModPopedomCount(ModPopedom t) {
		return this.modPopedomDao.selectEntityCount(t);
	}

	public List<ModPopedom> getModPopedomList(ModPopedom t) {
		return this.modPopedomDao.selectEntityList(t);
	}

	public int modifyModPopedom(ModPopedom t) {
		return this.modPopedomDao.updateEntity(t);
	}

	public int removeModPopedom(ModPopedom t) {
		return this.modPopedomDao.deleteEntity(t);
	}

	public List<ModPopedom> getModPopedomPaginatedList(ModPopedom t) {
		return this.modPopedomDao.selectEntityPaginatedList(t);
	}

}
