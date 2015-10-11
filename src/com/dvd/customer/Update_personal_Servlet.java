/*This servlet gets the values of updated values and checks if they are all correct and valid
 * and then updates the database and also prints them back*/

package com.dvd.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update_personal_Servlet
 */
@WebServlet("/Update_personal_Servlet")
public class Update_personal_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_personal_Servlet() {
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
	
	
	      
	 String s1=request.getParameter("first_nameUpdate");  
	 String s2=request.getParameter("last_nameUpdate"); 
	 String s3=request.getParameter("emailUpdate"); 
	 String phone=request.getParameter("phoneUpdate");
	 int s4=0;
	 if(phone !=""){
		s4=Integer.parseInt(phone); 
	 }
	 else{
		 s4=0;
	 }
	String custId=request.getParameter("custId");
	String pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	String pattern2 = "^[0-9]{8}";
	System.out.println("Printing s1 " +s1);
	System.out.println("Printing s2 "+s2);
	System.out.println("Printing s3 "+s3);
	System.out.println("Printing s4 "+s4);
	
	RequestDispatcher dispatcher=null;
	boolean flag=true;
	
	if(s3!=""){
		if(!s3.matches(pattern)){
			System.out.println("email did not match");
			request.setAttribute("emailError", "Please enter a valid email address");
			flag=false;
		}
	}
	
	if(s4!=0){
		if(!Integer.toString(s4).matches(pattern2)){
			System.out.println("phone error");
			request.setAttribute("phoneError", "Please enter a valid phone number");
			flag=false;
		}	
	}
	
	try {
	if(s4!=0){
		if(Integer.toString(s4).matches(pattern2)){
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
	//System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7+" "+s8+" "+s9+" "+s10+" "+s11+" "+s12+" "+s13);

	PreparedStatement st = con.prepareStatement("select phone from customer where phone=? and customer_id <> ?");

	st.setString(1,phone);  
	st.setString(2,custId);
	
	 st.execute("use dvd_rental");
	  // Result set get the result of the SQL query
	 //st.execute();
	 ResultSet r1=st.executeQuery();
	 
	 if(r1.next()){
			System.out.println("phone error");
			request.setAttribute("phoneError1", "Phone number already exists");
			flag=false;
	 }
		}	
	}
	}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("ERROR MESSAGE :"+e.getMessage());
		e.printStackTrace();
	}
	
	try {
		if(s3!=""){
			if(s3.matches(pattern)){
				Class.forName("com.mysql.jdbc.Driver");
				Connection  con = DriverManager
			      .getConnection("jdbc:mysql://localhost:3306?"
			          + "user=root&password=password");
		//System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7+" "+s8+" "+s9+" "+s10+" "+s11+" "+s12+" "+s13);

		PreparedStatement st = con.prepareStatement("select email from customer where email=? and customer_id <> ?");

		st.setString(1,s3);  
		st.setString(2,custId);
		
		 st.execute("use dvd_rental");
		  // Result set get the result of the SQL query
		 //st.execute();
		 ResultSet r1=st.executeQuery();
		 
		 if(r1.next()){
				System.out.println("emailError");
				request.setAttribute("emailError1", "Email Id already exists.. please enter new email Id");
				flag=false;
		 }
			}	
		}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  // Setup the connection with the DB
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR MESSAGE :"+e.getMessage());
			e.printStackTrace();
		}
	
	if(s3==""&&s1==""&&s2==""&&s4==0){
		System.out.println("update error");
		request.setAttribute("updateError", "You haven't entered any field");
		flag=false;
	}
	
	if(flag==false){
		dispatcher = request.getRequestDispatcher("update_personal.jsp");
		dispatcher.forward(request, response);
		
	}
	else{
		System.out.println("Success");
		Map<String,String> updateCustomerMap=new HashMap<String	,String>(); /*This hashmap links key to value pairs and the
		stored values printed in .jsp files */
		if(s3!=""){
			updateCustomerMap.put("emailUpdate", s3);
		}
		if(s1!=""){
			updateCustomerMap.put("first_nameUpdate", s1);
		}
		if(s2!=""){
			updateCustomerMap.put("last_nameUpdate", s2);
		}
		if(s4!=0){
			updateCustomerMap.put("phoneUpdate", Integer.toString(s4));
		}
		boolean updateFlag=customer_search.updatePersonalDetails(custId, updateCustomerMap);
		if(updateFlag==true){
			System.out.println("Update Dispatcher IF");
			 dispatcher = request.getRequestDispatcher("update_personal.jsp");
			 request.setAttribute("custId", custId);
			 request.setAttribute("updated", "Updated customer details successfully");
				dispatcher.forward(request, response); 
				System.out.println("Validation Dispatcher Forwarded");

		}
	}
	

	}

}
