package com.dvd.customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customer_dvd_return {
	
	public static  boolean returndvd(String custId,String dvd_barcode){ 
		boolean status=false;
			try {
				
				System.out.println("Now in customer_film_order.java");
				Class.forName("com.mysql.jdbc.Driver");
				Connection  con = DriverManager
			      .getConnection("jdbc:mysql://localhost:3306?"
			          + "user=root&password=password");
				
					PreparedStatement st = con.prepareStatement("select * from dvd_rental.dvd where customer_id =? and dvd_barcode=? and rented_date <> '0000-00-00 00:00:00' and returned_date='0000-00-00 00:00:00'");
					  st.execute("use dvd_rental");
					  st.setString(1, custId);
					  st.setString(2, dvd_barcode);
						 System.out.println("QUERY : "+st);

					  ResultSet r1=st.executeQuery();
						  
						  while(r1.next()){
							PreparedStatement st1 = con.prepareStatement("update dvd_rental.dvd set returned_date = now() where customer_id = ? and dvd_barcode=?");
							  st1.execute("use dvd_rental");
								 System.out.println("QUERY : "+st1);
								  st1.setString(1, custId);
								  st1.setString(2, dvd_barcode);
							  st1.execute();
							  status =true;
						  }	
								  // Result set get the result of the SQL query
						  
						  // Result set get the result of the SQL query					  
						
						  
					
				
				  
				  
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

		
