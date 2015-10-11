<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>Add new Film here</title>
<meta name="description" content="hi ">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body bgcolor=#B2E0FC>
<form method="post" action="film_add_servlet">
<center><table>
<tbody>
<%
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
String success2="Added film details successfully";

%>

	<tr><center>
	  <td style="color:#0052CC;"><b>Film Title:</b></td>
	  <td><input type="text" name="Film_title" id="Film_title" required></td>
 		</center></tr>
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Release Year:</b></td>
	  <td><input type="number" name="Release_year" id="Release_year" required></td>
 		</center></tr>
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Rating:</b></td>
	  <td><input type="text" name="Rating" id="Rating" required></td>
 		</center></tr>
 
 	<tr><center>
	  <td style="color:#0052CC;"><b>Price:</b></td>
	  <td><input type="number" name="Price" id="Price" required></td>
 		</center></tr>
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Length:</b></td>
	  <td><input type="number" name="Length" id="Length" required></td>
 		</center></tr>
 
 	<tr><center>
	  <td style="color:#0052CC;"><b>Rental Duration:</b></td>
	  <td><input type="number" name="Rental_duration" id="Rental_duration" required></td>
 		</center></tr>
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Replacement cost:</b></td>
	  <td><input type="number" name="Replacement_cost" id="Replacement_cost" required></td>
 		</center></tr>	
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Language</b></td>
     <td> <select name="Language"  required>
  <option value=""></option>
  <option value="English">English</option>
  <option value="Italian">Italian</option>
  <option value="Japanese">Japanese</option>
  <option value="Mandarin">Mandarin</option>
  <option value="French">French</option>
  <option value="German">German</option>
  <option value="Hindi">Hindi</option>
 
  </select>
  </td>
 		</center></tr>	
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Category</b></td>
      <td><select name="Category"  required>
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
</td>
 		</center></tr>
 		
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Actor First Name:</b></td>
	  <td><input type="text" name="Actor_fn" id="Actor_fn"  required></td>
	  <td style="color:#0052CC;"><b>Actor Last Name:</b></td>
	  <td><input type="text" name="Actor_ln" id="Actor_ln"  required></td>
 		</center></tr>
    		
 			
  	<tr><center>
	  <td style="color:#0052CC;"><b>DVD Barcode:</b></td>
	  <td><input type="number" name="Dvd_barcode" id="Dvd_barcode"></td>
 		</center></tr>
 		
 	<tr><center>
	  <td style="color:#0052CC;"><b>Number of Copies:</b></td>
	  <td><input type="number" name="Copies" id="Copies" required></td>
 		</center></tr>
 		
 </tbody></table></center>
 <br>
</br>
 	<tr>
      <td></td>
      <td><center><input type="submit" value="submit" style="height:40px; width:150px"></center></td>
    </tr> 
   <br>
    
   <tr>
      <td><center><a href="admin_film_search.jsp"><input type="button" name="button1" id="button1" value="Search for films" style="height:40px; width:150px" ></a></center></td>
   </tr>  
   <% 
   if(request.getAttribute("success1")!=null)
   {
   if (success1.equals(success2)){%>
	   <center><b><%=success2 %></b></center>
	  <%} %>
	  	  <%} %>
         <%if(errorMsg!=null){
    	  %>
    	  <tr style="color:red;"><center>
    	  <td><b><%=errorMsg %></b></td>
    	  </center></tr>  
    	  
    	  <%
      }
      %>  
</form>
</body>
</html>