package com.test.project.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.User;

@Mapper
public interface UserDao {
	public int UserCnt(String user_id);
	public int LoginChk(User user);
}
