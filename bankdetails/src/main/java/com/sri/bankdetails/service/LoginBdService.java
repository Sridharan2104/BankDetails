package com.sri.bankdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sri.bankdetails.model.LoginBdModel;
import com.sri.bankdetails.repository.LoginBdRepository;

@Service

public class LoginBdService {
		@Autowired
		LoginBdRepository lrep;
		
		public LoginBdModel saveUser(LoginBdModel l)
		{
			return lrep.save(l);
		}
		
		public String validateUser(String username,String password)
		{
			String result="";
			LoginBdModel l=lrep.findByUsername(username);
			if(l==null)
			{
				result="Invalid user";
			}
				else
				{
					if(l.getPassword().equals(password))
					{
						result="Login success";
					}
					else
					{
						result="Login failed";
					}
				}
			return result;
			}
}
