package com.cts.dto;

public class UserService {

	User user;
	Service service ;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public UserService(User user, Service service) {
		super();
		this.user = user;
		this.service = service;
	}
	
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
}
