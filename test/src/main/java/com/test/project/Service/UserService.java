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
  
  public int UserJoin(User user) {
    return mapper.UserJoin(user);
  }

  public User SelectUserInfo(String user_id) {
    return mapper.SelectUserInfo(user_id);
  }
  public int UserUpdate(User user) {
    return mapper.UserUpdate(user);
  }
}
