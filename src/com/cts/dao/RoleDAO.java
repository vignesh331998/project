package com.cts.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.dto.Address;
import com.cts.dto.Role;
import com.cts.dto.User;
import com.cts.util.DBConnection;

public class RoleDAO {

	
	public Role getRole(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();

		Role role  = new Role();
	

		try {
			PreparedStatement ps = con.prepareStatement(
					"select NAME,ROLE_ID from role where ROLE_ID=?");
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				role.setName(rs.getString(1));
				role.setId(rs.getInt(2));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return role;
	
	}

	
	public List<Role> getRoles() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Role> roleList = new ArrayList<>();
		Role role = new Role();

		try {
			PreparedStatement ps = con.prepareStatement("select NAME,ROLE_ID from ROLE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				role.setName(rs.getString(1));
				role.setId(rs.getInt(2));

				roleList.add(role);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return roleList;
		
	}
	
	
	
	public boolean add(Role role) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
    	
        try {
            ps = con.prepareStatement("insert into Role values(?,?)");
           
            ps.setString(1, role.getName());
            ps.setInt(2, role.getId());
           
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

	
	public boolean update(Role role) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update ROLE set Name=? where ROLE_ID=id");

			ps.setString(1, role.getName());

			int i = ps.executeUpdate();

			if (i > 0) {
				//System.out.println("All Records are Updated..!");\
				return true;

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

		
	}

	
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from ROLE where ROLE_Id=?");
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				//System.out.println("ROLE_Id " + id + " is deleted");
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
			PreparedStatement ps = con.prepareStatement("delete from ROLE");
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
	
	


