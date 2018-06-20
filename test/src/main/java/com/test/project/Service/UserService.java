package com.test.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.Dao.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao mapper;

	public int UserCnt() {
		return mapper.UserCnt();
	};

}
