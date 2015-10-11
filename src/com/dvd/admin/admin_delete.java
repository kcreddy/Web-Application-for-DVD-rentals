
/*In this file, a function  "validate" is defined which interacts with the
 * database and fetches the details or does the specified action
 *  */
package com.dvd.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class admin_delete {

	public static boolean validate(String s1,String s2){  
		boolean status=false;  
		boolean status1=false;
		boolean status2=true;
		try {
			
			System.out.println("Now in admin_delete_java");
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con = DriverManager
			.getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password"); /*This connects to database*/
		System.out.println(s1+" "+s2);
		  // Statements allow to issue SQL queries to the database
		
		 PreparedStatement st = con.prepareStatement("select * from admin where first_name = ? and last_name = ?");  
			st.setString(1,s1);  
			st.setString(2,s2);
			 st.execute("use dvd_rental");
			  // Result set get the result of the SQL query
			 //st.execute();
			 ResultSet r1=st.executeQuery();
			 while(r1.next()){ status1=true;}
		 PreparedStatement st3 = con.prepareStatement("select customer_id from customer where admin_id = (select admin_id from admin where first_name =? and last_name =?)");  
			st3.setString(1,s1);  
			st3.setString(2,s2);
			 st3.execute("use dvd_rental");
			 System.out.println("Query id "+st3);
			 
			  // Result set get the result of the SQL query
			 //st.execute();
			 ResultSet r2=st.executeQuery();	 
			 
			 
			
			 while(r2.next()){
				 if(r2.getString(1)==null){
				 status2=false;}}
			 
			 System.out.println("Status1 :"+status1);
			 System.out.println("Status2 :"+status2);
		if(status1==true && status2==true)
		{
		  PreparedStatement st1 = con.prepareStatement("delete from admin where first_name like ? and last_name like ?");  
		st1.setString(1,"%"+s1+"%");  
		st1.setString(2,"%"+s2+"%");
		 st1.execute("use dvd_rental");
		  // Result set get the result of the SQL query
		 st1.execute();
		 status =true;
		 
			 }
			 
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
