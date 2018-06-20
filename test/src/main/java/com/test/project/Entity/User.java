package com.test.project.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String user_id;
	private String user_pw;
	private int seq;

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_pw=" + user_pw + ", seq=" + seq + "]";
	}

}
