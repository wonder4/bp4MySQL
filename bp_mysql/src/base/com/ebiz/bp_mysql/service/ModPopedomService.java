package com.ebiz.bp_mysql.service;

import java.util.List;

import com.ebiz.bp_mysql.domain.ModPopedom;

public interface ModPopedomService {

	Integer createModPopedom(ModPopedom t);

	int modifyModPopedom(ModPopedom t);

	int removeModPopedom(ModPopedom t);

	ModPopedom getModPopedom(ModPopedom t);

	List<ModPopedom> getModPopedomList(ModPopedom t);

	Integer getModPopedomCount(ModPopedom t);

	List<ModPopedom> getModPopedomPaginatedList(ModPopedom t);

}