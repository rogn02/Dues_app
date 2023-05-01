package com.example.due_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.due_app.model.logins;
import com.example.due_app.service.loginService;

@Controller
public class loginController {
	
	@Autowired
	private loginService LoginService;
	
	@GetMapping("/")
	public String showLoginForm(Model model) {
		logins Login = new logins();
		model.addAttribute("logins", Login);
		return "index";
	}
	
	@GetMapping("/authLogin")
	public String authLogin(@ModelAttribute("logins") logins Login) {
		logins user = LoginService.getLoginByUsername(Login.getUsername());
		if(Login.getPassword().equals(user.getPassword())) {
			
			if(user.getRole().equals("student")) {
				return "redirect:/UserData/" + user.getUsername();
			} else if (user.getRole().equals("librarian")) {
				return "redirect:/LibraryVerification";
			} else {
				return "redirect:/AccountsVerification";
			}
		} else {
			// Send back to login page
			return "redirect:/";
		}
	}
}