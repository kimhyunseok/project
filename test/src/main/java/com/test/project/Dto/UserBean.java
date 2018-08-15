package com.test.project.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBean {
	private String user_id;
	private String user_pw;
	private String user_email_2;
	private String user_email_1;
	private int seq;

	@Override
  public String toString() {
    return "User [user_id=" + user_id + ", user_pw=" + user_pw + ", user_email_2=" + user_email_2 + ", user_email_1=" + user_email_1 + ", seq=" + seq + "]";
  }

}
