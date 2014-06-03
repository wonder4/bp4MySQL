package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.NewsInfoDao;
import com.ebiz.bp_mysql.domain.NewsInfo;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class NewsInfoDaoSqlMapImpl extends EntityDaoSqlMapImpl<NewsInfo> implements NewsInfoDao {

}
