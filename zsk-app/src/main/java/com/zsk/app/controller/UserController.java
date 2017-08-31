package com.zsk.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zsk.app.hystrix.TimeConsumer;
import com.zsk.dvo.User;


@RestController
@RequestMapping(value = "user", method = RequestMethod.POST)
public class UserController {
	
	@Autowired
    private TimeConsumer timeConsumer;
	
	@RequestMapping("/query/{id}")
	public User findById(@PathVariable("id") Long id){
		
		User u = timeConsumer.queryUserById(id);
		return u;
	}
	
	@RequestMapping("/list")
	public List<User> list(){
		List<User> u = timeConsumer.queryUsers();
		return u;
	}
}
