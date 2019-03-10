package com.test.project.Dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.BRelplyBean;

@Mapper
public interface BReplyDao {
  public void reply_Insert(HashMap<String, Object> map);
  
  public int reply_Cnt(String db);
  
  public ArrayList<BRelplyBean> reply_List(String pageNum);
  
  public void reply_del();
  
  public void reply_upt();
  
}
