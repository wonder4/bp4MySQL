package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseClassDao;
import com.ebiz.bp_mysql.domain.BaseClass;
import com.ebiz.bp_mysql.service.BaseClassService;

@Service
public class BaseClassServiceImpl implements BaseClassService {

	@Resource
	private BaseClassDao baseClassDao;

	public Integer createBaseClass(BaseClass t) {
		return this.baseClassDao.insertEntity(t);
	}

	public BaseClass getBaseClass(BaseClass t) {
		return this.baseClassDao.selectEntity(t);
	}

	public Integer getBaseClassCount(BaseClass t) {
		return this.baseClassDao.selectEntityCount(t);
	}

	public List<BaseClass> getBaseClassList(BaseClass t) {
		return this.baseClassDao.selectEntityList(t);
	}

	public int modifyBaseClass(BaseClass t) {
		return this.baseClassDao.updateEntity(t);
	}

	public int removeBaseClass(BaseClass t) {
		return this.baseClassDao.deleteEntity(t);
	}

	public List<BaseClass> getBaseClassPaginatedList(BaseClass t) {
		return this.baseClassDao.selectEntityPaginatedList(t);
	}

	@Override
	public List<BaseClass> proGetBaseClassParentList(BaseClass t) {
		return this.baseClassDao.procedureGetBaseClassParentList(t);
	}

	@Override
	public List<BaseClass> proGetBaseClassSonList(BaseClass t) {
		// TODO Auto-generated method stub
		return this.baseClassDao.procedureGetBaseClassSonList(t);
	}

}
