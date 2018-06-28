package com.test.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.Dao.UserDao;
import com.test.project.Dto.User;

@Service
public class UserService {
	@Autowired
	UserDao mapper;

	public int UserCnt(String user_id) {
		return mapper.UserCnt(user_id);
	}
	public int LoginChk(User user) {
		return mapper.LoginChk(user);
	}
	
}
