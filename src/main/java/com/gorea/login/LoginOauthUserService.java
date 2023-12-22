package com.gorea.login;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.gorea.dao.UserDAO;
import com.gorea.dto_member.Gorea_UserTO;
import com.gorea.dto_member.Gorea_JoinTO;
import com.gorea.mapper.UserMapper;

@Service
public class LoginOauthUserService extends DefaultOAuth2UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private @Lazy BCryptPasswordEncoder encodePwd;
	@Autowired
	private UserDAO userDAO;

	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oauth2user = super.loadUser(userRequest);
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		String username = provider + "_" + oauth2user.getAttribute("sub");
		
		Gorea_UserTO user = userMapper.login(username);
		
		if(user == null) {
			
			UUID uid = UUID.randomUUID();
			String password = encodePwd.encode(uid.toString());
			String Google_mail = oauth2user.getAttribute("email");
			
			Gorea_JoinTO join = new Gorea_JoinTO();
			join.setUsername(username);
			join.setPassword(password);
			join.setGo_user_mail(Google_mail);
			join.setGo_user_nickname(username);
			
			userDAO.join(join);
			
			user = userMapper.login(username);
		}
 		
		LoginService loginService = new LoginService();
		loginService.setGorea_UserTO(user);
		
		return loginService;
	}
}
