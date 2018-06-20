package com.test.project.Service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.Mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper mapper;

	public int UserCnt() {
		return mapper.UserCnt();
	};

}
