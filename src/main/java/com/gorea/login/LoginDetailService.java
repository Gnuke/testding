package com.gorea.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gorea.dto_member.Gorea_UserTO;
import com.gorea.mapper.UserMapper;


@Service
public class LoginDetailService implements UserDetailsService {
 
	@Autowired
	private UserMapper userMapper;
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Gorea_UserTO user = userMapper.login(username);
		System.out.println("user 네임 확인 : " + user ) ;
		
		if (user != null) {
			LoginService loginDetail = new LoginService();
 
			loginDetail.setGorea_UserTO(user);
			System.out.println("loginDetail : " + loginDetail);
			return loginDetail;
			
		} else {
			
			throw new UsernameNotFoundException("유저없음");
			
		}
	}
 
}
