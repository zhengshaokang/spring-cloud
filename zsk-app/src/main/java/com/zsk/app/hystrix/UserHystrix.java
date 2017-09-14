package com.zsk.app.hystrix;


import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsk.app.hystrix.impl.UserHystrixImpl;
import com.zsk.commons.utils.PageResult;
import com.zsk.dvo.User;

/**
 *
 * @author connor-zheng
 */
@FeignClient(name = "zsk-service", fallback = UserHystrixImpl.class)
public interface UserHystrix {
    
    @RequestMapping(value = "/user/queryUserById", method = RequestMethod.POST)
    User queryUserById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    List<User> queryUsers();
    
    @RequestMapping(value = "/user/getUserByRedis", method = RequestMethod.POST)
    User getUserByRedis(@RequestParam(value = "name") String name);
    
    @RequestMapping(value = "/user/addUserByRedis", method = RequestMethod.POST)
    Boolean addUserByRedis(@RequestParam Map<String,Object> param);
    
    
    @RequestMapping(value = "/user/queryUserByIdEs", method = RequestMethod.POST)
    User queryUserByIdEs(@RequestParam(value = "id") Long id);
    @RequestMapping(value = "/user/listes", method = RequestMethod.POST)
    List<User> queryUsersEs();
    @RequestMapping(value = "/user/findLikeNameEs", method = RequestMethod.POST)
    List<User> findLikeNameEs(@RequestParam(value = "name") String name);
    @RequestMapping(value = "/user/addUesrEs", method = RequestMethod.POST)
    Boolean addUesrEs(@RequestParam Map<String,Object> param);
    
    @RequestMapping(value = "/user/pageUserEs", method = RequestMethod.POST)
    PageResult<User> pageUserEs(@RequestParam Map<String,Object> param);
    
}

