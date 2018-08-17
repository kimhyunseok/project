package com.test.project.Dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BoardBean {
  private int    board_no;
  private String board_nm;
  private String board_content;
  private String board_in_date;
  private int board_view_cnt;
  private int board_fileNo;
  
  @Override
  public String toString() {
    return "BoardBean [board_no=" + board_no + ", board_nm=" + board_nm + ", board_content=" + board_content + ", board_in_date=" + board_in_date + ", board_view_cnt=" + board_view_cnt + ", board_fileNo=" + board_fileNo + "]";
  }
  
}


