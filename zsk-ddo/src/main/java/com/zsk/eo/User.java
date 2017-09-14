package com.zsk.eo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "zsk", type = "user",shards = 1, replicas = 0, refreshInterval = "-1")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String name;
	private Integer age;
	private String logName;
	
	public User() {
		super();
	}
	
	
	public User(Long id, String name, Integer age, String logName) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.logName = logName;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", logName=" + logName + "]";
	}
	
}
