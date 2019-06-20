package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.bo.AdminBO;
import com.cts.dto.User;

/**
 * Servlet implementation class AdminVendorController
 */
public class AdminVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminVendorController() {
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
    		 List<User> vendorList=adminbo.getAllVendors();
    		 request.setAttribute("clist",vendorList);
    		 System.out.println(vendorList.size());
    		 dispatcher=request.getRequestDispatcher("VendorDetails.jsp");
    		 
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


