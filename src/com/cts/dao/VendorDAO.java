package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.util.DBConnection;

public class VendorDAO {
	public boolean delete(String uname,String upwd) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
        PreparedStatement st=null;
        ResultSet rs=null;
        boolean result=false;
        int userid=0;
		try {
			st = conn.prepareStatement("select *  from User_Table where name=? and password=?");
			st.setString(1, uname);
            st.setString(2, upwd);
			rs=st.executeQuery();
			rs.next();
        	userid=rs.getInt(1);
        	
        	st=conn.prepareStatement("delete from course where user_id=?");
            st.setInt(1,userid);
            int i= st.executeUpdate();
			 
			st=conn.prepareStatement("delete from address where user_id=?");
            st.setInt(1,userid);
            int k = st.executeUpdate();
            
			if (i>0 && k == 1) {
				System.out.println("UserId " + userid + " is deleted");
				st=conn.prepareStatement("delete from user_table where user_id=?");
	            st.setInt(1,userid);
	            int j = st.executeUpdate();
				if (j== 1) 
				result=true;
				System.out.println(j);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}

