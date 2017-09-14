package com.zsk.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zsk.app.hystrix.UserHystrix;
import com.zsk.commons.utils.ConvertObjectMap;
import com.zsk.commons.utils.PageParam;
import com.zsk.commons.utils.PageResult;
import com.zsk.dvo.User;
/**
 * 
 * @author connor-zheng
 * 
 */
@RestController
@RequestMapping(value = "user", method = RequestMethod.POST)
public class UserController {
	
	@Autowired
    private UserHystrix userHystrix;
	
	@RequestMapping("/query/{id}")
	public User findById(@PathVariable("id") Long id){
		
		User u = userHystrix.queryUserById(id);
		return u;
	}
	
	@RequestMapping("/list")
	public List<User> list(){
		List<User> u = userHystrix.queryUsers();
		return u;
	}
	
	
	@RequestMapping(value="/add",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String add(User user){
		try {
			Map<String, Object> map = ConvertObjectMap.objectToMap(user);
			Boolean u = userHystrix.addUserByRedis(map);
			if(u){
				return "成功";
			} else {
				return "失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}
	
	@RequestMapping("/getUserByRedis")
	public User getUserByRedis(String name){
		User u = userHystrix.getUserByRedis(name);
		return u;
	}
	
	
	@RequestMapping("/queryes/{id}")
	public User queryUserByIdEs(@PathVariable("id") Long id){
		
		User u = userHystrix.queryUserByIdEs(id);
		return u;
	}
	
	@RequestMapping("/listes")
	public List<User> queryUsersEs(){
		List<User> u = userHystrix.queryUsersEs();
		return u;
	}
	
	
	@RequestMapping(value="/addUesrEs",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addUesrEs(User user){
		try {
			Map<String, Object> param = ConvertObjectMap.objectToMap(user);
			Boolean u = userHystrix.addUesrEs(param);
			if(u){
				return "成功";
			} else {
				return "失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}
	
	@RequestMapping(value="/pageUserEs",produces = "application/json; charset=utf-8")
	public PageResult<User> pageUserEs(PageParam<User> pageParam){
		try {
			Map<String, Object> param = ConvertObjectMap.objectToMap(pageParam);
			PageResult<User> u = userHystrix.pageUserEs(param);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
