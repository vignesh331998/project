package com.cts.bo;

import java.sql.SQLException;

import com.cts.dao.UserDAO;
import com.cts.dao.VendorDAO;

public class VendorBO {
	public boolean delete(String uname,String upwd) throws ClassNotFoundException, SQLException {
		VendorDAO vendao = new VendorDAO();
		return vendao.delete(uname, upwd);
	}
}
