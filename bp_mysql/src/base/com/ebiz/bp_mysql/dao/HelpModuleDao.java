package com.ebiz.bp_mysql.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ebiz.bp_mysql.domain.HelpModule;
import com.ebiz.ssi.dao.EntityDao;

public interface HelpModuleDao extends EntityDao<HelpModule> {

	Integer selectHelpModuleWithLevelNumber(HelpModule t) throws DataAccessException;

	List<HelpModule> selectHelpModuleParentList(HelpModule t) throws DataAccessException;

}
