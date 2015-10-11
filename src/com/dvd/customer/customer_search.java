/*This .java file contains function definitions for 
 * ID, email phone validations which gets called from servlet customer_details_servlet
 * */

package com.dvd.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class customer_search {
	  
	
/*This function defines customer ID validation. It connects to the database and retrieves details based on ID given.*/
	public static  List<customerBeans> validatecustomer_id(String s1){  
	//boolean status=false;
	List<customerBeans> customerlist=new ArrayList<customerBeans>();
	try {
				
		System.out.println("Now in customer_search.java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con = DriverManager
	      .getConnection("jdbc:mysql://localhost:3306?"
	          + "user=root&password=password");
		System.out.println(s1);
		PreparedStatement st3 = con.prepareStatement("select * from dvd where customer_id = ? and (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')");
		st3.setString(1,s1);
		 st3.execute("use dvd_rental");
		 System.out.println("QUERY : "+st3);
		 //3customerBeans fb=null;
		  // Result set get the result of the SQL query
		  ResultSet r3=st3.executeQuery();
	// Statements allow to issue SQL queries to the database
	  //PreparedStatement st = con.prepareStatement("select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone,(select count(dvd.dvd_barcode) from dvd  where customer_id=customer.customer_id and  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')) as count from customer where  customer.customer_id=?"); 
	  if(r3.next()){
		  PreparedStatement st=con.prepareStatement(" select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone,dvd.dvd_barcode,dvd.film_id,film.title,dvd.rented_date from customer,dvd,film where customer.customer_id=dvd.customer_id and dvd.customer_id=? and dvd.film_id=film.film_id and (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')");
		//PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.customer where title like ?");  
//	  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	 st.setString(1,s1);
	 st.execute("use dvd_rental");
	 System.out.println("QUERY : "+st);
	 customerBeans fb=null;
	  // Result set get the result of the SQL query
	  ResultSet r1=st.executeQuery();
	  
	  System.out.println(r1.getFetchSize());
	  //status=r1.next();
	  
	  while(r1.next()){
		  fb=new customerBeans();
		  System.out.println();
		  fb.setcustomer_id(r1.getString(1));
		  System.out.print(r1.getString(1));
		  fb.setfirst_name(r1.getString(2));
		  System.out.print(r1.getString(2));
		  fb.setlast_name(r1.getString(3));
		  System.out.print(r1.getString(3));
		  fb.setemail(r1.getString(4));
		  System.out.print(r1.getString(4));
		  fb.setphone(r1.getString(5));
		  System.out.print(r1.getInt(5));
		  fb.setdvd_barcode(r1.getString(6));
		  System.out.println(r1.getString(6));
		  fb.setfilm_id(r1.getString(7));
		  System.out.println(r1.getString(7));
		  fb.settitle(r1.getString(8));
		  System.out.println(r1.getString(8));
		  fb.setrented_date(r1.getString(9));
		  System.out.println(r1.getString(9));
		  
		  customerlist.add(fb);
	  }
	  }
	  
	  else{
		  PreparedStatement st1=con.prepareStatement(" select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone from customer where  customer.customer_id=?");
		//PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.customer where title like ?");  
//	  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	 st1.setString(1,s1);
	 st1.execute("use dvd_rental");
	 System.out.println("QUERY : "+st1);
	 customerBeans fb=null;
	  // Result set get the result of the SQL query
	  ResultSet r1=st1.executeQuery();
	  
	  System.out.println(r1.getFetchSize());
	  //status=r1.next();
	  
	  while(r1.next()){
		  fb=new customerBeans();
		  System.out.println();
		  fb.setcustomer_id(r1.getString(1));
		  System.out.print(r1.getString(1));
		  fb.setfirst_name(r1.getString(2));
		  System.out.print(r1.getString(2));
		  fb.setlast_name(r1.getString(3));
		  System.out.print(r1.getString(3));
		  fb.setemail(r1.getString(4));
		  System.out.print(r1.getString(4));
		  fb.setphone(r1.getString(5));
		  System.out.print(r1.getInt(5));
		  
		  
		  customerlist.add(fb);
	  }
	  }
	  
	  for (int i=0;i<customerlist.size();i++){
		  
		  System.out.print(customerlist.get(i).getfirst_name());
	  }
	  
	  System.out.println(customerlist.size()); 
	  

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.print("Customer list in customer_search is "+customerlist.size());
	return customerlist; 
	  
	}  

	/*This function defines customer Email validation. It connects to the database and retrieves details based on Email given.*/

	public static  List<customerBeans> validateemail(String s2){  
		//boolean status=false;
		List<customerBeans> customerlist=new ArrayList<customerBeans>();
		try {
				
			System.out.println("Now in customer_search.java");
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
			System.out.println(s2);
			
			PreparedStatement st3 = con.prepareStatement("select * from dvd where customer_id = (select customer_id from customer where email= ?) and (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')");
			st3.setString(1,s2);
			 st3.execute("use dvd_rental");
			 System.out.println("QUERY : "+st3);
			 //3customerBeans fb=null;
			  // Result set get the result of the SQL query
			  ResultSet r3=st3.executeQuery();
		// Statements allow to issue SQL queries to the database
		  //PreparedStatement st = con.prepareStatement("select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone,(select count(dvd.dvd_barcode) from dvd  where customer_id=customer.customer_id and  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')) as count from customer where  customer.customer_id=?"); 
		  if(r3.next()){

		// Statements allow to issue SQL queries to the database
		  PreparedStatement st = con.prepareStatement(" select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone,dvd.dvd_barcode,dvd.film_id,film.title,dvd.rented_date from customer,dvd,film where customer.customer_id=dvd.customer_id and dvd.customer_id=(select customer_id from customer where email = ?) and dvd.film_id=film.film_id and (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')"); 
		  //PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.customer where title like ?");  
//		  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
		 st.setString(1,s2);
		 st.execute("use dvd_rental");
		 System.out.println("QUERY : "+st);
		 customerBeans fb=null;
		  // Result set get the result of the SQL query
		  ResultSet r1=st.executeQuery();
		  
		  System.out.println(r1.getFetchSize());
		  //status=r1.next();
		  
		  while(r1.next()){
			  fb=new customerBeans();
			  System.out.println();
			  fb.setcustomer_id(r1.getString(1));
			  System.out.print(r1.getString(1));
			  fb.setfirst_name(r1.getString(2));
			  System.out.print(r1.getString(2));
			  fb.setlast_name(r1.getString(3));
			  System.out.print(r1.getString(3));
			  fb.setemail(r1.getString(4));
			  System.out.print(r1.getString(4));
			  fb.setphone(r1.getString(5));
			  System.out.print(r1.getInt(5));
			  fb.setdvd_barcode(r1.getString(6));
			  System.out.println(r1.getString(6));
			  fb.setfilm_id(r1.getString(7));
			  System.out.println(r1.getString(7));
			  fb.settitle(r1.getString(8));
			  System.out.println(r1.getString(8));
			  fb.setrented_date(r1.getString(9));
			  System.out.println(r1.getString(9));
			  
			  customerlist.add(fb);
		  }
		  }
		  else{
			  
			  PreparedStatement st1=con.prepareStatement(" select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone from customer where  customer.customer_id=(select customer_id from customer where email=?)");
				//PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.customer where title like ?");  
//			  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
			 st1.setString(1,s2);
			 st1.execute("use dvd_rental");
			 System.out.println("QUERY : "+st1);
			 customerBeans fb=null;
			  // Result set get the result of the SQL query
			  ResultSet r1=st1.executeQuery();
			  
			  System.out.println(r1.getFetchSize());
			  //status=r1.next();
			  
			  while(r1.next()){
				  fb=new customerBeans();
				  System.out.println();
				  fb.setcustomer_id(r1.getString(1));
				  System.out.print(r1.getString(1));
				  fb.setfirst_name(r1.getString(2));
				  System.out.print(r1.getString(2));
				  fb.setlast_name(r1.getString(3));
				  System.out.print(r1.getString(3));
				  fb.setemail(r1.getString(4));
				  System.out.print(r1.getString(4));
				  fb.setphone(r1.getString(5));
				  System.out.print(r1.getInt(5));
				  
				  
				  customerlist.add(fb);
			  }
			  
		  }
		  
		  for (int i=0;i<customerlist.size();i++){
			  
			  System.out.print(customerlist.get(i).getfirst_name());
		  }
		  
		  System.out.println(customerlist.size()); 
		  

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  // Setup the connection with the DB
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerlist; 
		  
		} 
		

	/*This function defines customer Phone validation. It connects to the database and retrieves details based on Phone given.*/
 
	public static  List<customerBeans> validatephone(String s3){  
	//boolean status=false;
	List<customerBeans> customerlist=new ArrayList<customerBeans>();
	try {
			
		System.out.println("Now in customer_search.java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con = DriverManager
	      .getConnection("jdbc:mysql://localhost:3306?"
	          + "user=root&password=password");
		System.out.println(s3);
		
		PreparedStatement st3 = con.prepareStatement("select * from dvd where customer_id = (select customer_id from customer where phone= ?) and (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')");
		st3.setString(1,s3);
		 st3.execute("use dvd_rental");
		 System.out.println("QUERY : "+st3);
		 //3customerBeans fb=null;
		  // Result set get the result of the SQL query
		  ResultSet r3=st3.executeQuery();
	// Statements allow to issue SQL queries to the database
	  //PreparedStatement st = con.prepareStatement("select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone,(select count(dvd.dvd_barcode) from dvd  where customer_id=customer.customer_id and  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')) as count from customer where  customer.customer_id=?"); 
	  if(r3.next()){

	// Statements allow to issue SQL queries to the database
	  PreparedStatement st = con.prepareStatement(" select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone,dvd.dvd_barcode,dvd.film_id,film.title,dvd.rented_date from customer,dvd,film where customer.customer_id=dvd.customer_id and dvd.customer_id=(select customer_id from customer where phone = ?) and dvd.film_id=film.film_id and (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00')"); 
	  //PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.customer where title like ?");  
//	  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	 st.setString(1,s3);
	 st.execute("use dvd_rental");
	 System.out.println("QUERY : "+st);
	 customerBeans fb=null;
	  // Result set get the result of the SQL query
	  ResultSet r1=st.executeQuery();
	  
	  System.out.println(r1.getFetchSize());
	  //status=r1.next();
	  
	  while(r1.next()){
		  fb=new customerBeans();
		  System.out.println();
		  fb.setcustomer_id(r1.getString(1));
		  System.out.print(r1.getString(1));
		  fb.setfirst_name(r1.getString(2));
		  System.out.print(r1.getString(2));
		  fb.setlast_name(r1.getString(3));
		  System.out.print(r1.getString(3));
		  fb.setemail(r1.getString(4));
		  System.out.print(r1.getString(4));
		  fb.setphone(r1.getString(5));
		  System.out.print(r1.getInt(5));
		  fb.setdvd_barcode(r1.getString(6));
		  System.out.println(r1.getString(6));
		  fb.setfilm_id(r1.getString(7));
		  System.out.println(r1.getString(7));
		  fb.settitle(r1.getString(8));
		  System.out.println(r1.getString(8));
		  fb.setrented_date(r1.getString(9));
		  System.out.println(r1.getString(9));
		  
		  customerlist.add(fb);
	  }
	  }
	  
	  else{
		  
		  PreparedStatement st1=con.prepareStatement(" select customer.customer_id,customer.first_name,customer.last_name,customer.email,customer.phone from customer where  customer.customer_id=(select customer_id from customer where phone=?)");
			//PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.customer where title like ?");  
//		  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
		 st1.setString(1,s3);
		 st1.execute("use dvd_rental");
		 System.out.println("QUERY : "+st1);
		 customerBeans fb=null;
		  // Result set get the result of the SQL query
		  ResultSet r1=st1.executeQuery();
		  
		  System.out.println(r1.getFetchSize());
		  //status=r1.next();
		  
		  while(r1.next()){
			  fb=new customerBeans();
			  System.out.println();
			  fb.setcustomer_id(r1.getString(1));
			  System.out.print(r1.getString(1));
			  fb.setfirst_name(r1.getString(2));
			  System.out.print(r1.getString(2));
			  fb.setlast_name(r1.getString(3));
			  System.out.print(r1.getString(3));
			  fb.setemail(r1.getString(4));
			  System.out.print(r1.getString(4));
			  fb.setphone(r1.getString(5));
			  System.out.print(r1.getInt(5));
			  
			  
			  customerlist.add(fb);
		  }
		  
	  }
	  
	  for (int i=0;i<customerlist.size();i++){
		  
		  System.out.print(customerlist.get(i).getfirst_name());
	  }
	  
	  System.out.println(customerlist.size()); 
	  

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return customerlist; 
	  
	} 
	
	
	public static boolean updatePersonalDetails(String custId, Map<String,String> updateFields){
		boolean returnFlag=false;
		for (Map.Entry<String, String> entry : updateFields.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
			if(entry.getKey().equals("emailUpdate")){
			updateEmail(custId, entry.getValue());
			returnFlag=true;
			}
			if(entry.getKey().equals("first_nameUpdate")){
				updateFname(custId, entry.getValue());
				returnFlag=true;
			}
			if(entry.getKey().equals("last_nameUpdate")){
				updateLname(custId, entry.getValue());
				returnFlag=true;
			}
			if(entry.getKey().equals("phoneUpdate")){
				updatePhone(custId, entry.getValue());
				returnFlag=true;
			}
			
			
		}
		return returnFlag;
		
	}
	
	public static void updateFname(String custId, String newFname){
		Connection con;
		
		System.out.println("Now in First Name Update");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
			PreparedStatement st = con.prepareStatement("update customer set first_name=? " +
			
			"where customer_id=? ");  
			PreparedStatement st2=con.prepareStatement("use dvd_rental");
			st.setString(1, newFname);
			st.setInt(2, Integer.parseInt(custId));
		  // Result set get the result of the SQL query
		  st2.execute();
		  st.execute();
		  	  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void updateLname(String custId, String newLname){
		Connection con;
		
		System.out.println("Inside Fname update");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
			PreparedStatement st = con.prepareStatement("update customer set last_name=? " +
			
			"where customer_id=? ");  
			PreparedStatement st2=con.prepareStatement("use dvd_rental");
			st.setString(1, newLname);
			st.setInt(2, Integer.parseInt(custId));
		  // Result set get the result of the SQL query
		  st2.execute();
		  st.execute();
		  	  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void updateEmail(String custId, String newEmail){
		Connection con;
		
		System.out.println("Inside Email update");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");			
			
			PreparedStatement st = con.prepareStatement("update customer set email=? " +			
			"where customer_id=? ");  
			PreparedStatement st2=con.prepareStatement("use dvd_rental");
			st.setString(1, newEmail);
			st.setInt(2, Integer.parseInt(custId));
		  // Result set get the result of the SQL query
		  st2.execute();
		  st.execute();
		  	  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void updatePhone(String custId, String newPhone){
		Connection con;
		
		System.out.println("Inside Pwd update");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
			PreparedStatement st = con.prepareStatement("update customer set phone=? " +
			
			"where customer_id=? ");  
			PreparedStatement st2=con.prepareStatement("use dvd_rental");
			st.setString(1, newPhone);
			st.setInt(2, Integer.parseInt(custId));
		  // Result set get the result of the SQL query
		  st2.execute();
		  st.execute();
		  	  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}




}
