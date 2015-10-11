<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Admin</title>
</head>
<body bgcolor=#B2E0FC>
<form method="post" action="admin_delete_servlet">

<%
/*String First_name1 = null;
String Last_name1 = null;
String Email1 =null;
Boolean flag =false;

if(request.getAttribute("First_name1")!=null && request.getAttribute("Last_name1")!=null && request.getAttribute("Email1")!=null)
{
	First_name1 = request.getAttribute("First_name1").toString();
	Last_name1 = request.getAttribute("Last_name1").toString();
	Email1 = request.getAttribute("Email1").toString();
	flag =true; 
}*/


String errorMsg=null;
if(request.getAttribute("Error_message")!=null){
	errorMsg=request.getAttribute("Error_message").toString();
}

String success1=null;
System.out.println(success1);
if(request.getAttribute("success1")!=null)
{
success1 = request.getAttribute("success1").toString();
System.out.println(success1);
}
String success2="Deleted admin details successfully";


%>
<center><h1>Enter below fields to delete admin</h1>

<center><table width="1200" border="0">
  <tbody>
  
   
       <tr style="color:#0052CC;">
      <td><center><b>First_name <input type="text" name="First_name" id="First_name" required></b></center></td>
       </tr>
       <tr style="color:#0052CC;">
      <td><center><b>Last_name 
      <input type="text" name="Last_name" id="Last_name" required></b></center></td>
       </tr>
   
	<tr>
      <td><center><input type="submit" name="submit" id="submit" value="Delete Admin" style="height:30px; width:150px" ></center></td>
   </tr> 
   
   <tr>
      <td><center><a href="admin_HOME.jsp"><input type="button" name="button1" id="button1" value="Back to Home" style="height:30px; width:150px" ></a></center></td>
   </tr>
   
   <tr style="color:green;">
   <td>
   <% 
   if(request.getAttribute("success1")!=null)
   {
   if (success1.equals(success2)){%>
	   <center><b><%=success2 %></b></center>
	  <%} %>
	  	  <%} %>
	  	  
  <%if(errorMsg!=null){
    	  %>
    	  <center><tr style="color:red;">
    	  <td><b><%=errorMsg %></b></td>
    	 </tr></center>
    	  
    	  <%
      }
      %>
	  
  </tbody>
</table></center>

</center>
</form>



</body>
</html>