package com.ebiz.bp_mysql.dao;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseClass;
import com.ebiz.ssi.dao.EntityDao;

public interface BaseClassDao extends EntityDao<BaseClass> {

	List<BaseClass> procedureGetBaseClassParentList(BaseClass t);

	List<BaseClass> procedureGetBaseClassSonList(BaseClass t);

}
