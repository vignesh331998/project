package com.cts.bo;

import java.sql.SQLException;
import java.util.List;

import com.cts.dao.UserDAO;
import com.cts.dto.Address;
import com.cts.dto.Role;
import com.cts.dto.User;



public class UserBO {

	public boolean update(User user) throws ClassNotFoundException, SQLException {
		UserDAO userdao = new UserDAO();
		System.out.println(user.getName());
		return userdao.update(user);
		
	}
	public User validateUser(String uname,String upwd) throws ClassNotFoundException, SQLException
	{
	       UserDAO userdao=new UserDAO();
	       User user=userdao.validateUser(uname, upwd);
	       return user;
	}

	
	public boolean delete(String uname,String upwd) throws ClassNotFoundException, SQLException {
		UserDAO userdao = new UserDAO();
		return userdao.delete(uname, upwd);
	}
	
	public User get(int id) throws ClassNotFoundException, SQLException {
		UserDAO userdao = new UserDAO();
		return userdao.getUser(id);
		
	}
	
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		UserDAO userdao = new UserDAO();
		return userdao.getAllUsers();		
	}
	
	public boolean add(User user,Address address) throws ClassNotFoundException, SQLException {
		//System.out.println(user.getName()+" "+user.getAge()+" "+user.getGender());
		UserDAO userdao = new UserDAO();
		return userdao.add(user,address);
		
	}
	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		UserDAO userdao = new UserDAO();
		return userdao.deleteAll();
		
}
	public boolean addAvailCourse(String[] courseid,int uid) {
		// TODO Auto-generated method stub
		UserDAO userdao=new UserDAO();
		boolean status=userdao.addAvailCourse(courseid,uid);
		return status;
	}
}
