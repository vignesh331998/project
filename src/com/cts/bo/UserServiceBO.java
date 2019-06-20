package com.cts.bo;

import java.sql.SQLException;
import java.util.List;

import com.cts.dao.UserServiceDAO;
import com.cts.dto.UserService;


public class UserServiceBO {
	public boolean update(UserService userService) throws ClassNotFoundException, SQLException {
		UserServiceDAO userservicedao = new UserServiceDAO();
		return userservicedao.update(userService);
		
	}
	
	public boolean delete(int id) throws ClassNotFoundException, SQLException {
		UserServiceDAO userservicedao = new UserServiceDAO();
		return userservicedao.delete(id);
	}
	
	public UserService getUserService(UserService userService) throws ClassNotFoundException, SQLException {
		UserServiceDAO userservicedao = new UserServiceDAO();
		return userservicedao.getUserService(userService);
		
	}
	
	public List<UserService> getUserServices() throws ClassNotFoundException, SQLException {
		UserServiceDAO userservicedao = new UserServiceDAO();
		return userservicedao.getUserServices();		
	}
	
	public boolean add(UserService userService) throws ClassNotFoundException, SQLException {
		UserServiceDAO userservicedao = new UserServiceDAO();
		return userservicedao.add(userService);
		
	}
	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		UserServiceDAO userservicedao = new UserServiceDAO();
		return userservicedao.deleteAll();
		
	}
}
