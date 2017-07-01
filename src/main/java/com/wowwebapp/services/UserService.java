package com.wowwebapp.services;

import org.springframework.http.ResponseEntity;

public interface UserService {
	
	ResponseEntity<?> doLogin(String username, String password);

}
