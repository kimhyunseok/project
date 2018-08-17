package com.test.project.Service;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.Dao.BoardDao;
import com.test.project.Dao.CircleDao;
import com.test.project.Dto.BoardBean;
import com.test.project.Dto.CircleBean;
import com.test.project.Dto.FileBean;

/**
 * @패키지 com.test.project.Service
 * @파일이름 FileService.java
 * @작성자 KHS
 * @작성날짜 2018. 8. 12. 오후 1:02:07
 * @설명:
 */
@Service
public class BoardService {
  
  private static Logger logger = LogManager.getLogger(BoardService.class);
  @Autowired
  private BoardDao mapper;
  
  public int board_Insert(HashMap<String, Object> map) {
    // TODO Auto-generated method stub
    return mapper.board_Insert(map);
  }
}
