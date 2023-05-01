package com.example.due_app.service;

import com.example.due_app.model.logins;

public interface loginService {
	logins getLoginById(long id);
	logins getLoginByUsername(String username);
}
