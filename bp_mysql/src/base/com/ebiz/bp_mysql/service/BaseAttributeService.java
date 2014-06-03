package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseAttribute;

public interface BaseAttributeService {

	Integer createBaseAttribute(BaseAttribute t);

	int modifyBaseAttribute(BaseAttribute t);

	int removeBaseAttribute(BaseAttribute t);

	BaseAttribute getBaseAttribute(BaseAttribute t);

	List<BaseAttribute> getBaseAttributeList(BaseAttribute t);

	Integer getBaseAttributeCount(BaseAttribute t);

	List<BaseAttribute> getBaseAttributePaginatedList(BaseAttribute t);

}