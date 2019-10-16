package com.javaTechie.springCassandra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaTechie.springCassandra.model.User;
import com.javaTechie.springCassandra.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(6437,"rohit","bangalore",25));
		users.add(new User(5437,"umesh","bangalore",29));
		users.add(new User(4437,"abhi","palampur",32));
		users.add(new User(3437,"sachin","gurgaon",26));
		userRepo.saveAll(users);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getUserByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age){
		return userRepo.findByAgeGreaterThan(age);
	}
}
