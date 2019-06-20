package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.bo.AdminBO;
import com.cts.bo.CourseBO;
import com.cts.dto.Course;
import com.cts.dto.User;

/**
 * Servlet implementation class AdminUserController
 */
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminBO adminbo=new AdminBO();
    	RequestDispatcher dispatcher=null;
    	 try {
    		 List<User> userList=adminbo.getAllUsers();
    		 request.setAttribute("clist", userList);
    		 System.out.println(userList.size());
    		 dispatcher=request.getRequestDispatcher("UserDetails.jsp");
    		 
             dispatcher.forward(request,response);
            
    		 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


