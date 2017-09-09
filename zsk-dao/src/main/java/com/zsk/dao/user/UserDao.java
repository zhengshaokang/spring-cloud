package com.zsk.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zsk.ddo.User;
/**
 * 
 * @author connor-zheng
 * 
 */
public interface UserDao extends JpaRepository<User, Long>{
	public List<User> findByNameLike(String name);
	public User findById(Long id);
}
