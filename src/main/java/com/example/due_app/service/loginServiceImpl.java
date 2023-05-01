package com.example.due_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.due_app.model.logins;
import com.example.due_app.repository.loginRepository;

@Service
public class loginServiceImpl implements loginService{
	
	@Autowired
	private loginRepository LoginRepository;
	
	@Override
	public logins getLoginById(long id) {
		Optional<logins> optional = LoginRepository.findById(id);
		logins Login = null;
		if(optional.isPresent()) {
			Login = optional.get();
		} else {
			throw new RuntimeException("Bill not found for id :: " + id);
		}
		return Login;
	}

	@Override
	public logins getLoginByUsername(String username) {
		return LoginRepository.findByUsername(username);
	}
}