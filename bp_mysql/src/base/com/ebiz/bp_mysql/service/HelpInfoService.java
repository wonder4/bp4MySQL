package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.HelpInfo;

public interface HelpInfoService {

	Integer createHelpInfo(HelpInfo t);

	int modifyHelpInfo(HelpInfo t);

	int removeHelpInfo(HelpInfo t);

	HelpInfo getHelpInfo(HelpInfo t);

	List<HelpInfo> getHelpInfoList(HelpInfo t);

	Integer getHelpInfoCount(HelpInfo t);

	List<HelpInfo> getHelpInfoPaginatedList(HelpInfo t);

}
