
<!-- This page allows the admin to search for customer details.
The page has 3 buttons which allows the admin to search for 
customer details based on:
(i) Customer ID		(ii) Email		(iii) Phone
 -->
 

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
<center><h1>Search customer based on Customer's</h1>

<!-- Below is table with 3 rows each containing a button allowing the admin to search for 
customer details based on ID, Email, Phone
We kept 3 buttons because customer entering the DVD store may not remember his ID all the time 
and so providing his unique email or phone should also search for his details-->

<table width="200" border="0">
  <tbody>  
	<tr><center>
      <td><a href="customer_search_ID.jsp"><input type="button" name="button1" id="button1" value="ID" style="height:40px; width:100px"></a></td>
 		</center></tr> 
   	<tr><center>
      <td><a href="customer_search_EMAIL.jsp"><input type="button" name="button2" id="button2" value="Email" style="height:40px; width:100px" ></a></td>
   </center></tr>
   	<tr><center>
      <td><a href="customer_search_PHONE.jsp"><input type="button" name="button3" id="button3" value="Phone" style="height:40px; width:100px"></a></td>
   </center></tr>
    
    </tbody>
</table>
</center>
</body>
</html>