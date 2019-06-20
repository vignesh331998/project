package com.cts.bo;

import java.sql.SQLException;
import java.util.List;

import com.cts.dao.ServiceDAO;
import com.cts.dto.Service;


public class ServiceBO {

	public boolean update(Service service) throws ClassNotFoundException, SQLException {
		ServiceDAO servicedao = new ServiceDAO();
		return servicedao.update(service);
		
	}
	
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		ServiceDAO servicedao = new ServiceDAO();
		return servicedao.delete(id);
	}
	
	public Service get(String id) throws ClassNotFoundException, SQLException {
		ServiceDAO servicedao = new ServiceDAO();
		return servicedao.getService(id);
		
	}
	
	public List<Service> getServices() throws ClassNotFoundException, SQLException {
		ServiceDAO servicedao = new ServiceDAO();
		return servicedao.getServices();
		
	}
	
	public boolean add(Service service) throws ClassNotFoundException, SQLException {
		ServiceDAO servicedao = new ServiceDAO();
		return servicedao.add(service);
		
	}
	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		ServiceDAO servicedao = new ServiceDAO();
		return servicedao.deleteAll();
}
}
