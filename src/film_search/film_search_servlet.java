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
 * Servlet implementation class film_search_servlet
 */
@WebServlet("/film_search_servlet")
public class film_search_servlet extends HttpServlet {  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  

response.setContentType("text/html");  
PrintWriter out = response.getWriter();

String s1=null;
String s2=null;
String s3=null;
String s4=null;
String s5=null;
      
s1=request.getParameter("Title");  
s2=request.getParameter("Category"); 
s3=request.getParameter("Language");  
s4=request.getParameter("Year");
s5=request.getParameter("Actor");
String custId=request.getParameter("custId");
System.out.println("Customer_id in film_search"+request.getParameter("custId"));

	if(s1!="")
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
	}
	
	System.out.println("s1 is "+s1);
	System.out.println("s2 is "+s2);
	System.out.println("s3 is "+s3);
	System.out.println("s4 is "+s4);
	System.out.println("s5 is "+s5);
	
	if(s1=="" && s2=="" && s3=="" && s4=="" && s5==""){
		request.setAttribute("custId", custId);
		request.setAttribute("null_error","Please enter atleast one field");
		System.out.println("Please enter atleast one field");  
	    RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
	    rd.include(request,response); 
		
	}



if(s1!=""){
boolean title_error=film_search.validate4(s1);
if(!title_error)
{
	request.setAttribute("custId", custId);
	request.setAttribute("title_error", "Please enter a valid title");
    RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
    rd.include(request,response);
	}
else {
	request.setAttribute("custId", custId);
	//request.setAttribute("title_error", "Please enter a valid title");
    RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
    rd.include(request,response);
	
}
}

if(s5!=""){
	boolean title_error=film_search.validate5(s5);
	if(!title_error)
	{
		request.setAttribute("custId", custId);
		request.setAttribute("Actor_error", "Please enter a valid actor name");
	    RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
	    rd.include(request,response);
		}
	else {
		request.setAttribute("custId", custId);
		//request.setAttribute("title_error", "Please enter a valid title");
	    RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
	    rd.include(request,response);
		
	}
	}

if(s1!="" || s2!="" || s3!="" || s4!="" || s5!=""){
List<filmBeans> fblist=new ArrayList<filmBeans>();
fblist=film_search.validate(s1,s4,s5,s2,s3);

System.out.println("size of fblist in servlet is "+fblist.size());
      
if(fblist.size()!=0){  
	//request.setAttribute("custId", custId);
    //RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
   // rd.forward(request,response);  
    
    RequestDispatcher dispatcher=null;
	request.setAttribute("custId", custId);
	dispatcher = request.getRequestDispatcher("Search.jsp");

	dispatcher.forward(request, response); 

}  
else{  
	request.setAttribute("NoSearch", "No search results found please enter other details");
    RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");  
    rd.forward(request,response);  
}  
      
out.close();  
} 
	}

}
