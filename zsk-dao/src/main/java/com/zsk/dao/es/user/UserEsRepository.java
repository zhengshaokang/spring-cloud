package com.zsk.dao.es.user;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zsk.eo.User;

/**
 * 
 * @author connor-zheng
 * 
 */
public interface UserEsRepository extends ElasticsearchRepository<User, Long>{
}
