package com.dvd.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class customer_return_dvd_servlet
 */
@WebServlet("/customer_return_dvd_servlet")
public class customer_return_dvd_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customer_return_dvd_servlet() {
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
		String dvd_barcode = request.getParameter("dvd_barcode");
		boolean status=customer_dvd_return.returndvd(custId,dvd_barcode);
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
	    request.setAttribute("Error_message", "Please enter correct DVD barcode");
	    RequestDispatcher rd=request.getRequestDispatcher("return_DVD.jsp");  
	    rd.include(request,response);  
	}       


	}

}
