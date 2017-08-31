package com.zsk.app.hystrix.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsk.app.hystrix.TimeConsumer;
import com.zsk.dvo.User;

/**
 *
 * @author Lion Weng
 */
@Component
public class TomtopConsumerHystrix implements TimeConsumer {

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

}
