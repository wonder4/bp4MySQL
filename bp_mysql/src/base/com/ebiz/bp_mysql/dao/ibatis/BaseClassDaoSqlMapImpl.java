package com.ebiz.bp_mysql.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.BaseClassDao;
import com.ebiz.bp_mysql.domain.BaseClass;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class BaseClassDaoSqlMapImpl extends EntityDaoSqlMapImpl<BaseClass> implements BaseClassDao {

	@SuppressWarnings("unchecked")
	public List<BaseClass> procedureGetBaseClassSonList(BaseClass t) {
		return super.getSqlMapClientTemplate().queryForList("procedureGetBaseClassSonList", t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseClass> procedureGetBaseClassParentList(BaseClass t) {
		return super.getSqlMapClientTemplate().queryForList("procedureGetBaseClassParentList", t);
	}

}
