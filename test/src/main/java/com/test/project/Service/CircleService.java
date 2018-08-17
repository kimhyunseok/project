package com.test.project.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.Dao.CircleDao;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.FileBean;
/**
 * @패키지   com.test.project.Service
 * @파일이름  FileService.java
 * @작성자   KHS
 * @작성날짜  2018. 8. 12. 오후 1:02:07
 * @설명:
 */
@Service
public class CircleService {
  
  private static Logger logger = LogManager.getLogger(CircleService.class);
  @Autowired
  CircleDao mapper;
  
  public int Circle_insert(CircleBean bean ) {
    // TODO Auto-generated method stub
   return mapper.Circle_insert(bean);
  }
}
