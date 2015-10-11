<%@page import="film_search.filmBeans"%>
<%@page import="java.sql.ResultSet"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="film_search.film_search"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<html>
<head>
<meta charset="utf-8">
<title>Search for film</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body bgcolor=#B2E0FC>
<form method="post" action="film_search_servlet">

<%
String custid=null;
String Title1 = null;
String Category1=null;
String Language1 = null;
String Year1 = null;
String Actor1 =null;
Boolean flag =false;
String null_error=null;
String title_error=null;
String Actor_error=null;
String NoSearch=null;


if(request.getAttribute("Title1")!=null)
{
	Title1 = request.getAttribute("Title1").toString();
	flag =true;
		}
if(request.getAttribute("Category1")!=null)
{
	Category1 = request.getAttribute("Category1").toString();
	flag =true;
		}
if(request.getAttribute("Language1")!=null)
{
	Language1 = request.getAttribute("Language1").toString();
	flag =true;		
}
if(request.getAttribute("Year1")!=null)
{
	Year1 = request.getAttribute("Year1").toString();
	flag =true;		
}
if(request.getAttribute("Actor1")!=null)
{
	Actor1 = request.getAttribute("Actor1").toString();
		flag =true;
	}



%>

<%

if(request.getParameter("custId")!=null)
{
	custid=request.getParameter("custId").toString();
	System.out.println("Customer_id in get parameter Search.jsp is :"+custid);
	}

if(request.getAttribute("custId")!=null)
{
	custid=request.getAttribute("custId").toString();
	System.out.println("Customer_id in get Attribute Search.jsp is :"+custid);
	}


System.out.println("Customer_id in sEARCH.JSP :"+request.getParameter("custId"));

%>
<center><h1>Search for film</h1>

<table width="1200" border="0">
  <tbody>
  
    <tr>
      <td style="color:#0052CC;"><b>Title 
      <input type="text" name="Title" id="Title"></b></td>
      <td style="color:#0052CC;"><b>Category
      <select name="Category">
  <option value=""></option>
  <option value="Action">Action</option>
  <option value="Animation">Animation</option>
  <option value="Children">Children</option>
  <option value="Classics">Classics</option>
  <option value="Comedy">Comedy</option>
  <option value="Documentary">Documentary</option>
  <option value="Drama">Drama</option>
  <option value="Family">Family</option>
  <option value="Foreign">Foreign</option>
  <option value="Games">Games</option>
  <option value="Horror">Horror</option>
  <option value="Music">Music</option>
  <option value="Devotional">Devotional</option>
  <option value="Sci-Fi">Sci-Fi</option>
  <option value="Sports">Sports</option>
  <option value="Travel">Travel</option>
</select>
</b></td>
<td style="color:#0052CC;"><b>Language
      <select name="Language">
  <option value=""></option>
  <option value="English">English</option>
  <option value="Italian">Italian</option>
  <option value="Japanese">Japanese</option>
  <option value="Mandarin">Mandarin</option>
  <option value="French">French</option>
  <option value="German">German</option>
  <option value="Hindi">Hindi</option>
  </select>
  </b></td>
      <td style="color:#0052CC;"><b><div align="right">Year
          <select name="Year">
            <option value=""></option>
            <option value="2003">2003</option>
            <option value="2004">2004</option>
            <option value="2005">2005</option>
            <option value="2006">2006</option>
            <option value="2007">2007</option>
            <option value="2008">2008</option>
            <option value="2009">2009</option>
            <option value="2014">2014</option>
            <option value="2015">2015</option>
          </select>
      </div>
      </b></td>  
  <td style="color:#0052CC;"><b>
    <div align="right">Actor
  <input type="text" name="Actor" id="Actor">
  <input type="hidden" name="custId" value=<%=custid %>></td>
    </div></b></td>
    </tr>
<br>
</br>      
<tr>
       <td>
       </td>
       <td>
       </td>
      <td><input type="submit" name="submit" id="submit" value="Start Searching for films" style="height:40px; width:200px" ></td>
   </tr> 
   

	   
  </tbody>
</table>
</form>

<form method=post action=customer_film_checkbox>
<table border=1 frame=void rules=rows cellspacing="50" >
<tr style="color:red;"><b> <%if (request.getAttribute("title_error")!=null)
	{
	title_error=request.getAttribute("title_error").toString();%>
	Error:<%=title_error %>
	<% flag=false;}%>
	</b></tr>
	
<tr style="color:red;"><b> <%if (request.getAttribute("Actor_error")!=null)
	{
	Actor_error=request.getAttribute("Actor_error").toString();%>
	Error:<%=Actor_error %>
	<% flag=false;}%>
	</b></tr>
<tr style="color:red;"><b> <%if (request.getAttribute("NoSearch")!=null)
	{
	NoSearch=request.getAttribute("NoSearch").toString();%>
	Error:<%=NoSearch %>
	<% flag=false;}%>
	</b></tr>

<% 
if(flag==true)
{
if(Actor1!=null && Category1!=null){
List<filmBeans> filmList=new ArrayList<filmBeans>();
 filmList=film_search.validate1(Title1,Year1, Actor1, Category1, Language1); 
String title2=null;
String rating2=null;
String custId=null;
int release_year2=0;
int rental_duration2=0;
int price2=0;
int replacement_cost2=0;
int availability2=0;
String language2=null;
String category2=null;
String actor2=null;
System.out.println("loop not entered still in search.jsp and customer_id is"+custid);
System.out.println("size of filmlist is"+filmList.size()); %>
<tr>
<td><center><b>Title</b></center></td> 
<td><center><b>Rating</b></center></td> 
<td><center><b>Year</b></center></td> 
<td><center><b>Rental Duration</b></center></td> 
<td><center><b>Price</b></center></td> 
<td><center><b>Replacement Cost</b></center></td>
<td><center><b>Availability</b></center></td>
<td><center><b>Language</b></center></td>
<td><center><b>category</b></center></td>
<td><center><b>actor</b></center></td>
<td><center><b>Select Films</b></center></td>

</tr>
<% for( int i=0;i<filmList.size();i++){
		//System.out.println("Entered for loop in search.jsp");
	 title2=filmList.get(i).gettitle();
	 rating2=filmList.get(i).getrating();
	 release_year2=filmList.get(i).getrelease_year();
	 rental_duration2=filmList.get(i).getrental_duration();
	 price2=filmList.get(i).getprice();
	 replacement_cost2=filmList.get(i).getreplacement_cost();
	 availability2=filmList.get(i).getavailability();
	 language2=filmList.get(i).getlanguage();
	 category2=filmList.get(i).getcategory();
	 actor2=filmList.get(i).getactor();
	 %>

<tr>
<td><center><%=title2 %></center></td>
<td><center><%=rating2 %></center></td>
<td><center><%=release_year2 %></center></td>
<td><center><%=rental_duration2 %></center></td>
<td><center><%=price2 %></center></td>
<td><center><%=replacement_cost2 %></center></td>
<td><center><%=availability2 %></center></td>
<td><center><%=language2 %></center></td>
<td><center><%=category2 %></center></td>
<td><center><%=actor2 %></center></td>
<% if (availability2 >0){ %>
<td><center><input type = checkbox name =selectedFilms
			value ="<%=title2 +  "|" +rating2 + "|" + release_year2 + "|" +
			rental_duration2 + "|" + price2 + "|" + replacement_cost2 + "|" + availability2 + "|" + language2 %>">
			<input type="hidden" name="custId" value=<%=custid %>></td>

</center>
</td>
</tr>

<%}%>
<%}%>
<tr></tr>
<tr>
   <td>
   </td>
   <td>
   </td>
      <td>
   </td>
   <td><input type="submit" name="submit" id="submit" value="Confirm Film Selection" style="height:40px; width:200px" ></td>
   </tr>
<%}%>
<%}%>


<% 
if(flag==true)
{
if(Actor1==null && Category1!=null){
List<filmBeans> filmList=new ArrayList<filmBeans>();
 filmList=film_search.validate2(Title1,Year1, Actor1, Category1, Language1); 
String title2=null;
String rating2=null;
String custId=null;
int release_year2=0;
int rental_duration2=0;
int price2=0;
int replacement_cost2=0;
int availability2=0;
String language2=null;
String category2=null;
//String actor2=null;
System.out.println("loop not entered still in search.jsp and customer_id is"+custid);
System.out.println("size of filmlist is"+filmList.size()); %>
<tr>
<td><center><b>Title</b></center></td> 
<td><center><b>Rating</b></center></td> 
<td><center><b>Year</b></center></td> 
<td><center><b>Rental Duration</b></center></td> 
<td><center><b>Price</b></center></td> 
<td><center><b>Replacement Cost</b></center></td>
<td><center><b>Availability</b></center></td>
<td><center><b>Language</b></center></td>
<td><center><b>category</b></center></td>

<td><center><b>Select Films</b></center></td>

</tr>
<% for( int i=0;i<filmList.size();i++){
		//System.out.println("Entered for loop in search.jsp");
	 title2=filmList.get(i).gettitle();
	 rating2=filmList.get(i).getrating();
	 release_year2=filmList.get(i).getrelease_year();
	 rental_duration2=filmList.get(i).getrental_duration();
	 price2=filmList.get(i).getprice();
	 replacement_cost2=filmList.get(i).getreplacement_cost();
	 availability2=filmList.get(i).getavailability();
	 language2=filmList.get(i).getlanguage();
	 category2=filmList.get(i).getcategory();
	 
	 %>

<tr>
<td><center><%=title2 %></center></td>
<td><center><%=rating2 %></center></td>
<td><center><%=release_year2 %></center></td>
<td><center><%=rental_duration2 %></center></td>
<td><center><%=price2 %></center></td>
<td><center><%=replacement_cost2 %></center></td>
<td><center><%=availability2 %></center></td>
<td><center><%=language2 %></center></td>
<td><center><%=category2 %></center></td>
<% if (availability2 >0){ %>

<td><center><input type = checkbox name =selectedFilms
			value ="<%=title2 +  "|" +rating2 + "|" + release_year2 + "|" +
			rental_duration2 + "|" + price2 + "|" + replacement_cost2 + "|" + availability2 + "|" + language2 %>">
			<input type="hidden" name="custId" value=<%=custid %>></td>

</center>
</td>
</tr>

<%}%>
<%}%>
<tr></tr>
<tr>
   <td>
   </td>
   <td>
   </td>
      <td>
   </td>
   <td><input type="submit" name="submit" id="submit" value="Confirm Film Selection" style="height:40px; width:200px" ></td>
   </tr>
<%}%>
<%}%>

<tr style="color:red;"><b> <%if (request.getAttribute("null_error")!=null)
	{
	null_error=request.getAttribute("null_error").toString();%>
	Error:<%=null_error %>
	<% }%>
	</b></tr>
	


<% 
if(flag==true)
{
if(Actor1!=null && Category1==null){
List<filmBeans> filmList=new ArrayList<filmBeans>();
 filmList=film_search.validate3(Title1,Year1, Actor1, Category1, Language1); 
String title2=null;
String rating2=null;
String custId=null;
int release_year2=0;
int rental_duration2=0;
int price2=0;
int replacement_cost2=0;
int availability2=0;
String language2=null;
//String category2=null;
String actor2=null;
System.out.println("loop not entered still in search.jsp and customer_id is"+custid);
System.out.println("size of filmlist is"+filmList.size()); %>
<tr>
<td><center><b>Title</b></center></td> 
<td><center><b>Rating</b></center></td> 
<td><center><b>Year</b></center></td> 
<td><center><b>Rental Duration</b></center></td> 
<td><center><b>Price</b></center></td> 
<td><center><b>Replacement Cost</b></center></td>
<td><center><b>Availability</b></center></td>
<td><center><b>Language</b></center></td>

<td><center><b>actor</b></center></td>
<td><center><b>Select Films</b></center></td>

</tr>
<% for( int i=0;i<filmList.size();i++){
		//System.out.println("Entered for loop in search.jsp");
	 title2=filmList.get(i).gettitle();
	 rating2=filmList.get(i).getrating();
	 release_year2=filmList.get(i).getrelease_year();
	 rental_duration2=filmList.get(i).getrental_duration();
	 price2=filmList.get(i).getprice();
	 replacement_cost2=filmList.get(i).getreplacement_cost();
	 availability2=filmList.get(i).getavailability();
	 language2=filmList.get(i).getlanguage();
	 
	 actor2=filmList.get(i).getactor();
	 %>

<tr>

<td><center><%=title2 %></center></td>
<td><center><%=rating2 %></center></td>
<td><center><%=release_year2 %></center></td>
<td><center><%=rental_duration2 %></center></td>
<td><center><%=price2 %></center></td>
<td><center><%=replacement_cost2 %></center></td>
<td><center><%=availability2 %></center></td>
<td><center><%=language2 %></center></td>

<td><center><%=actor2 %></center></td>
<% if (availability2 >0){ %>
<td><center><input type = checkbox name =selectedFilms
			value ="<%=title2 +  "|" +rating2 + "|" + release_year2 + "|" +
			rental_duration2 + "|" + price2 + "|" + replacement_cost2 + "|" + availability2 + "|" + language2%>">
			<input type="hidden" name="custId" value=<%=custid %>></td>

</center>
</td>
</tr>

<%}%>
<%}%>
<tr></tr>
<tr>
   <td>
   </td>
   <td>
   </td>
      <td>
   </td>
   <td><input type="submit" name="submit" id="submit" value="Confirm Film Selection" style="height:40px; width:200px" ></td>
   </tr>
<%}%>
<%}%>

<% 
if(flag==true)
{
if(Actor1==null && Category1==null){
List<filmBeans> filmList=new ArrayList<filmBeans>();
 filmList=film_search.validate(Title1,Year1, Actor1, Category1, Language1); 
String title2=null;
String rating2=null;
String custId=null;
int release_year2=0;
int rental_duration2=0;
int price2=0;
int replacement_cost2=0;
int availability2=0;
String language2=null;
System.out.println("loop not entered still in search.jsp and customer_id is"+custid);
System.out.println("size of filmlist is"+filmList.size()); %>
<tr>
<td><center><b>Title</b></center></td> 
<td><center><b>Rating</b></center></td> 
<td><center><b>Year</b></center></td> 
<td><center><b>Rental Duration</b></center></td> 
<td><center><b>Price</b></center></td> 
<td><center><b>Replacement Cost</b></center></td>
<td><center><b>Availability</b></center></td>
<td><center><b>Language</b></center></td>
<td><center><b>Select Films</b></center></td>

</tr>
<% for( int i=0;i<filmList.size();i++){
		//System.out.println("Entered for loop in search.jsp");
	 title2=filmList.get(i).gettitle();
	 rating2=filmList.get(i).getrating();
	 release_year2=filmList.get(i).getrelease_year();
	 rental_duration2=filmList.get(i).getrental_duration();
	 price2=filmList.get(i).getprice();
	 replacement_cost2=filmList.get(i).getreplacement_cost();
	 availability2=filmList.get(i).getavailability();
	 language2=filmList.get(i).getlanguage();
	 %>

<tr>
<td><center><%=title2 %></center></td>
<td><center><%=rating2 %></center></td>
<td><center><%=release_year2 %></center></td>
<td><center><%=rental_duration2 %></center></td>
<td><center><%=price2 %></center></td>
<td><center><%=replacement_cost2 %></center></td>
<td><center><%=availability2 %></center></td>
<td><center><%=language2 %></center></td>
<% if (availability2 >0){ %>
<td><center><input type = checkbox name =selectedFilms
			value ="<%=title2 +  "|" +rating2 + "|" + release_year2 + "|" +
			rental_duration2 + "|" + price2 + "|" + replacement_cost2 + "|" + availability2 + "|" + language2 %>">
			<input type="hidden" name="custId" value=<%=custid %>></td>

</center>
</td>
</tr>

<%}%>
<%}%>
<tr></tr>
<tr>
   <td>
   </td>
   <td>
   </td>
      <td>
   </td>
   <td><input type="submit" name="submit" id="submit" value="Confirm Film Selection" style="height:40px; width:200px" ></td>
   </tr>
<%}%>
<%}%>
 
</table>
</center>
</form>
</body>
</html>
