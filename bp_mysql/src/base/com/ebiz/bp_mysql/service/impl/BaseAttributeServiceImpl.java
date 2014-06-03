package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseAttributeDao;
import com.ebiz.bp_mysql.dao.BaseAttributeSonDao;
import com.ebiz.bp_mysql.domain.BaseAttribute;
import com.ebiz.bp_mysql.domain.BaseAttributeSon;
import com.ebiz.bp_mysql.service.BaseAttributeService;

@Service
public class BaseAttributeServiceImpl implements BaseAttributeService {

	@Resource
	private BaseAttributeDao baseAttributeDao;

	@Resource
	private BaseAttributeSonDao baseAttributeSonDao;

	public Integer createBaseAttribute(BaseAttribute t) {
		Integer id = this.baseAttributeDao.insertEntity(t);
		// 子属性添加
		List<BaseAttributeSon> baseAttributeSonList = t.getBaseAttributeSonList();
		if (null != baseAttributeSonList && baseAttributeSonList.size() > 0) {
			for (BaseAttributeSon son : baseAttributeSonList) {
				son.setAttr_id(id);
				this.baseAttributeSonDao.insertEntity(son);
			}
		}
		return id;
	}

	public BaseAttribute getBaseAttribute(BaseAttribute t) {
		return this.baseAttributeDao.selectEntity(t);
	}

	public Integer getBaseAttributeCount(BaseAttribute t) {
		return this.baseAttributeDao.selectEntityCount(t);
	}

	public List<BaseAttribute> getBaseAttributeList(BaseAttribute t) {
		return this.baseAttributeDao.selectEntityList(t);
	}

	public int modifyBaseAttribute(BaseAttribute t) {
		int id = this.baseAttributeDao.updateEntity(t);
		String del_attr_id = (String) t.getMap().get("del_attr_id");
		if (StringUtils.isNotBlank(del_attr_id)) {
			String del_id[] = del_attr_id.split(",");
			if (null != del_id && del_id.length > 0) {
				for (int i = 0; i < del_id.length; i++) {
					if (StringUtils.isNotBlank(del_id[i])) {
						BaseAttributeSon del_son = new BaseAttributeSon();
						del_son.setId(Integer.valueOf(del_id[i]));
						this.baseAttributeSonDao.deleteEntity(del_son);
					}
				}
			}
		}
		// 子属性添加
		List<BaseAttributeSon> baseAttributeSonList = t.getBaseAttributeSonList();
		if (null != baseAttributeSonList && baseAttributeSonList.size() > 0) {
			for (BaseAttributeSon son : baseAttributeSonList) {
				son.setAttr_id(t.getId());
				this.baseAttributeSonDao.insertEntity(son);
			}
		}
		return id;
	}

	public int removeBaseAttribute(BaseAttribute t) {
		return this.baseAttributeDao.deleteEntity(t);
	}

	public List<BaseAttribute> getBaseAttributePaginatedList(BaseAttribute t) {
		return this.baseAttributeDao.selectEntityPaginatedList(t);
	}

}
