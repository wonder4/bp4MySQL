package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.NewsAttachmentDao;
import com.ebiz.bp_mysql.domain.NewsAttachment;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class NewsAttachmentDaoSqlMapImpl extends EntityDaoSqlMapImpl<NewsAttachment> implements NewsAttachmentDao {

}
