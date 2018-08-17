package com.test.project.Dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.BoardBean;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.UserBean;

@Mapper
public interface BoardDao {
  
  public int board_Insert(HashMap<String, Object> map);
  
}
