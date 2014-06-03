package com.ebiz.bp_mysql.dao.ibatis;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.PdImgsDao;
import com.ebiz.bp_mysql.domain.PdImgs;
import com.ebiz.ssi.dao.ibatis.EntityDaoSqlMapImpl;

@Service
public class PdImgsDaoSqlMapImpl extends EntityDaoSqlMapImpl<PdImgs> implements PdImgsDao {

}
