package com.zsk.service.es;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.zsk.eo.User;

/**
 * 
 * @author connor-zheng
 * 
 */
public interface UserServiceEs {
	public User addUser(User user);
	public User findById(Long id);
	public List<User> findLikeName(String name);
	public Page<User> findAll(User user, PageRequest pageRequest);
	public List<User> findAll();
}
