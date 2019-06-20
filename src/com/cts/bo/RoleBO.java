package com.cts.bo;

import java.sql.SQLException;
import java.util.List;

import com.cts.dao.CourseDAO;
import com.cts.dao.RoleDAO;
import com.cts.dto.Course;
import com.cts.dto.Role;

public class RoleBO {
	public boolean update(Role role) throws ClassNotFoundException, SQLException {
		RoleDAO roledao = new RoleDAO();
		return roledao.update(role);
		
	}
	
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		RoleDAO roledao = new RoleDAO();
		return roledao.delete(id);
	}
	
	public Role get(String id) throws ClassNotFoundException, SQLException {
		RoleDAO roledao = new RoleDAO();
		return roledao.getRole(id);
		
	}
	
	public List<Role> getRoles() throws ClassNotFoundException, SQLException {
		RoleDAO roledao = new RoleDAO();
		return roledao.getRoles();
		
	}
	
	public boolean add(Role role) throws ClassNotFoundException, SQLException {
		RoleDAO roledao = new RoleDAO();
		return roledao.add(role);
		
	}
	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		RoleDAO roledao = new RoleDAO();
		return roledao.deleteAll();
		
}
}
