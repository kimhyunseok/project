package com.test.project.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.project.Dto.CircleBean;
import com.test.project.Dto.UserBean;

@Mapper
public interface CircleDao {
	public int Circle_insert(CircleBean bean);

}
