
<!-- This jsp page is intended for Customer Phone based search. 
It asks for customer Phone and outputs customer details -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>Search customer based on</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- This is the field where Phone is given -->
</head>

<body bgcolor=#B2E0FC>
<form method="post" action="customer_details_servlet">
<br>
</br>
<%
String errorMsg=null;
if(request.getAttribute("Error_message")!=null){
	errorMsg=request.getAttribute("Error_message").toString();
}
%>
<br>
</br>
<br>
</br>
<br>
</br>
	<tr><center>
	  <td><b>Enter Customer's Phone:</b></td>
	  <td><input type="number" name="Phone" id="Phone" required placeholder="Enter a valid phone number"></td>
 		</center></tr>
 <br>
</br>
 	<tr>
      <td></td>
      <td><center><input type="submit" value="submit" style="height:40px; width:80px"></center></td>
    </tr> 
    <%if(errorMsg!=null){
    	  %>
    	  <tr><center>
    	  <td style="color:red;"><b><%=errorMsg %></b></td>
    	  </center></tr>  
    	  
    	  <%
      }
      %>    
</form>
</body>
</html>