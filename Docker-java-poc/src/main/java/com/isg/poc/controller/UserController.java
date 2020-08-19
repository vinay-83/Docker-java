package com.isg.poc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/getAll")
	public List<UserModel> getAll() {
		return userRepo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<UserModel> findById(@PathVariable Integer id) {
		return userRepo.findById(id);
	}
	
	@GetMapping("/addUser/{id}/{name}")
	public UserModel addUser(@PathVariable Integer id, @PathVariable String name) {
		UserModel user = new UserModel();
		user.setId(id);
		user.setName(name);
		return userRepo.save(user);
	}
}
