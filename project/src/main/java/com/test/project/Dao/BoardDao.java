package com.test.project.Dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.BoardBean;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.UserBean;

@Mapper
public interface BoardDao {
  public int board_Insert(HashMap<String, Object> map);
  public int board_Cnt(String db);
  public ArrayList<BoardBean> board_list(HashMap<String, Object> map);
}
