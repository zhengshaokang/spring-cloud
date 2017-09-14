package com.zsk.service.es.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zsk.dao.es.user.UserEsRepository;
import com.zsk.eo.User;
import com.zsk.service.es.UserServiceEs;

/**
 * 
 * @author connor-zheng
 * 
 */
@Service
public class UserServiceEsImpl implements UserServiceEs{

	@Autowired
	private UserEsRepository userEsRepository;
	
	@Override
	public Page<User> findAll(User user, PageRequest pageRequest) {
//		if(pageRequest.getSort() == null ) {
//			pageRequest = new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),new Sort(Direction.DESC,"id"));
//		}
		if(user == null){
			//全文匹配
			//QueryBuilder qb = QueryBuilders.matchAllQuery();
			return userEsRepository.findAll(pageRequest);
		}
		//创建匹配器，即如何使用查询条件
    	QueryBuilder qb = QueryBuilders.matchPhrasePrefixQuery("name", user.getName());
		return  userEsRepository.search(qb, pageRequest);
	}

	@Override
	public User addUser(User user) {
		User u = userEsRepository.save(user);
		return u;
	}

	@Override
	public List<User> findAll() {
		Iterable<User> us =  userEsRepository.findAll();
		
		List<User> list = new ArrayList<User>();  
		us.forEach(single ->{list.add(single);});
		
		return list;
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userEsRepository.findOne(id);
	}

	@Override
	public List<User> findLikeName(String name) {
		QueryBuilder qb = QueryBuilders.matchPhrasePrefixQuery("name", name);
		Iterable<User> us =  userEsRepository.search(qb);
		List<User> list = new ArrayList<User>();  
		us.forEach(single ->{list.add(single);});
		return list;
	}

}
