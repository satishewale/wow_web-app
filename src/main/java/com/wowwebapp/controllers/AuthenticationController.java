package com.wowwebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wowwebapp.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("wowwebapp/user/")
public class AuthenticationController {
	
	 public final static Logger Logger = LoggerFactory.getLogger(AuthenticationController.class);
	 
	 @Autowired
	 UserService userservice;
	 
	 @RequestMapping(value = "login", method = RequestMethod.POST)
		public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password){
		Logger.info("UserInfo : " + username);
		Logger.info("UserInfo : " + password);
		
		return userservice.doLogin(username, password);
	}

}
