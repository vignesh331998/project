package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.bo.CourseBO;
import com.cts.dto.Course;
import com.cts.dto.User;

/**
 * Servlet implementation class VendorController
 */
public class VendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean result=false;
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		Course course=new Course();
		CourseBO coursebo=new CourseBO();
		course.setCid(cid);
		course.setCname(cname);
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
	User u=(User) session.getAttribute("user");
		try {
			result=coursebo.add(course,u.getId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result)
		{
			dispatcher=request.getRequestDispatcher("Success.jsp");
			//session.setAttribute("username", uname);
			dispatcher.forward(request, response);

		}
		else
		{
			dispatcher=request.getRequestDispatcher("VendorHome.jsp");
			//request.setAttribute("msg","Invalid username/password");
			dispatcher.forward(request, response);
		}
		
	}

}
