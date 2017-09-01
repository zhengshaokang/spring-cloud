package com.zsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zsk.ddo.User;
import com.zsk.service.jpa.UserService;
import com.zsk.service.redis.user.UserRedis;


@RestController
@RequestMapping(value = "user", method = RequestMethod.POST)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRedis userRedis;
	
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
	
	@RequestMapping("/getUserByRedis")
	public User getUserByRedis(String name){
		return userRedis.getUserByKey(name);
	}
	
	@RequestMapping("/addUserByRedis")
	public boolean addUserByRedis(User u){
		try {
			userRedis.addUser(u.getName(), u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
