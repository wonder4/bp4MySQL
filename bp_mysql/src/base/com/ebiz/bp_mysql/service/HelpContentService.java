package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.HelpContent;

public interface HelpContentService {

	Integer createHelpContent(HelpContent t);

	int modifyHelpContent(HelpContent t);

	int removeHelpContent(HelpContent t);

	HelpContent getHelpContent(HelpContent t);

	List<HelpContent> getHelpContentList(HelpContent t);

	Integer getHelpContentCount(HelpContent t);

	List<HelpContent> getHelpContentPaginatedList(HelpContent t);

}
