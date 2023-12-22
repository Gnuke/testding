package com.gorea.controller_contents;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Gorea_Main_Controller {
	
	// 인트로 페이지 이동
	@GetMapping("intro.do")
	public String intro(HttpServletRequest request, Model model) {
		return "gorea_intro";
	}
	
	// 각나라 언어 페이지로 이동
	@GetMapping("/korean/main.do")
	public String korean_main(HttpServletRequest request, Model model) {
		return "korean/gorea_main";
	}
	@GetMapping("/english/main.do")
	public String english_main(HttpServletRequest request, Model model) {
		return "english/gorea_main";
	}
	@GetMapping("/japanese/main.do")
	public String japanese_main(HttpServletRequest request, Model model) {
		return "japanese/gorea_main";
	}
	@GetMapping("/chinese/main.do")
	public String chinese_main(HttpServletRequest request, Model model) {
		return "chinese/gorea_main";
	}
	
	@GetMapping("/errorPage.do")
	public String errorPage(HttpServletRequest request, Model model) {
		return "gorea_accessdenied_page";
	}

}
