/*This servlet takes input of ID or email or phone based on customer input and calls function based on the input 
 * to search for customer_details*/

package com.dvd.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer_details_servlet")
public class customer_details_servlet extends HttpServlet {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customer_details_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  

response.setContentType("text/html");  
PrintWriter out = response.getWriter(); 

String s1=null;
String s2=null;
String s3=null;
 
/*gets the parameters given as input as ID or email or phone*/
s1=request.getParameter("ID");  
s2=request.getParameter("Email"); 
s3=request.getParameter("Phone"); 

List<customerBeans> fblist=new ArrayList<customerBeans>();


	if(s1!=null)
	{
	
	request.setAttribute("Customer_id1",s1);
	fblist=customer_search.validatecustomer_id(s1); /*calls for function defined in customer_search.java and
	returns a list once given customer_id*/
	}
	else if(s2!=null)
	{
	request.setAttribute("Email1",s2);
	fblist=customer_search.validateemail(s2);/*calls for function defined in customer_search.java and
	returns a list once given email*/

	}
	else if(s3!=null)
	{
	request.setAttribute("Phone1",s3);
	fblist=customer_search.validatephone(s3);/*calls for function defined in customer_search.java and
	returns a list once given phone*/

	}
	      
if(fblist.size()!=0){ 
	
	
	
	
    RequestDispatcher rd=request.getRequestDispatcher("customer_DETAILS.jsp");  
    /*If any one of ID, email, phone are set, then customer details are displayed*/
    rd.forward(request,response);  
}  
else{  
    //out.print("Sorry username or password error"); 
	
	if(s1!=null){
		request.setAttribute("Error_message", "Please enter correct customer ID");
	    RequestDispatcher rd=request.getRequestDispatcher("customer_search_ID.jsp"); 
	    
	    rd.include(request,response);  
	}
	
	if(s2!=null){
		request.setAttribute("Error_message", "Please enter correct customer Email_ID");
	    RequestDispatcher rd=request.getRequestDispatcher("customer_search_EMAIL.jsp"); 
	    
	    rd.include(request,response);  
	}
	if(s3!=null){
		request.setAttribute("Error_message", "Please enter correct customer phone number");
	    RequestDispatcher rd=request.getRequestDispatcher("customer_search_PHONE.jsp"); 
	    
	    rd.include(request,response);  
	}
	
}       
out.close();  
}  

}
