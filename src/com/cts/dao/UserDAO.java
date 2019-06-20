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

public class UserDAO {

	
	public User getUser(int id) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();

		User User = new User();
		Role role = new Role();

		try {
			PreparedStatement ps = con.prepareStatement("select USER_ID,NAME,AGE,GENDER,CONTACT_NUMBER,PASSWORD,ROLE_ID from USER_TABLE where User_Id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				//User.setId(rs.getInt(1));
				User.setName(rs.getString(2));
				User.setAge(rs.getInt(3));
				User.setGender(rs.getString(4));
				User.setPassword(rs.getString(5));
				role.setId(rs.getInt(6));
				User.setContactNumber(rs.getInt(7));

				//User.setRoleId(role);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return User;
	}

	
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<User> userList = new ArrayList<>();
		User User = new User();
		Role role = new Role();

		try {
			PreparedStatement ps = con.prepareStatement("select USER_ID,NAME,AGE,GENDER,PASSWORD,ROLE_ID,CONTACT_NUMBER from USER_TABLE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				//User.setId(rs.getInt(1));
				User.setName(rs.getString(2));
				User.setAge(rs.getInt(3));
				User.setGender(rs.getString(4));
				User.setContactNumber(rs.getInt(5));
				User.setPassword(rs.getString(6));
				/*role.setId(rs.getInt(7));

				User.setRoleId(role);
				userList.add(User);
*/
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userList;

	}
	public boolean add(User user,Address address) throws SQLException, ClassNotFoundException {
		
		System.out.println(" dao "+user.getName()+"  "+user.getAge());
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs=null;
        int userid=0;
        int i=0,j=0;
        try {
        	ps=con.prepareStatement("select user_seq.nextval from dual");
        	rs=ps.executeQuery();
        	rs.next();
        	userid=rs.getInt(1);
        	
            ps = con.prepareStatement("insert into user_table(user_id,name,age,gender,contact_number,password,role_id) values(?,?,?,?,?,?,?)");
           ps.setInt(1,userid);
            ps.setString(2,user.getName());
            ps.setInt(3, user.getAge());
            ps.setString(4,user.getGender());
            
            //ps.setInt(5,1);
            ps.setLong(5,user.getContactNumber());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getRoleId());
            
            i = ps.executeUpdate();
            if(i>0) {
            	  ps = con.prepareStatement("insert into Address(User_Id,Address_Line1,Address_Line2,city,country,pincode,state) values(?,?,?,?,?,?,?)");
                  //  ps.setInt(1, address.getUser().getId());
                   // getIdFromUser();
                   
                    ps.setInt(1, userid);
                    ps.setString(2, address.getLine1());
                    ps.setString(3, address.getLine2());
                    ps.setString(4,address.getCity());
                    ps.setString(5, address.getCountry());
                    ps.setLong(6,address.getPincode());
                    ps.setString(7, address.getState());
                    
                   j = ps.executeUpdate();
                
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
       
        finally {
          
         ps.close();
         con.close();
   }
        if(i>0 && j>0)
        	return true;
        else
        	return false;
        
        
   }
	public boolean update(User User) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement(
					"update USER_TABLE set Age=?,Gender=?,Contact_Number=?,Password=? where name=?");

			
			ps.setInt(1, User.getAge());
			ps.setNString(2, User.getGender());
			
			//ps.setInt(6, User.getRoleId().getId());
			ps.setLong(3, User.getContactNumber());
			ps.setNString(4, User.getPassword());
			ps.setString(5, User.getName());
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

	
	public boolean delete(String uname,String upwd) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();;
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
        	
			st=conn.prepareStatement("delete from address where user_id=?");
            st.setInt(1,userid);
            int k = st.executeUpdate();
            
            
			if (k == 1) {
				//System.out.println("UserId " + id + " is deleted");
				st=conn.prepareStatement("delete from user_table where user_id=?");
	            st.setInt(1,userid);
	            int j = st.executeUpdate();
				if (j== 1) {
				result=true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from USER_TABLE");
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


	public    User validateUser(String uname, String upwd) throws ClassNotFoundException, SQLException {
		Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        boolean result=false;
        User u=null;
        try
        {
                        conn=DBConnection.getConnection();
                        st=conn.prepareStatement("select * from user_table where name=? and password=?");
                        st.setString(1, uname);
                        st.setString(2, upwd);
                        rs=st.executeQuery();
                        if(rs.next())
                        {
                        	u=new User();
                        	u.setId(rs.getInt(1));
                        	u.setName(rs.getString(2));
                        	u.setAge(rs.getInt(3));
                        	u.setGender(rs.getString(4));
                        	u.setContactNumber(rs.getInt(5));
                        	u.setPassword(rs.getString(6));
                        	u.setRoleId(rs.getInt(7));
                                       
                        }
                        
        }
        catch(Exception e)
        {
                        e.printStackTrace();
        }
        return u;

	}


	public boolean addAvailCourse(String courseid[],int uid) {
		// TODO Auto-generated method stub
		Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        boolean result=false;
        int enrollid=0;
        int i=0;
        int count=0;
        try
        {
                        conn=DBConnection.getConnection();
                        for(i=0;i<courseid.length;i++)
                        {
                        st=conn.prepareStatement("select enroll_seq.nextval from dual");
                        rs=st.executeQuery();
                        rs.next();
                        enrollid=rs.getInt(1);
                        String arr[]=courseid[i].split(" ");
                        st=conn.prepareStatement("insert into user_course values(?,?,?,?)");
                        st.setInt(1, enrollid);
                        st.setInt(2, uid);
                        st.setInt(3, Integer.parseInt(arr[1]));
                        st.setInt(4, Integer.parseInt(arr[0]));
                        int res=st.executeUpdate();
                            if(res>0)
                            	count++;
                        }
                        if(count==courseid.length)
                        result=true;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return result;
	}

	

}
