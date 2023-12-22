package com.gorea.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gorea.dto_member.Gorea_JoinTO;
import com.gorea.mapper.UserMapper;

@Repository
public class UserDAOImp implements UserDAO {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void join(Gorea_JoinTO gorea_JoinTO) {
		
		int result = userMapper.join(gorea_JoinTO);
		
		if(result == 1) {
			System.out.println("회원가입 성공");
			
		}
	}
}
