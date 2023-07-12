package com.greenstitch.seervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenstitch.entity.signup;
import com.greenstitch.repository.repository;



@Service
public class serviceimp implements services{
	
	@Autowired
	repository repo;
	
	@Override
	public String addUsers(signup user) {
		repo.save(user);
		return "Sudent added successfully!";
	}
	
	@Override
	public boolean id(int id) {
		return repo.existsById(id);
	}

	@Override
	public boolean checkEmail(String email) {
		return repo.existsByEmail(email);
	}

	@Override
	public boolean validate(String email, String password) {
		if(repo.existsByEmail(email)) {
			signup u=repo.getByEmail(email);
			String dbPassword=u.getPassword();
			if(password.equals(dbPassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false; 
		}
	}
}
