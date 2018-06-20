package com.test.project.Dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	public int UserCnt();
}
