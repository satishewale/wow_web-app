package com.wowwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wowwebapp.dao.UserDAO;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDao;

	@Override
	public ResponseEntity<?> doLogin(String username, String password) {
		
		boolean isAutherized = userDao.validate(username,password);
		
		if(isAutherized){
			return new ResponseEntity<String>(HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
	}

}
