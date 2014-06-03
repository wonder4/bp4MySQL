package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.HelpModule;

public interface HelpModuleService {

	Integer createHelpModule(HelpModule t);

	int modifyHelpModule(HelpModule t);

	int removeHelpModule(HelpModule t);

	HelpModule getHelpModule(HelpModule t);

	List<HelpModule> getHelpModuleList(HelpModule t);

	Integer getHelpModuleCount(HelpModule t);

	List<HelpModule> getHelpModulePaginatedList(HelpModule t);

	Integer getHelpModuleWithLevelNumber(HelpModule t);

	List<HelpModule> getHelpModuleParentList(HelpModule t);

}
