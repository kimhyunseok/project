package com.test.project.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.User;

@Mapper
public interface UserDao {
	public int UserCnt(String user_id);
	public int LoginChk(User user);
	public int UserJoin(User user);
	public int UserUpdate(User user);
  public User SelectUserInfo(String user_id);
}
