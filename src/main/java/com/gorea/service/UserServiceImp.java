package com.gorea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorea.dao.UserDAO;
import com.gorea.dto_member.Gorea_JoinTO;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void join(Gorea_JoinTO gorea_JoinTO) {
		userDAO.join(gorea_JoinTO);

	}

}
