
<!-- This jsp page displays admin home page. 
It contains 3 buttons for following purpose:
(i) Search for customer details and Update them if its changed
(ii) Add new films details to the database.
(iii) Delete Admin records if admin exited the company before even starting any work.
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body bgcolor=#B2E0FC>
<center><h1>Select one of below operations to be performed</h1>

<!-- Below is a table which contains 3 rows, each row with a button 
letting the admin navigate through the pages based on his choice.
Clicking on a button redirects to a different jsp page in which
desired action is performed.

Button1 - for Searching Customer Details
Button2 - for Adding new film details 
Button3 - for Deleting Admin from database.
-->

<table width="200" border="0">
  <tbody>  
	<tr><center>
      <td><a href="customer_search_type.jsp"><input type="button" name="button1" id="button1" value="Search Customer Details" style="height:50px; width:200px"></a></td>
 		</center></tr> 
   	<tr><center>
      <td><a href="film_add.jsp"><input type="button" name="button2" id="button2" value="Add new films" style="height:50px; width:200px" ></a></td>
   </center></tr>
   <tr><center>
      <td><a href="delete_admin.jsp"><input type="button" name="button3" id="button3" value="Delete Admin" style="height:50px; width:200px" ></a></td>
   </center></tr>
    </tbody>
</table>
</center>
</body>
</html>