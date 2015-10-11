/*This servlet is used for fetching the input given to page delte_admin.jsp file
  and validates the input and returns true if the input is true*/

package com.dvd.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class admin_delete_servlet
 */
@WebServlet("/admin_delete_servlet")
public class admin_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_delete_servlet() {
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
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 

		String s1=null;
		String s2=null;
		      
		s1=request.getParameter("First_name"); /*This parameter which was initialized to null in delete_admin.jsp file*/ 
		s2=request.getParameter("Last_name");

		

			if(admin_delete.validate(s1, s2)) 
				/* validate function is called which is defined in admin_delete.java file
				 this returns true if s1 and s2 parameters are correct in database.*/
			{
				request.setAttribute("success1", "Deleted admin details successfully");
			    RequestDispatcher rd=request.getRequestDispatcher("delete_admin.jsp");  /* on success of validate fucntion, 
			    it is redirected to delete_admin.jsp page*/
		        rd.forward(request,response);  
			}
		
			 
		else{  
		    //out.print("Enter all the fields correctly to delete admin"); 
		    request.setAttribute("Error_message", "Admin cannot be deleted or doesnt exist");
		    RequestDispatcher rd=request.getRequestDispatcher("delete_admin.jsp");  
		    rd.include(request,response);  
		}       
		out.close();  
		}
	

}
