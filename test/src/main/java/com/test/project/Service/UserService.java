package com.test.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.Dao.UserDao;
import com.test.project.Dto.UserBean;

@Service
public class UserService {
  @Autowired
  UserDao mapper;
  
  public int UserCnt(String user_id) {
    return mapper.UserCnt(user_id);
  }
  
  public int LoginChk(UserBean user) {
    return mapper.LoginChk(user);
  }
  
  public int UserJoin(UserBean user) {
    return mapper.UserJoin(user);
  }

  public UserBean SelectUserInfo(String user_id) {
    return mapper.SelectUserInfo(user_id);
  }
  public int UserUpdate(UserBean user) {
    return mapper.UserUpdate(user);
  }
}
