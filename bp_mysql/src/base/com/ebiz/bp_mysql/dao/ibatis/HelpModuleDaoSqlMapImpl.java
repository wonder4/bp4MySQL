package com.ebiz.bp_mysql.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ebiz.bp_mysql.dao.HelpModuleDao;
import com.ebiz.bp_mysql.domain.HelpModule;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Repository
public class HelpModuleDaoSqlMapImpl extends EntityDaoSqlMapImpl<HelpModule> implements HelpModuleDao {

	public Integer selectHelpModuleWithLevelNumber(HelpModule t) throws DataAccessException {
		return (Integer) super.getSqlMapClientTemplate().queryForObject("selectHelpModuleWithLevelNumber", t);
	}

	@SuppressWarnings("unchecked")
	public List<HelpModule> selectHelpModuleParentList(HelpModule t) throws DataAccessException {
		return super.getSqlMapClientTemplate().queryForList("selectHelpModuleParentList", t);
	}

}
