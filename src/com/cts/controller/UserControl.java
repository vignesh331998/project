package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.bo.AddressBO;
import com.cts.bo.UserBO;
import com.cts.dao.UserDAO;
import com.cts.dto.Address;
import com.cts.dto.Role;
import com.cts.dto.User;

public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("Register")) {
			registrationProcess(request, response);

		}

		if (action.equals("Login")) {
			try {
				processLogin(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}


	}

	private void processLogin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {

		String u = request.getParameter("select");

        User user=null;
		boolean result = false;
	//	String message="";
		HttpSession session=request.getSession();
		try {

			if (u.equalsIgnoreCase("Admin")) {
			 String uname = request.getParameter("uname");
			 //int userName=Integer.parseInt(i);
				String upwd = request.getParameter("upwd");
				UserBO userbo=new UserBO();
				//result=userbo.validateUser(uname, upwd);
				 user=userbo.validateUser(uname, upwd);
				RequestDispatcher dispatcher=null;
			
				if(user!=null)
				{
					dispatcher=request.getRequestDispatcher("AdminHome.jsp");
					session.setAttribute("user", user);
					dispatcher.forward(request, response);

				}
				else
				{
					dispatcher=request.getRequestDispatcher("Login.jsp");
				    request.setAttribute("msg","Invalid username/password");
					dispatcher.forward(request, response);
				}
			}
			else if (u.equalsIgnoreCase("vendor")) {
				 String uname = request.getParameter("uname");
				 //int userName=Integer.parseInt(i);
					String upwd = request.getParameter("upwd");
					UserBO userbo=new UserBO();
					user=userbo.validateUser(uname, upwd);
					RequestDispatcher dispatcher=null;
					//HttpSession session=request.getSession();
					if(user!=null)
					{
						dispatcher=request.getRequestDispatcher("VendorHome.jsp");
						session.setAttribute("user", user);
						dispatcher.forward(request, response);

					}
					else
					{
						dispatcher=request.getRequestDispatcher("homepage.jsp");
						//request.setAttribute("msg","Invalid username/password");
						dispatcher.forward(request, response);
					}
				}
			else if (u.equalsIgnoreCase("subscriber")) {
				 String uname = request.getParameter("uname");
				 //int userName=Integer.parseInt(i);
					String upwd = request.getParameter("upwd");
					UserBO userbo=new UserBO();
					user=userbo.validateUser(uname, upwd);
					RequestDispatcher dispatcher=null;
					session=request.getSession();
					if(user!=null)
					{
						dispatcher=request.getRequestDispatcher("UserHome.jsp");
						session.setAttribute("user", user);
						dispatcher.forward(request, response);

					}
					else
					{
						dispatcher=request.getRequestDispatcher("homepage.jsp");
						request.setAttribute("msg","Invalid username/password");
						dispatcher.forward(request, response);
					}
				}

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void registrationProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		String gender = request.getParameter("ugen");
		long contact =Long.parseLong(request.getParameter("ucont"));
		String pass = request.getParameter("upwd");
		String role=request.getParameter("select");
		String add1=request.getParameter("address1");
		String add2=request.getParameter("address2");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String pin=request.getParameter("pc");
		String state=request.getParameter("state");
        
		User user = new User();	
		Address address=new Address();
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		user.setContactNumber(contact);
		user.setPassword(pass);
		int id=0;
		if(role.equalsIgnoreCase("admin"))
		{
			id=1;
		user.setRoleId(id);
		}
		else if(role.equalsIgnoreCase("vendor"))
		{
			id=2;
			user.setRoleId(id);
		}
		else if(role.equalsIgnoreCase("subscriber"))
		{
			id=3;
			user.setRoleId(id);
		}
		address.setLine1(add1);
		address.setLine2(add2);
		address.setCity(city);
		address.setCountry(country);
		address.setPincode(Long.parseLong(pin));
		address.setState(state);
   

		AddressBO addressBO=new AddressBO();
		
		UserBO userBo = new UserBO();
		RequestDispatcher dispatcher=null;
		boolean b;
		try {
			b = userBo.add(user,address);
			if(b)
			{
				dispatcher=request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
			}
			 
			
			//userBo.add(user);
			//System.out.println(address.getCity());
			//boolean a=addressBO.add(address);
			//boolean a=userBO.add(address);
//			System.out.println(a);
//			if(a)
//			{
//				System.out.println("Sucessfully inserted in Address");
//			}
//			else
//			{
//				System.out.println("Data not inserted in address");
//			}

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
