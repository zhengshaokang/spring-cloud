package com.zsk.dvo;

import java.io.Serializable;


public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Integer age;
	private String logName;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(Long id) {
		this.id = id;
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
		return "User [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	
}
