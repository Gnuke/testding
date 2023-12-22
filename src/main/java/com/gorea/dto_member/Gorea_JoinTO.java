package com.gorea.dto_member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Gorea_JoinTO {
	
	// go_user_seq
	private Long go_user_seq;
	// go_user_id
	private String username;
	// go_user_ps
	private String password;
	
	private String go_user_lastname;
	private String go_user_firstname;
	
	private String go_user_nickname;
	private int go_user_point;
	
	private String go_user_mail;
	
	private String go_user_nation;
	private String go_user_rating;

	// go_user_joindate / go_user_role 은 들어갈필요없음 

}
