package com.zsk.app.hystrix;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsk.app.hystrix.impl.TomtopConsumerHystrix;
import com.zsk.dvo.User;

/**
 *
 * @author Lion Weng
 */
@FeignClient(name = "zsk-service", fallback = TomtopConsumerHystrix.class)
public interface TimeConsumer {
    
    @RequestMapping(value = "/user/queryUserById", method = RequestMethod.POST)
    User queryUserById(@RequestParam(value = "id") Long id);
    
    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    List<User> queryUsers();
    
}

