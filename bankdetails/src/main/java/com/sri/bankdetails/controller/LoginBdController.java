package com.sri.bankdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sri.bankdetails.model.LoginBdModel;
import com.sri.bankdetails.service.LoginBdService;

@RestController

public class LoginBdController {
		@Autowired
		LoginBdService lser;
		
		@PostMapping("/checkLogin")
		public String validateUser(@RequestBody LoginBdModel l)
		{
			System.out.println(l.getUsername());
			return lser.validateUser(l.getUsername(), l.getPassword());
		}
		
		@PostMapping("/addUser")
		public LoginBdModel addDetails(@RequestBody LoginBdModel l)
		{
			return lser.saveUser(l);
		}
}
