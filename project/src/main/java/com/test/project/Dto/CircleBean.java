package com.test.project.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @패키지   com.test.project.Dto
 * @파일이름  CircleBean.java
 * @작성자   김현석
 * @작성날짜  2019. 2. 5. 오전 3:17:25
 * @설명:
 */
@Data
public class CircleBean {
  private int    circle_No;
  private String circle_Nm;
  private String circle_Kind;
  private String circle_PNum;
  private int    circle_Cnt;
  private String circle_Content;
  private String circle_Date;
  private String circle_Time;
  private String circle_PostNum;
  private String circle_Addr1;
  private String circle_Addr2;
  private String circle_Point;
  private String circle_in_date;
  private int    circle_Logo_Fileno;
  @Override
  public String toString() {
    return "CircleBean [circle_No=" + circle_No + ", circle_Nm=" + circle_Nm + ", circle_Kind=" + circle_Kind + ", circle_PNum=" + circle_PNum + ", circle_Cnt=" + circle_Cnt + ", circle_Content=" + circle_Content + ", circle_Date=" + circle_Date + ", circle_Time=" + circle_Time + ", circle_PostNum=" + circle_PostNum + ", circle_Addr1=" + circle_Addr1 + ", circle_Addr2=" + circle_Addr2 + ", circle_Point=" + circle_Point + ", circle_in_date=" + circle_in_date + "]";
  }
  
}


