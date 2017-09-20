package com.zsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zsk.commons.utils.PageParam;
import com.zsk.commons.utils.PageResult;
import com.zsk.ddo.User;
import com.zsk.service.jpa.UserService;
import com.zsk.service.redis.user.UserRedis;

/**
 * 
 * @author connor-zheng
 * 
 */
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
	
	@RequestMapping("/pageUserJpa")
	public PageResult<User> pageUserJpa(PageParam<User> pageParam){
		
		PageResult<User> pagedata = new PageResult<User>();
		try {
			
			Direction d = Direction.DESC;
			if(pageParam.getDirection() == 1) {
				d = Direction.ASC;
			}
			Sort s = new Sort(d,pageParam.getSort());
			PageRequest pageRequest = new PageRequest(pageParam.getPageNo()-1,pageParam.getPageSize(),s);
			Page<User> page = userService.findAll(pageParam.getP(), pageRequest);
			pagedata.setDataTotal((int)page.getTotalElements());
			pagedata.setPageData(page.getContent());
			pagedata.setPageNumber(page.getNumber()+1);
			pagedata.setPageSize(page.getSize());
			pagedata.setPageTotal(page.getTotalPages());
			return pagedata;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
