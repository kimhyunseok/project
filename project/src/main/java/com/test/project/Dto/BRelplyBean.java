package com.test.project.Dto;

import lombok.Data;
import lombok.ToString;

/**
 * @패키지 com.test.project.Dto
 * @파일이름 BRelplyBean.java
 * @작성자 김현석
 * @작성날짜 2019. 3. 10. 오후 9:40:38
 * @설명:
 */
@Data
@ToString
public class BRelplyBean {
  private String reply_id;
  private int board_no;
  private int reply_no;
  private int reply_level;
  private String reply_content;
  private String reply_in_date;
  private String reply_del_date;
  private String reply_upt_date;
  
}
