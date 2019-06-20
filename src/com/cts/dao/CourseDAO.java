package com.cts.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.dto.Address;
import com.cts.dto.Course;
import com.cts.dto.User;
import com.cts.util.DBConnection;

public class CourseDAO {

	public List<Course> getCourseDisplay(int uid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Course> courseList = new ArrayList<>();
		Course course = null;

		try {
			PreparedStatement ps = con.prepareStatement("select user_course.vendor_id,user_course.course_code,course.name  from user_course  inner join course  on user_course.vendor_id=course.user_id where user_course.user_id=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				course = new Course();
				course.setUserid(rs.getInt(1));
					System.out.println(rs.getInt(1));
				course.setCid(rs.getInt(2));
				System.out.println(rs.getInt(2));
				course.setCname(rs.getString(3));
				System.out.println(rs.getString(3));
				courseList.add(course);

			
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		//0System.out.println("list in dao "+courseList);
		return courseList;
		
	}
	public List<Course> getProvideCourse(int uid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Course> courseList = new ArrayList<>();
		Course course = null;
		ResultSet rs =null;
		PreparedStatement ps=null;
		try {
			/*ps=con.prepareStatement("select user_id from user_table where name=?");
			 ps.setString( 1, uname);
				rs=ps.executeQuery();
	            rs.next();
	        	int userid=rs.getInt(1);*/
			ps = con.prepareStatement("select  name,course_id from course where user_id=?");
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				course = new Course();
				course.setCname(rs.getString(1));
				course.setCid(rs.getInt(2));
				
				courseList.add(course);

			
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		 
		return courseList;
		
	}
	public List<Course> getAccessCourse(int uid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Course> courseList = new ArrayList<>();
		List userList = new ArrayList<>();
		Course course = null;

		try {
			PreparedStatement ps = con.prepareStatement("select user_course.user_id,user_course.course_code,course.name  from user_course  inner join course  on user_course.vendor_id=course.user_id where user_course.vendor_id=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user=new User();
				course = new Course();
				user.setId(rs.getInt(1));
					 
				course.setCid(rs.getInt(2));
 				course.setCname(rs.getString(3));
 				courseList.add(course);
 				userList.add(user);
 				courseList.addAll(userList);

			
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		//0System.out.println("list in dao "+courseList);
		return courseList;
		
	}
	public Course getCourse() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();

		Course course = new Course();
	

		try {
			PreparedStatement ps = con.prepareStatement(
					"select NAME,COURSE_ID from course ");
			//ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				course.setCname(rs.getString(1));
				course.setCid(rs.getInt(2));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return course;
		
	}

	
	public List<Course> getCourses() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Course> courseList = new ArrayList<>();
		Course course = null;

		try {
			PreparedStatement ps = con.prepareStatement("select * from COURSE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				course = new Course();
				course.setCname(rs.getString(2));
				course.setCid(rs.getInt(3));
course.setUserid(rs.getInt(1));
				courseList.add(course);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return courseList;
			}
	
	
	
	public boolean add(Course course,int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement st = null;
        ResultSet rs=null;
        int userid=0;
        try {
        	
        	
            st = conn.prepareStatement("insert into Course values(?,?,?)");
            st.setInt(1,id);
            st.setString(2, course.getCname());
            st.setInt(3, course.getCid());
            
            
           
            int i = st.executeUpdate();
            if(i>0) {
                 return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
          
         st.close();
         conn.close();
   }
        return false;
        
        
   }

	
	public boolean update(Course course) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update COURSE set Name=? where Course_ID=id");

			ps.setNString(2, course.getCname());

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
	
	

	
	public boolean delete(String id) {
		// TODO Auto-generated method stub\
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from COURSE where COURSE_Id=?");
			ps.setString(2, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				//System.out.println("COURSE_Id " + id + " is deleted");
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
			PreparedStatement ps = con.prepareStatement("delete from COURSE");
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


