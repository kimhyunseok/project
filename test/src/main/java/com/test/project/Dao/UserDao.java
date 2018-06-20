package com.test.project.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.User;

@Mapper
public interface UserDao {
	public int UserCnt();
	public int LoginChk(String id, String pw);
}
