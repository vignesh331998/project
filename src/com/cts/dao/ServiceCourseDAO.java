package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.dto.Address;
import com.cts.dto.Course;
import com.cts.dto.Role;
import com.cts.dto.Service;
import com.cts.dto.ServiceCourse;
import com.cts.dto.UserService;
import com.cts.dto.User;
import com.cts.util.DBConnection;

public class ServiceCourseDAO {

	
	public ServiceCourse getServiceCourse(ServiceCourse serviceCourse) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Service s = null;
		Course c = null;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("select SERVICE_ID,COURSE_ID from SERVICE_COURSE  where SERVICE_ID=?");
			ps.setInt(2, c.getCid());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setCid(rs.getInt(2));
				serviceCourse.setCourseId(c);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return serviceCourse;

	}

	
	public List<ServiceCourse> getServiceCourses() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<ServiceCourse> serviceCourseList = new ArrayList<>();
		ServiceCourse serviceCourse = new ServiceCourse();
		Service s = new Service();
		Course c = new Course();

		try {
			PreparedStatement ps = con.prepareStatement("select SERVICE_ID,COURSE_ID from Service_Course ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s.setId(rs.getInt(1));
				c.setCid(rs.getInt(2));
				serviceCourse.setServiceId(s);
				serviceCourse.setCourseId(c);
				serviceCourseList.add(serviceCourse);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return serviceCourseList;

	}
	
	
	public boolean add(ServiceCourse sc) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
    	try {
            ps = con.prepareStatement("insert into Service_Course values(?,?)");
            ps.setInt(1, sc.getServiceId().getId());
            ps.setInt(2,sc.getCourseId().getCid());
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

	
	public boolean update(ServiceCourse serviceCourse) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection con = DBConnection.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("update USER_TABLE set COURSE_ID=? where SERVICE_ID=id");

			ps.setInt(7, serviceCourse.getCourseId().getCid());
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
			PreparedStatement ps = con.prepareStatement("delete from SERVICE_COURSE where SERVICE_Id=?");
			ps.setInt(1, id);
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
			PreparedStatement ps = con.prepareStatement("delete from SERVICE_COURSE");
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
