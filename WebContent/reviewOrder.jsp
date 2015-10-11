<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="film_search.filmBeans"%> <!-- This is imported in order to display all the fields in "customerBeans.java" file -->
<%@page import="java.sql.ResultSet"%>

<html>
<head>
<meta charset="utf-8">
<title>Film_Order_Details</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body bgcolor=#B2E0FC>
<form method=post action=customer_Order_Confirmation_Servlet>

	<% String Customer_id2 = request.getAttribute("custId").toString();%>
<center><h1>Below are the films selected for customer ID : <%=Customer_id2 %></h1></center>
<%
String Customer_id1 = null;
String Title1 = null;
String Year1 = null;
String Language1 = null;
String Price1 = null;
Boolean flag = false;
int total=0;


if(request.getAttribute("custId")!=null) 
{	
	Customer_id1 = request.getAttribute("custId").toString();
	System.out.println(Customer_id1);
	flag =true;%>	
	<center><table border=1 frame=void rules=rows cellspacing="50">
<% 
Object selectedFilms= request.getAttribute("selectedFilms"); 
String[] filmArray=(String[])selectedFilms;
System.out.println(filmArray);
List<filmBeans> filmList=new ArrayList<filmBeans>();
filmBeans fBean=null;
for(int i=0;i<filmArray.length;i++)
{
	System.out.println(filmArray[i]);
	fBean=new filmBeans();
	String[] FilmsSplit=filmArray[i].split("\\|");
	fBean.settitle(FilmsSplit[0]);
	fBean.setrating(FilmsSplit[1]);
	fBean.setrelease_year(Integer.parseInt(FilmsSplit[2]));
	fBean.setrental_duration(Integer.parseInt(FilmsSplit[3]));
	fBean.setprice(Integer.parseInt(FilmsSplit[4]));
	fBean.setreplacement_cost(Integer.parseInt(FilmsSplit[5]));
	fBean.setavailability(Integer.parseInt(FilmsSplit[6]));
	fBean.setlanguage(FilmsSplit[7]);
	filmList.add(fBean);
}
String title2=null;
int release_year2=0;
String language2=null;
int price2=0;
String Error_message=null;

System.out.println("size of filmslist is"+filmList.size()); %>
<tr style="color:#0052CC;">
<td><center><b>Title</b></center></td> 
<td><center><b>Release year</b></center></td> 
<td><center><b>Language</b></center></td> 
<td><center><b>Price</b></center></td> 

</tr>
<% request.setAttribute("selectedFilms",selectedFilms); 
for( int i=0;i<filmList.size();i++)
{ 
	title2=filmList.get(i).gettitle();
	release_year2=filmList.get(i).getrelease_year();
	language2=filmList.get(i).getlanguage();
	price2=filmList.get(i).getprice();
	total=total+price2;
	 %>
	 
	 

<tr>
<td><center><%=title2 %></center><input type ="hidden" name=title value="<%=title2 %>"></td>

<td><center><%=release_year2 %><input type ="hidden" name=release_year value="<%=release_year2 %>"></center></td>
<td><center><%=language2 %></center><input type ="hidden" name=language value="<%=language2 %>"></td>
<td><center><%=price2 %></center></td>
</tr>

<%}%>
<tr>
<td></td>
<td><center>Total Price : <%=total%></center><input type=hidden name="custId" value=<%=Customer_id2 %>>
				</td>
</td>
</tr>
</table></center>		
<%}%>

<center><table width="200" border="0">
  <tbody>  
	<tr>
      <td><input type="submit" name="submit" id="submit" value="Confirm Payment" style="height:40px; width:200px" ></td>
 		
 		</tr>
<%if(request.getAttribute("Error_message")!=null) 

{%>
	<tr>
<td></td>
<td><center>Error : <%=request.getAttribute("Error_message")%></center>
				</td>
</td>
</tr>
	<% }%>		
 		
 </tbody>
 </table></center>
 
 </form>
</body>
</html>