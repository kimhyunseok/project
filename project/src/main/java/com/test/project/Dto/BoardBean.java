package com.test.project.Dto;

import lombok.Data;

/**
 * @패키지 com.test.project.Dto
 * @파일이름 BoardBean.java
 * @작성자 김현석
 * @작성날짜 2019. 2. 5. 오전 3:17:31
 * @설명:
 */
@Data
public class BoardBean {
  private int board_no;
  private String board_nm;
  private String board_title;
  private String board_content;
  private String board_in_date;
  private int board_view_cnt;
  private int board_fileNo;
  private String next_no;
  private String pre_no;
  private String next_nm;
  private String pre_nm;
  private String next_date;
  private String pre_date;
  private String board_del_chk;
  
  @Override
  public String toString() {
    return "BoardBean [board_no=" + board_no + ", board_nm=" + board_nm + ", board_content=" + board_content + ", board_in_date=" + board_in_date + ", board_view_cnt=" + board_view_cnt + ", board_fileNo=" + board_fileNo + "]";
  }
  
}
