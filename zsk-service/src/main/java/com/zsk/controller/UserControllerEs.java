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
import com.zsk.eo.User;
import com.zsk.service.es.UserServiceEs;

/**
 * 
 * @author connor-zheng
 * 
 */
@RestController
@RequestMapping(value = "user", method = RequestMethod.POST)
public class UserControllerEs {
	
	@Autowired
	private UserServiceEs userServiceEs;
	
	
	@RequestMapping("/queryUserByIdEs")
	public User queryUserByIdEs(Long id){
		
		User u = userServiceEs.findById(id);
		return u;
	}
	
	@RequestMapping("/listes")
	public List<User> listes(){
		List<User> u = userServiceEs.findAll();
		return u;
	}
	
	@RequestMapping("/findLikeNameEs")
	public List<User> findLikeNameEs(String name){
		return userServiceEs.findLikeName(name);
	}
	
	@RequestMapping("/addUesrEs")
	public boolean addUesrEs(User u){
		try {
			userServiceEs.addUser(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping("/pageUserEs")
	public PageResult<User> pageUserEs(PageParam<User> pageParam){
		
		PageResult<User> pagedata = new PageResult<User>();
		try {
			
			Direction d = Direction.DESC;
			if(pageParam.getDirection() == 1) {
				d = Direction.ASC;
			}
			Sort s = new Sort(d,pageParam.getSort());
			PageRequest pageRequest = new PageRequest(pageParam.getPageNo()-1,pageParam.getPageSize(),s);
			Page<User> page = userServiceEs.findAll(pageParam.getP(), pageRequest);
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
}
