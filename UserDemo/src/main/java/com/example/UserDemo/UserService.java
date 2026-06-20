package com.example.UserDemo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	public void save(User u) {
		repo.save(u);
	}
	
	public Optional<User> find(int id) {
		return repo.findById(id);
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
