package com.test.project.Dto;

import lombok.Data;

/**
 * @패키지 com.test.project.Dto
 * @파일이름 BRelplyBean.java
 * @작성자 김현석
 * @작성날짜 2019. 3. 10. 오후 9:40:38
 * @설명:
 */
@Data
public class BRelplyBean {
  private String reply_id;
  private int board_no;
  private int reply_no;
  private int reply_level;
  private String reply_content;
  private String reply_in_date;
  private String reply_del_date;
  private String reply_upt_date;
  
  @Override
  public String toString() {
    return "BRelplyBean [board_no=" + board_no + ", reply_no=" + reply_no + ", reply_content=" + reply_content + ", reply_in_date=" + reply_in_date + ", reply_del_date=" + reply_del_date + ", reply_upt_date=" + reply_upt_date + "]";
  }
  
}
