package film_search;

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

import com.dvd.login.LoginDao;

/**
 * Servlet implementation class film_add_servlet
 */
@WebServlet("/film_add_servlet")
public class film_add_servlet extends HttpServlet {  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
      
String s1=request.getParameter("Film_title");  
String s2=request.getParameter("Release_year"); 
String s3=request.getParameter("Rating");  
String s4=request.getParameter("Price");
String s5=request.getParameter("Length"); 
String s6=request.getParameter("Rental_duration"); 
String s7=request.getParameter("Replacement_cost"); 
String s8=request.getParameter("Language"); 
String s9=request.getParameter("Category"); 
String s10=request.getParameter("Actor_fn"); 
String s11=request.getParameter("Actor_ln"); 
String s12=request.getParameter("Dvd_barcode"); 
String s13=request.getParameter("Copies"); 


	/*if(s1!="")
	{
	request.setAttribute("Title1",s1);
	}
	if(s2!="")
	{
	request.setAttribute("Category1",s2);
	}
	if(s3!="")
	{
	request.setAttribute("Language1",s3);
	}
	if(s4!="")
	{
	request.setAttribute("Year1",s4);
	}
	if(s5!="")
	{
	request.setAttribute("Actor1",s5);
	} */

Boolean status = false; 
status=film_add.validate(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13);
      
if(status==true){  
	request.setAttribute("success1", "Added film details successfully");
    RequestDispatcher rd=request.getRequestDispatcher("film_add.jsp");  
    rd.forward(request,response);  
}  
else{  
    //out.print("Sorry");  
	request.setAttribute("Error_message", "Film already exists.. please enter new film");
    RequestDispatcher rd=request.getRequestDispatcher("film_add.jsp");  
    rd.include(request,response);  
}  
      
out.close();  
}  

}
