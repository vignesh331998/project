package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.dto.Service;
import com.cts.dto.ServiceCourse;
import com.cts.dto.UserService;
import com.cts.dto.User;
import com.cts.util.DBConnection;

public class UserServiceDAO {


	public UserService getUserService(UserService userService) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User ut = null;
		Service s = null;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select SERVICE_ID,USER_ID from USER_SERVICE where User_Id=?");
			//ps.setInt(2, ut.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt(1));
				userService.setService(s);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userService;

	}

	public List<UserService> getUserServices() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<UserService> userServiceList = new ArrayList<>();
		UserService userService = new UserService();
		User ut = null;
		Service s = null;

		try {
			PreparedStatement ps = con.prepareStatement("select SERVICE_ID,USER_ID from USER_SERVICE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s.setId(rs.getInt(1));
				//ut.setId(rs.getInt(2));
				userService.setService(s);
				userService.setUser(ut);
				userServiceList.add(userService);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userServiceList;
	}
	
	
	public boolean add(UserService us) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
    	try {
            ps = con.prepareStatement("insert into User_Service values(?,?)");
            ps.setInt(1, us.getService().getId());
           // ps.setInt(2,us.getUser().getId());
            int i = ps.executeUpdate();
            if(i>0) {
                 return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
          
         ps.close();
         con.close();
   }
        return false;
        
        
   }

	public boolean update(UserService userService) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("update USER_SERVICE set SERVICE_ID=?, where User_Id=id");

			ps.setInt(1, userService.getService().getId());

			int i = ps.executeUpdate();

			if (i > 0) {
				//System.out.println("All Records are Updated..!");
				return true;

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

	public boolean delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from User_SERVICE where USER_ID=?");
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				//System.out.println("UserId " + id + " is deleted");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from USER_SERVICE");
			int i = ps.executeUpdate();

			if (i > 0) {
				//System.out.println("All Records are deleted..!");
				return true;

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
