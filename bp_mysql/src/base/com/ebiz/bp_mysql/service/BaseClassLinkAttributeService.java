package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.BaseClassLinkAttribute;

public interface BaseClassLinkAttributeService {

	Integer createBaseClassLinkAttribute(BaseClassLinkAttribute t);

	int modifyBaseClassLinkAttribute(BaseClassLinkAttribute t);

	int removeBaseClassLinkAttribute(BaseClassLinkAttribute t);

	BaseClassLinkAttribute getBaseClassLinkAttribute(BaseClassLinkAttribute t);

	List<BaseClassLinkAttribute> getBaseClassLinkAttributeList(BaseClassLinkAttribute t);

	Integer getBaseClassLinkAttributeCount(BaseClassLinkAttribute t);

	List<BaseClassLinkAttribute> getBaseClassLinkAttributePaginatedList(BaseClassLinkAttribute t);

}