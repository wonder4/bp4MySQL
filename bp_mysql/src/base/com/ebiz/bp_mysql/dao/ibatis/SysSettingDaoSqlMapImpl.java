package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.SysSettingDao;
import com.ebiz.bp_mysql.domain.SysSetting;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class SysSettingDaoSqlMapImpl extends EntityDaoSqlMapImpl<SysSetting> implements SysSettingDao {

}
