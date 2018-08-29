package com.test.project.Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.ArrayList;
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
  
  /**
   * @메소드명 : board_Insert
   * @작성일 : 2018. 8. 18. 오후 4:25:00
   * @작성자 : KHS
   * @설명 : 게시판 등록
   */
  public int board_Insert(HashMap<String, Object> map) {
    // TODO Auto-generated method stub
    return mapper.board_Insert(map);
    
  }
  /**
   * @메소드명 : board_Cnt
   * @작성일 : 2018. 8. 18. 오후 4:25:11
   * @작성자 : KHS
   * @설명 :게시판 총갯수
   */
  public int board_Cnt(String db) {
    return mapper.board_Cnt(db);
  }
  /**
   * @메소드명 : board_list
   * @작성일 : 2018. 8. 29. 오후 2:09:51
   * @작성자 : KHS
   * @설명 :게시판리스트
   */
  public ArrayList<BoardBean> board_list(HashMap<String, Object> map) {
    return mapper.board_list(map);
  }
}
