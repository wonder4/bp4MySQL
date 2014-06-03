package com.ebiz.bp_mysql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ebiz.bp_mysql.dao.UserInfoDao;
import com.ebiz.bp_mysql.domain.UserInfo;
import com.ebiz.bp_mysql.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;

	public Integer createUserInfo(UserInfo t) {
		return this.userInfoDao.insertEntity(t);
	}

	public UserInfo getUserInfo(UserInfo t) {
		return this.userInfoDao.selectEntity(t);
	}

	public Integer getUserInfoCount(UserInfo t) {
		return this.userInfoDao.selectEntityCount(t);
	}

	public List<UserInfo> getUserInfoList(UserInfo t) {
		return this.userInfoDao.selectEntityList(t);
	}

	public int modifyUserInfo(UserInfo t) {
		return this.userInfoDao.updateEntity(t);
	}

	public int removeUserInfo(UserInfo t) {
		return this.userInfoDao.deleteEntity(t);
	}

	public List<UserInfo> getUserInfoPaginatedList(UserInfo t) {
		return this.userInfoDao.selectEntityPaginatedList(t);
	}

}
