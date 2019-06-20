package com.cts.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.bo.AddressBO;
import com.cts.bo.UserBO;
import com.cts.dto.Address;
import com.cts.dto.User;

/**
 * Servlet implementation class UserProfileController
 */
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileController() {
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
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		//HttpSession session=request.getSession();
    	User u=(User)session.getAttribute("user");
    	//int uid=u.getId();
		String uname=u.getName();
		
		//String uname=(String) session.getAttribute("username");
		//String name=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		String gender = request.getParameter("ugen");
		long contact =Long.parseLong(request.getParameter("ucont"));
		String pass = request.getParameter("upwd");
		String add1=request.getParameter("address1");
		String add2=request.getParameter("address2");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String pin=request.getParameter("pc");
		String state=request.getParameter("state");

		User user = new User();	
		Address address=new Address();
		user.setName(uname);
		user.setAge(age);
		user.setGender(gender);
		user.setContactNumber(contact);
		user.setPassword(pass);
		//r.setId(id);
		address.setLine1(add1);
		address.setLine2(add2);
		address.setCity(city);
		address.setCountry(country);
		address.setPincode(Long.parseLong(pin));
		address.setState(state);


		AddressBO addressBO=new AddressBO();
		UserBO userBo = new UserBO();
		boolean b;
		try {
			b = userBo.update(user);
			if(b)
			{
				System.out.println("Sucessfully updated in USer");
			}
			else
			{
				System.out.println("Data not updated in user");
			}

			//userBo.add(user);
			System.out.println(address.getCity());
			boolean a=addressBO.update(address,uname);
			System.out.println(a);
			if(a)
			{
				System.out.println("Sucessfully updated in Address");
				
			}
			else
			{
				System.out.println("Data not updated in address");
			}

			if(a==true && b==true)
			{
				dispatcher=request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);

			}
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}
	
}
