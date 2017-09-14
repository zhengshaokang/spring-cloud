package com.zsk.app.hystrix.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsk.app.hystrix.UserHystrix;
import com.zsk.commons.utils.PageResult;
import com.zsk.dvo.User;

/**
 *熔断器
 * @author connor_zheng
 */
@Component
public class UserHystrixImpl implements UserHystrix {

	@Override
	public User queryUserById(@RequestParam(value = "id") Long id) {
		System.out.println("query user error by "+ id);
		return null;
	}

	@Override
	public List<User> queryUsers() {
		System.out.println("query user list error");
		return null;
	}

	@Override
	public User getUserByRedis(String name) {
		System.out.println("get user by redis error name="+name);
		return null;
	}

	@Override
	public Boolean addUserByRedis(Map<String,Object> param) {
		System.out.println("add user by redis error user="+param.toString());
		return false;
	}

	@Override
	public User queryUserByIdEs(Long id) {
		System.out.println("queryUserByIdEs error="+id.toString());
		return null;
	}

	@Override
	public List<User> queryUsersEs() {
		System.out.println("queryUsersEsAll error");
		return null;
	}

	@Override
	public List<User> findLikeNameEs(String name) {
		System.out.println("findLikeNameEs error ="+name.toString());
		return null;
	}

	@Override
	public Boolean addUesrEs(Map<String, Object> param) {
		System.out.println("addUesrEs error ="+param.toString());
		return null;
	}

	@Override
	public PageResult<User> pageUserEs(Map<String, Object> param) {
		System.out.println("pageUserEs error="+param.toString());
		return null;
	}

}
