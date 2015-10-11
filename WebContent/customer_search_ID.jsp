
<!-- This jsp page is intended for Customer ID based search. 
It asks for customer ID and outputs customer details -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>Search customer based on</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body bgcolor=#B2E0FC>
<form method="post" action="customer_details_servlet">
<br>
<%
String errorMsg=null;
if(request.getAttribute("Error_message")!=null){
	errorMsg=request.getAttribute("Error_message").toString();
}
%>
<br>
<br>
<br>
<tr style="color:#0052CC;"><center>
	  <td><b>Enter Customer's ID:</b></td>
	  <td><input type="number" name="ID" id="ID" required></td> <!-- This is the field where ID is given -->
 		</center></tr>
 <br>
  <tr>
      <td></td>
      <td><center><input type="submit" value="submit" style="height:40px; width:80px"></center></td>
      </tr>
      <%if(errorMsg!=null){
    	  %>
    	  <tr>
    	  <td><%=errorMsg %></td>
    	  </tr>  
    	  
    	  <%
      }
      %>
    
       
</form>
</body>
</html>