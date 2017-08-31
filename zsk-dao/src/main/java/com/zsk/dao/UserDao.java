package com.zsk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zsk.ddo.User;

public interface UserDao extends JpaRepository<User, Long>{
	public List<User> findByNameLike(String name);
	public User findById(Long id);
}
