package com.dvd.customer;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;



import film_search.filmBeans;

public class customer_film_order {

	public static  boolean insertFilmOrder(String custId,String[] title,String[] release_year,String[] language){ 
		boolean status=false;
			try {
				
				System.out.println("Now in customer_film_order.java");
				Class.forName("com.mysql.jdbc.Driver");
				Connection  con = DriverManager
			      .getConnection("jdbc:mysql://localhost:3306?"
			          + "user=root&password=password");
				
				for(int i=0;i<title.length;i++){
					PreparedStatement st = con.prepareStatement("select film_id from film where title=? and release_year=? and language_id=(select language_id from language where name=? )");
						st.execute("use dvd_rental");
						  st.setString(1, title[i]);
						  st.setString(2, release_year[i]);
						  st.setString(3, language[i]);

						  ResultSet r1=st.executeQuery();
						  
						  while(r1.next()){
							  System.out.println("Film_id :"+r1.getString(1));
						  
						CallableStatement cs = con.prepareCall("{call dvd_rental.Update_payment(?,?)}");
						cs.setString(1, custId);
						cs.setString(2, r1.getString(1));
						cs.execute();
						status =true;
						  }	
								  // Result set get the result of the SQL query
						  
						  // Result set get the result of the SQL query					  
						
						  
					
				}
				  
				  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return status;
			
		}
	
	}

		
