package com.cts.bo;



import java.sql.SQLException;
import java.util.List;

import com.cts.dao.CourseDAO;
import com.cts.dto.Course;

public class CourseBO {

	public boolean update(Course course) throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.update(course);
		
	}
	
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.delete(id);
	}
	
	public Course get() throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.getCourse();
		
	}
	
	public List<Course> getProvideCourse(int uid) throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.getProvideCourse(uid);
		
	}
	public List<Course> getAccessCourse(int uid) throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.getAccessCourse(uid);
		
	}
	public List<Course> getCourses() throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.getCourses();
		
	}
	public List<Course> getCourseDisplay(int uid) throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.getCourseDisplay(uid);
		
	}
	public boolean add(Course course,int id) throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.add(course,id);
		
	}
	
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		CourseDAO coursedao = new CourseDAO();
		return coursedao.deleteAll();
		

}
}