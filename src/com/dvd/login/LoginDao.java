package com.dvd.login;

import java.sql.*;  

public class LoginDao {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try {
	
	System.out.println("Now in logindao");
	Class.forName("com.mysql.jdbc.Driver");
	Connection  con = DriverManager
      .getConnection("jdbc:mysql://localhost:3306?"
          + "user=root&password=password");
System.out.println(name+" "+pass);
  // Statements allow to issue SQL queries to the database
  PreparedStatement st = con.prepareStatement("select * from dvd_rental.admin where user_name=? and password=?");  
st.setString(1,name);  
st.setString(2,pass);
  // Result set get the result of the SQL query
  ResultSet r1=st.executeQuery();

  status=r1.next();
  
  System.out.println(status);

} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  // Setup the connection with the DB
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  	 
return status;  
}  
}
