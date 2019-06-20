package com.cts.bo;


import java.sql.SQLException;
import java.util.List;
import com.cts.dao.AddressDAO;
import com.cts.dto.Address;

public class AddressBO {

	public boolean update(Address address,String uname) throws ClassNotFoundException, SQLException {
		AddressDAO addressdao = new AddressDAO();
		return addressdao.update(address,uname);
		
	}
	
	public boolean delete(int userId) throws ClassNotFoundException, SQLException {
		AddressDAO addressdao = new AddressDAO();
		return addressdao.delete(userId);
	}
	
	public Address get(int userId) throws ClassNotFoundException, SQLException {
		AddressDAO addressdao = new AddressDAO();
		return addressdao.getAddress(userId);
		
	}
	
	public List<Address> getAddresses() throws ClassNotFoundException, SQLException {
		AddressDAO addressdao = new AddressDAO();
		return addressdao.getAddresses();
		
	}
	
	public boolean add(Address address) throws ClassNotFoundException, SQLException {
		AddressDAO addressdao = new AddressDAO();
		return addressdao.add(address);
		
	}
	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		AddressDAO addressdao = new AddressDAO();
		return addressdao.deleteAll();
		
	}
}


