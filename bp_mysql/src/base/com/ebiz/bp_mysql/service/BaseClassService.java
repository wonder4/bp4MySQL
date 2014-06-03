package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseClass;

public interface BaseClassService {

	Integer createBaseClass(BaseClass t);

	int modifyBaseClass(BaseClass t);

	int removeBaseClass(BaseClass t);

	BaseClass getBaseClass(BaseClass t);

	List<BaseClass> getBaseClassList(BaseClass t);

	Integer getBaseClassCount(BaseClass t);

	List<BaseClass> getBaseClassPaginatedList(BaseClass t);

	List<BaseClass> proGetBaseClassParentList(BaseClass t);

	List<BaseClass> proGetBaseClassSonList(BaseClass t);

}