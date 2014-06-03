package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.NewsContentDao;
import com.ebiz.bp_mysql.domain.NewsContent;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class NewsContentDaoSqlMapImpl extends EntityDaoSqlMapImpl<NewsContent> implements NewsContentDao {

}
