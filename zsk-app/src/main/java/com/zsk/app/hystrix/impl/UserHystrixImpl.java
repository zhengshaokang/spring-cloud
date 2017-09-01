package com.zsk.app.hystrix.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsk.app.hystrix.UserHystrix;
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

}
