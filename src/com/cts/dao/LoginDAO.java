package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.util.DBConnection;



public class LoginDAO {

	public static boolean validateTrainer(String uname, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean status = false;
		try {
			con = DBConnection.getConnection();
				ps = con.prepareStatement("select name,password from user_table  where name=? and password=?");
				ps.setString(1, uname);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				status = rs.next();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static boolean validateTrainee(String uname, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean status = false;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select name,password from user_table  where name=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}

