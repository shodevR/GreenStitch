package com.greenstitch.seervices;


import com.greenstitch.entity.signup;

public interface services {
	
		String addUsers(signup user);
		
		boolean id(int id);
		
		boolean checkEmail(String email);
		
		boolean validate(String email, String password);

		
}
