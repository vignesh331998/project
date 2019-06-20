package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.dto.Course;
import com.cts.dto.Role;
import com.cts.dto.User;
import com.cts.util.DBConnection;

public class AdminDAO {

	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<User> userList = new ArrayList<>();
		List list = new ArrayList<>();
		User user = null;
		Course course =new Course(); 

		try {
			PreparedStatement ps = con.prepareStatement("SELECT  user_table.user_id,user_table.name,user_table.age,user_table.gender,user_table.contact_number,user_course.course_code,course.name FROM user_table JOIN user_course ON user_table.user_id=user_course.user_id join course on user_course.vendor_id=course.user_id");
			ResultSet rs = ps.executeQuery();
			 
			while (rs.next()) {
				user = new User();
                user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setGender(rs.getString(4));
				user.setContactNumber(rs.getInt(5));
				user.setCid(rs.getInt(6));
			    user.setCname( rs.getString(7));
				userList.add(user);
				 
				 
				 

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
 
		return userList;

	}
	public List<User> getAllVendors() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<User> vendorList = new ArrayList<>();
		User user = null;
		 

		try {
			PreparedStatement ps = con.prepareStatement("select course.user_id,user_table.name,user_table.age,user_table.gender,user_table.contact_number,course.course_id,course.name as CourseName from course left join user_table on course.user_id = user_table.user_id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setGender(rs.getString(4));
				user.setContactNumber(rs.getInt(5));
				user.setCid(rs.getInt(6));
			    user.setCname( rs.getString(7));
			    vendorList.add(user);
				 

				 
				 
	}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vendorList;

	}
}
