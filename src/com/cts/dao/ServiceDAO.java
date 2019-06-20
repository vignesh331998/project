package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.dto.Address;
import com.cts.dto.Service;
import com.cts.dto.User;
import com.cts.util.DBConnection;

public class ServiceDAO{

	
	public Service getService(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();

		Service service = new Service();
	
		try {
			PreparedStatement ps = con.prepareStatement(
					"select NAME,SERVICE_ID,DURATION,AMOUNT from SERVICE where SERVICE_Id=?");
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				service.setName(rs.getString(1));
				service.setDuration(rs.getLong(3));
				service.setAmount(rs.getDouble(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return service;
		
	}

	
	public List<Service> getServices() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Service> serviceList = new ArrayList<>();
		Service service = new Service();

		try {
			PreparedStatement ps = con.prepareStatement("select NAME,SERVICE_ID,DURATION,AMOUNT from SERVICE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				service.setName(rs.getString(1));
				service.setId(rs.getInt(2));
				service.setDuration(rs.getLong(3));
				service.setAmount(rs.getDouble(4));
				serviceList.add(service);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return serviceList;

	}

	
	
	public boolean add(Service service) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
    	User ut=new User(); 
        try {
            ps = con.prepareStatement("insert into Service values(?,?,?,?)");
            ps.setInt(1, service.getId());
            ps.setString(2, service.getName());
            ps.setLong(3, service.getDuration());
            ps.setDouble(4,service.getAmount());
           
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
	
	
	
	public boolean update(Service service) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update SERVICE set Name=?,DURATION=?,AMOUNT=? where SERVICE_Id=id");

			ps.setString(1, service.getName());
			ps.setLong(3, service.getDuration());
			ps.setDouble(4, service.getAmount());

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

	
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from SERVICE where SERVICE_Id=?");
			ps.setString(2, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				//System.out.println("SERVICE_Id " + id + " is deleted");
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
			PreparedStatement ps = con.prepareStatement("delete from SERVICE");
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

		
		



