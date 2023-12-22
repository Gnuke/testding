package com.gorea.controller_contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gorea.dto_member.Gorea_JoinTO;
import com.gorea.service.UserService;

@Controller
public class Gorea_Header_Controller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@GetMapping("/korean/login.do")
	public String login() {
		return "korean/user/login";
	}
	@GetMapping("/korean/join.do")
	public String join() {
	    return "korean/user/join";
	}
	@PostMapping("/korean/joinOk.do")
	public String joinProc(Gorea_JoinTO gorea_JoinTO) {
		String encPwd = pwdEncoder.encode(gorea_JoinTO.getPassword());
		gorea_JoinTO.setPassword(encPwd);
		userService.join(gorea_JoinTO);
		return "korean/user/login";
	}
	
	// 어드민 페이지 이동
	@GetMapping("/admin/adminpage.do")
	public String admin() {
	    return "gorea_admingpage";
	}
	
	// 마이 페이지 이동
	@GetMapping("/user/korean/mypage.do")
	public String mypage() {
	    return "korean/user/myPage";
	}
	
	// 나중에 삭제할거
	@GetMapping("/korean/check1.do")
	public String session1() {
		return "korean/sessionCheck01";
	}
	@GetMapping("/korean/check2.do")
	public String session2() {
		return "korean/sessionCheck02";
	}
	
}
