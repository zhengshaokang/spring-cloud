package com.zsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zsk.ddo.User;
import com.zsk.service.UserService;


@RestController
@RequestMapping(value = "user", method = RequestMethod.POST)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryUserById")
	public User queryUserById(Long id){
		
		User u = userService.findById(id);
		return u;
	}
	
	@RequestMapping("/list")
	public List<User> list(){
		List<User> u = userService.findAll();
		return u;
	}
}
