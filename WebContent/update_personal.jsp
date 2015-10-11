<%@page import="com.dvd.customer.customer_search"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dvd.customer.customerBeans"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updateCustomer</title>
</head>
<body bgcolor=#B2E0FC>
<form method="post" action="Update_personal_Servlet">

<%
String custid=null;
String emailError=null;
String emailError1=null;
String first_nameError=null;
String last_nameError=null;
String phoneError=null;
String phoneError1=null;
String updateError=null;
String update=null;
if(request.getAttribute("emailError")!=null){
	emailError=request.getAttribute("emailError").toString();
	}
if(request.getAttribute("emailError1")!=null){
	emailError=request.getAttribute("emailError1").toString();
	}
	if(request.getAttribute("first_nameError")!=null){
		first_nameError=request.getAttribute("first_nameError").toString();
		}
	if(request.getAttribute("updated")!=null){
		update=request.getAttribute("updated").toString();
		}
	if(request.getAttribute("phoneError")!=null){
		phoneError=request.getAttribute("phoneError").toString();
		}
	if(request.getAttribute("phoneError1")!=null){
		phoneError1=request.getAttribute("phoneError1").toString();
		}
	if(request.getAttribute("last_nameError")!=null){
		last_nameError=request.getAttribute("last_nameError").toString();
		}
	
	if(request.getAttribute("updateError")!=null){
		updateError=request.getAttribute("updateError").toString();
		} %>

<%

custid=request.getParameter("custId");

%>
<center><h1>Update Details for Customer ID: <%=custid %></h1></center>

<center><h2>Personal Details</h2></center>

<%
if(update!=null){
	%>
	<center><h3><%=update %></h3></center>
	<%
}%>

	<%

List<customerBeans> customerDetails=new ArrayList<customerBeans>();

customerDetails=customer_search.validatecustomer_id(custid);

int size=customerDetails.size();
String first_name=customerDetails.get(0).getfirst_name();
String last_name=customerDetails.get(0).getlast_name();
String email=customerDetails.get(0).getemail();
int phone=Integer.parseInt(customerDetails.get(0).getphone());
System.out.println("Customer Id in updatePersonalDetails :"+custid);
	
	%>

	<center><table >
	
	<tr >
	<td style="color:green;"><b>Details</b></td>
	<td style="color:green;"><b>PresentValue</b></td>
	<td style="color:green;"><b>Update Value</b></td>
	</tr>
	<tr>
	<td style="color:#0052CC;"><b>First Name</b></td>
	<td><%=first_name %></td>
	<td ><input type="text" name=first_nameUpdate><input type=hidden name="custId" value=<%=custid %>></td>
	<%if(updateError!=null){
		%>
		<td><%=updateError %></td>
			<%
	}
		%>

	</tr>
	<tr>
	<td style="color:#0052CC;"><b>Last Name</b></td>
	<td><%=last_name %></td>
	<td ><input type="text" name=last_nameUpdate></td>
	</tr>
	<tr>
	<td style="color:#0052CC;"><b>Email  address</b></td>
	<td><%=email %></td>
	<td ><input type="email" name=emailUpdate></td>
		<%if(emailError!=null){
		%>
		<td style="color:red;"><b><%=emailError %></b></td>
		<%
	}
		%>
		<%if(emailError1!=null){
		%>
		<td style="color:red;"><b><%=emailError1 %></b></td>
		<%
	}
		%>
	
	</tr>
	<tr>
	<td style="color:#0052CC;"><b>Phone</b></td>
	<td><%=phone %></td>
	<td ><input type="number" name=phoneUpdate></td>
		<%if(phoneError!=null){
		%>
		<td style="color:red;"><td><%=phoneError %></td>
		<%
	}
		%>
		
		<%if(phoneError1!=null){
		%>
		<td style="color:red;"><td><b><%=phoneError1 %></b></td>
		<%
	}
		%>
	
	</tr>
	<tr></tr>
	<tr>
	<td></td>
	<td></td>
<td><input type="submit" value="submit" style="height:40px; width:175px"></td>

</tr>
	
	</table></center>

</form>
</body>
</html>