package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.dto.Address;
import com.cts.dto.User;

import com.cts.util.DBConnection;

public class AddressDAO  {
	
	/*public void getIdFromUser()
	{
		User user=new User();
		Connection con = DBConnection.newConnection();
		try
		{
			PreparedStatement ps = con.prepareStatement("select USER_ID from USER_TABLE ORDERBY ID DESC LIMIT 1");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			user.setId(rs.getInt(1));
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
*/
	
	public Address getAddress(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();

		Address address = new Address();
		User ut = new User();

		try {
			
			PreparedStatement ps = con.prepareStatement("select USER_ID,ADDRESS_LINE1,ADDRESS_line2,CITY,COUNTRY,PINCODE,STATE where User_Id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//ut.setId(rs.getInt(1));
				//address.setUser(ut);
				address.setLine1(rs.getString(2));
				address.setLine2(rs.getString(3));
				address.setCity(rs.getString(4));
				address.setCountry(rs.getString(5));
				address.setPincode(rs.getLong(6));
				address.setState(rs.getString(7));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return address;
	}

	
	public List<Address> getAddresses() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Address> addressList = new ArrayList<>();
		Address address = new Address();
		User ut=new User(); 

		try {
			PreparedStatement ps = con.prepareStatement("select USER_ID,NAME,AGE,GENDER,CONTACT_NUMBER,PASSWORD,ROLE_ID from USER_TABLE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//ut.setId(rs.getInt(1));
				//address.setUser(ut);
				address.setLine1(rs.getString(2));
				address.setLine2(rs.getString(3));
				address.setCity(rs.getString(4));
				address.setCountry(rs.getString(5));
				address.setPincode(rs.getLong(6));
				address.setState(rs.getString(7));
				}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return addressList;
			}
	
	
	public boolean add(Address address) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        User user=new User();
       
    
        try {
            ps = con.prepareStatement("insert into Address(User_Id,Address_Line1,Address_Line2,city,country,pincode,state) values(6,?,?,?,?,?,?)");
          //  ps.setInt(1, address.getUser().getId());
           // getIdFromUser();
           
            //ps.setInt(1, user.getId());
            ps.setString(1, address.getLine1());
            ps.setString(2, address.getLine2());
            ps.setString(3,address.getCity());
            ps.setString(4, address.getCountry());
            ps.setLong(5,address.getPincode());
            ps.setString(6, address.getState());
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


	
	public boolean update(Address address,String uname) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Connection con = DBConnection.getConnection();
			ResultSet rs=null;
			PreparedStatement ps=con.prepareStatement("select user_id from user_table where name=?");
		 ps.setString( 1, uname);
			rs=ps.executeQuery();
            rs.next();
        	int userid=rs.getInt(1);
			 ps = con.prepareStatement(
					"update Address set ADDRESS_LINE1=?,ADDRESS_LINE2=?,CITY=?,COUNTRY=?,PINCODE=?,sTATE=? where User_Id=?");
            
			ps.setString(1,address.getLine1());
			ps.setString(2, address.getLine2());
			ps.setNString(3, address.getCity());
			ps.setNString(4, address.getCountry());
			ps.setLong(5,address.getPincode());
			ps.setNString(6, address.getState());
            ps.setInt(7,userid );
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
			PreparedStatement ps = con.prepareStatement("delete from ADDRESS where user_Id=?");
			ps.setInt(1, id);
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
			PreparedStatement ps = con.prepareStatement("delete from ADDRESS");
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
 