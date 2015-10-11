<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=#B2E0FC>
<form method=post action=customer_return_dvd_servlet>
<center><h1>Please enter DVD barcode to return customer DVD</h1></center>

<% String custId =request.getParameter("custId");
%>

<center><table>
<tbody>

	<tr><center>
	  <td style="color:#0052CC;"><b>DVD Barcode:</b></td>
	  <td><input type="text" name="dvd_barcode" id="dvd_barcode" required><input type=hidden name="custId" value=<%=custId %>></td>
 		</center>
 		 <%if(request.getAttribute("Error_message")!=null) 
		{%>		
		<td style="color:red;"><center><b> <%=request.getAttribute("Error_message")%></b></center></td>
		
		<% }%>
 		</tr>
 		
 		<tr>
 		<td></td>
      <td><input type="submit" name="submit" id="submit" value="Confirm Submission" style="height:40px; width:175px" ></td>
 		</tr>	
 		

 		
</tbody>
</table>
</center>
</form>
</body>
</html>