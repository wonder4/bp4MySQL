package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.UserInfo;

public interface UserInfoService {

	Integer createUserInfo(UserInfo t);

	int modifyUserInfo(UserInfo t);

	int removeUserInfo(UserInfo t);

	UserInfo getUserInfo(UserInfo t);

	List<UserInfo> getUserInfoList(UserInfo t);

	Integer getUserInfoCount(UserInfo t);

	List<UserInfo> getUserInfoPaginatedList(UserInfo t);

}