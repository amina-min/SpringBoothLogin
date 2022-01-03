

package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.UserLogin;
import com.example.repository.LoginRepo;

@Controller
public class LoginController {
	
	@Autowired
	private LoginRepo repo;

	@GetMapping("/")
	private ModelAndView loginPage() {		
		Map<String , Object> map = new HashMap<String, Object>();
		return new ModelAndView("index" ,"data",map);

	}
	
	@PostMapping("/login")
	private ModelAndView login(@ModelAttribute UserLogin u) {
		Map<String , Object> map = new HashMap<String, Object>();
		 List<UserLogin> user= repo.findByEmail(u.getEmail());
		 
		 if (user.isEmpty()) {
			 return new ModelAndView("error");
			
		}else {
			if (user.get(0).getPassword().equals(u.getPassword())) {
				 return new ModelAndView("success");
			}
			return new ModelAndView("error");
		}
		
		

	}
}
