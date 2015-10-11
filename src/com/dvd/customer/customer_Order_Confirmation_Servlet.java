package com.dvd.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvd.admin.admin_delete;

/**
 * Servlet implementation class customer_Order_Confirmation_Servlet
 */
@WebServlet("/customer_Order_Confirmation_Servlet")
public class customer_Order_Confirmation_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customer_Order_Confirmation_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String custId=request.getParameter("custId");
		String[] title=request.getParameterValues("title");
		String[] release_year=request.getParameterValues("release_year");
		String[] language=request.getParameterValues("language");
		System.out.println("********************"+title.length);
		System.out.println("********************"+release_year.length);
		System.out.println("********************"+language.length);
		boolean status=customer_film_order.insertFilmOrder(custId,title, release_year,language);
		if(status) 
			/* validate function is called which is defined in admin_delete.java file
			 this returns true if s1 and s2 parameters are correct in database.*/
		{
		    RequestDispatcher rd=request.getRequestDispatcher("admin_HOME.jsp");  /* on success of validate fucntion, 
		    it is redirected to delete_admin.jsp page*/
	        rd.forward(request,response);  
		}
	
		 
	else{  
	    //out.print("Enter all the fields correctly to delete admin"); 
	    request.setAttribute("Error_message", "Please confirm film selection");
	    RequestDispatcher rd=request.getRequestDispatcher("reviewOrder.jsp");  
	    rd.include(request,response);  
	}       


	}

}
