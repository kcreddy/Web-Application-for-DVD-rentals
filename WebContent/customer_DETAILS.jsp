
<!-- 
This jsp page is the output of jsp pages which were searching for customer details 
either based on ID or Email or Phone.
It prints Customer ID, First Name, Last Name, Email, Phone of a customer whose details were searched.
3 buttons provided below the search result lets the admin to perform subsequent operations:
(i) Search film details based on customer's input
(ii) Update customer personal details
(iii) Update customer address - This is yet to be implemented
-->

<!-- Importing required page/packages for displaying customer details -->

<%@page import="com.dvd.customer.customerBeans"%> <!-- This is imported in order to display all the fields in "customerBeans.java" file -->
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.dvd.customer.customer_search"%><!-- This is imported because we are calling the functions from "customer_search.java"
file which are used to validate customer_id, email, phone separately -->

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<html>
<head>
<meta charset="utf-8">
<title>Customer_Details</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body bgcolor=#B2E0FC>
<center><h1>Below are the customer details</h1></center>
<%
String Customer_id1 = null;
String Customer_id2 = null;
String Email1=null;
String Phone1 = null;
Boolean flag =false;


if(request.getAttribute("Customer_id1")!=null) /*This will get the Customer_id1 from servlet being called ie. customer_search*/
{	
	Customer_id1 = request.getAttribute("Customer_id1").toString();
	System.out.println("Customer_id in customer_details.jsp"+Customer_id1);
	flag =true;%>	
	<center><table>
<% List<customerBeans> customerList=new ArrayList<customerBeans>();
 customerList=customer_search.validatecustomer_id(Customer_id1); 
 
 
Customer_id2=null;
String first_name2=null;
String last_name2=null;
String email2=null;
String phone2=null;
String dvd_on_hold2 = null;
String dvd_barcode2=null;
String film_id2=null;
String title2=null;
String rented_date2 = null;

System.out.println("loop not entered still in search.jsp");
System.out.println("size of customerlist is"+customerList.size()); %>
<tr style="color:#0052CC;">
<td><center><b>Customer Id</b></center></td> 
<td><center><b>First Name</b></center></td> 
<td><center><b>Last Name</b></center></td> 
<td><center><b>Email</b></center></td> 
<td><center><b>Phone</b></center></td> 

</tr>
<% for( int i=0;i<1;i++){ /*This prints the search results got from the result set one by one in each row*/
		System.out.println("Entered for loop in search.jsp");
	 Customer_id2=customerList.get(i).getcustomer_id();
	 first_name2=customerList.get(i).getfirst_name();
	 last_name2=customerList.get(i).getlast_name();
	 email2=customerList.get(i).getemail();
	 phone2=customerList.get(i).getphone();
	 dvd_barcode2 = customerList.get(i).getdvd_barcode();
	 film_id2 = customerList.get(i).getfilm_id();
	 title2 = customerList.get(i).gettitle();
	 rented_date2 = customerList.get(i).getrented_date();
	 %>
<tr></tr>
<tr>
<td><center><%=Customer_id2 %></center></td>
<td><center><%=first_name2 %></center></td>
<td><center><%=last_name2 %></center></td>
<td><center><%=email2 %></center></td>
<td><center><%=phone2 %></center></td>

</tr>

<%}%>

<tr></tr>	
<tr style="color:#0052CC;">

<td><center><b>Dvd_Barcode</b></center></td>
<td><center><b>Film_id</b></center></td> 
<td><center><b>Title</b></center></td> 
<td><center><b>rented_date</b></center></td> 

</tr>
<% for( int i=0;i<customerList.size();i++){ /*This prints the search results got from the result set one by one in each row*/
		System.out.println("Entered for loop in search.jsp");
	 Customer_id2=customerList.get(i).getcustomer_id();
	 first_name2=customerList.get(i).getfirst_name();
	 last_name2=customerList.get(i).getlast_name();
	 email2=customerList.get(i).getemail();
	 phone2=customerList.get(i).getphone();
	 dvd_barcode2 = customerList.get(i).getdvd_barcode();
	 film_id2 = customerList.get(i).getfilm_id();
	 title2 = customerList.get(i).gettitle();
	 rented_date2 = customerList.get(i).getrented_date();
	 %>

<% if(dvd_barcode2!=null){
%>
<tr>

<td><center><%=dvd_barcode2 %></center></td>
<td><center><%=film_id2 %></center></td>
<td><center><%=title2 %></center></td>
<td><center><%=rented_date2 %></center></td>
</tr>
<%} %>

<% if(dvd_barcode2==null)
{%>
<tr>

<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
</tr>
	<%}%>
<%}%>
</table></center>	
	
<%}%>


<% if(request.getAttribute("Email1")!=null)
{
	Email1 = request.getAttribute("Email1").toString();
	flag =true;%>	
	<center><table>
<% List<customerBeans> customerList=new ArrayList<customerBeans>();
 customerList=customer_search.validateemail(Email1); 
Customer_id2=null;
String first_name2=null;
String last_name2=null;
String email2=null;
String phone2=null;
String dvd_on_hold2 = null;
String dvd_barcode2=null;
String film_id2=null;
String title2=null;
String rented_date2 = null;
System.out.println("loop not entered still in search.jsp");
System.out.println("size of customerlist is"+customerList.size()); %>

<tr style="color:#0052CC;">
<td><center><b>Customer Id</b></center></td> 
<td><center><b>First Name</b></center></td> 
<td><center><b>Last Name</b></center></td> 
<td><center><b>Email</b></center></td> 
<td><center><b>Phone</b></center></td> 


</tr>
<% for( int i=0;i<1;i++){
		System.out.println("Entered for loop in search.jsp");
	 Customer_id2=customerList.get(i).getcustomer_id();
	 first_name2=customerList.get(i).getfirst_name();
	 last_name2=customerList.get(i).getlast_name();
	 email2=customerList.get(i).getemail();
	 phone2=customerList.get(i).getphone();
	 dvd_barcode2 = customerList.get(i).getdvd_barcode();
	 film_id2 = customerList.get(i).getfilm_id();
	 title2 = customerList.get(i).gettitle();
	 rented_date2 = customerList.get(i).getrented_date();
	 %>

<tr>
<td><center><%=Customer_id2 %></center></td>
<td><center><%=first_name2 %></center></td>
<td><center><%=last_name2 %></center></td>
<td><center><%=email2 %></center></td>
<td><center><%=phone2 %></center></td>

</tr>

<%}%>
<tr></tr>
<tr style="color:#0052CC;">

<td><center><b>Dvd_Barcode</b></center></td>
<td><center><b>Film_id</b></center></td> 
<td><center><b>Title</b></center></td> 
<td><center><b>rented_date</b></center></td> 

</tr>
<% for( int i=0;i<customerList.size();i++){
		System.out.println("Entered for loop in search.jsp");
	 Customer_id2=customerList.get(i).getcustomer_id();
	 first_name2=customerList.get(i).getfirst_name();
	 last_name2=customerList.get(i).getlast_name();
	 email2=customerList.get(i).getemail();
	 phone2=customerList.get(i).getphone();
	 dvd_barcode2 = customerList.get(i).getdvd_barcode();
	 film_id2 = customerList.get(i).getfilm_id();
	 title2 = customerList.get(i).gettitle();
	 rented_date2 = customerList.get(i).getrented_date();
	 %>

<% if(dvd_barcode2!=null){
%>
<tr>

<td><center><%=dvd_barcode2 %></center></td>
<td><center><%=film_id2 %></center></td>
<td><center><%=title2 %></center></td>
<td><center><%=rented_date2 %></center></td>
</tr>
<%} %>

<% if(dvd_barcode2==null)
{%>
<tr>

<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
</tr>
	<%}%>

<%}%>

</table></center>	
<%}%>
	
	
	
	
<%if(request.getAttribute("Phone1")!=null)
{
	Phone1 = request.getAttribute("Phone1").toString();
	flag =true;%>	
	<center><table>
<% List<customerBeans> customerList=new ArrayList<customerBeans>();
 customerList=customer_search.validatephone(Phone1); 
Customer_id2=null;
String first_name2=null;
String last_name2=null;
String email2=null;
String phone2=null;
String dvd_on_hold2 = null;
String dvd_barcode2=null;
String film_id2=null;
String title2=null;
String rented_date2 = null;
System.out.println("loop not entered still in search.jsp");
System.out.println("size of customerlist is"+customerList.size()); %>

<tr style="color:#0052CC;">
<td><center><b>Customer Id</b></center></td> 
<td><center><b>First Name</b></center></td> 
<td><center><b>Last Name</b></center></td> 
<td><center><b>Email</b></center></td> 
<td><center><b>Phone</b></center></td> </tr>


</tr>
<% for( int i=0;i<1;i++){
		System.out.println("Entered for loop in search.jsp");
	 Customer_id2=customerList.get(i).getcustomer_id();
	 first_name2=customerList.get(i).getfirst_name();
	 last_name2=customerList.get(i).getlast_name();
	 email2=customerList.get(i).getemail();
	 phone2=customerList.get(i).getphone();
	 dvd_barcode2 = customerList.get(i).getdvd_barcode();
	 film_id2 = customerList.get(i).getfilm_id();
	 title2 = customerList.get(i).gettitle();
	 rented_date2 = customerList.get(i).getrented_date();
	 %>

<tr>
<td><center><%=Customer_id2 %></center></td>
<td><center><%=first_name2 %></center></td>
<td><center><%=last_name2 %></center></td>
<td><center><%=email2 %></center></td>
<td><center><%=phone2 %></center></td>

</tr>

<%}%>
<tr></tr>

<tr style="color:#0052CC;">
<td><center><b>Dvd_Barcode</b></center></td>
<td><center><b>Film_id</b></center></td> 
<td><center><b>Title</b></center></td> 
<td><center><b>rented_date</b></center></td> 

</tr>
<% for( int i=0;i<customerList.size();i++){
		System.out.println("Entered for loop in search.jsp");
	 Customer_id2=customerList.get(i).getcustomer_id();
	 first_name2=customerList.get(i).getfirst_name();
	 last_name2=customerList.get(i).getlast_name();
	 email2=customerList.get(i).getemail();
	 phone2=customerList.get(i).getphone();
	 dvd_barcode2 = customerList.get(i).getdvd_barcode();
	 film_id2 = customerList.get(i).getfilm_id();
	 title2 = customerList.get(i).gettitle();
	 rented_date2 = customerList.get(i).getrented_date();
	 %>

<% if(dvd_barcode2!=null){
%>
<tr>

<td><center><%=dvd_barcode2 %></center></td>
<td><center><%=film_id2 %></center></td>
<td><center><%=title2 %></center></td>
<td><center><%=rented_date2 %></center></td>
</tr>
<%} %>

<% if(dvd_barcode2==null)
{%>
<tr>

<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
<td><center><%="-" %></center></td>
</tr>
	<%}%>

<%}%>
</table></center>		
<%}%>	


<center><table width="200" border="0">
  <tbody>  
	<tr>
      <td><a href=Search.jsp?custId=<%=Customer_id2%> name=custId><input type="button" name="film_search_btn" id="film_search_btn" value="Search for films" style="height:50px; width:250px"></a></td>
 		
 		</tr>
 </tbody>
 </table></center>
 
 <center><table width="200" border="0">
  <tbody>  
	<tr>
      <td><a href="update_personal.jsp?custId=<%=Customer_id2%>" name=custId><input type="button" name="update_customer_personal" id="update_customer_personal" value="Update Customer Personal Details" style="height:50px; width:250px"></a></td>
 		
 		</tr>
 </tbody>
 </table></center>
 
  <center><table width="200" border="0">
  <tbody>  
	<tr>
      <td>
      <a href="return_DVD.jsp?custId=<%=Customer_id2%>" name=custId><input type="button" name="return_dvd" id="return_dvd" value="Return DVD" style="height:50px; width:250px"></a></td>
 		
 		</tr>
 </tbody>
 <tr>
 
 </tr>
 </table></center>
 
</body>
</html>
