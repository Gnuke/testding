package com.gorea.dto_member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Gorea_UserTO {
	private Long go_user_seq;
	// go_user_id
	private String username;
	// go_user_ps
	private String password;
	
	private String go_user_lastname;
	private String go_user_firstname;
	
	private String go_user_nickname;
	
	private String go_user_mail;
	private String go_user_joindate;
	private int go_user_point;
	private String go_user_nation;
	private String go_user_rating;
	private String go_user_role;
	
	public Gorea_UserTO(String username, String password, String go_user_nickname, String go_user_mail) {
		this.username = username;
		this.password = password;
		this.go_user_nickname = go_user_nickname;
		this.go_user_mail = go_user_mail;
	}
}
