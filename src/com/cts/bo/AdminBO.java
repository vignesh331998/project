package com.cts.bo;

import java.sql.SQLException;
import java.util.List;

import com.cts.dao.AdminDAO;
import com.cts.dao.UserDAO;
import com.cts.dto.User;

public class AdminBO {
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		AdminDAO admindao = new AdminDAO();
		return admindao.getAllUsers();		
	}
	public List<User> getAllVendors() throws ClassNotFoundException, SQLException {
		AdminDAO admindao = new AdminDAO();
		return admindao.getAllVendors();		
	}
}
