package com.test.project.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @패키지   com.test.project.Dto
 * @파일이름  UserBean.java
 * @작성자   김현석
 * @작성날짜  2019. 2. 5. 오전 3:16:59
 * @설명:
 */
@Data
public class UserBean {
  private int seq;
	private String user_id;
	private String user_nm;
	private String user_pw;
	private String user_email_1;
	private String user_email_2;
	private String user_in_date;
	private String user_mod_date;
	private String user_del_date;
	
	@Override
  public String toString() {
    return "User [user_id=" + user_id + ", user_pw=" + user_pw + ", user_email_2=" + user_email_2 + ", user_email_1=" + user_email_1 + ", seq=" + seq + "]";
  }

}
