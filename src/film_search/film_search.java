package film_search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class film_search {
	  
	public static  List<filmBeans> validate(String s1,String s4,String s5,String s2,String s3){  
	//boolean status=false;
	List<filmBeans> filmlist=new ArrayList<filmBeans>();
	try {
		if(s1==null){
			s1="";
		}
		if(s2==null){
			s2="";
		}
		if(s3==null){
			s3="";
		}
		if(s4==null){
			s4="";
		}
		if(s5==null){
			s5="";
		}
		
		System.out.println("Now in film_search_java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con = DriverManager
	      .getConnection("jdbc:mysql://localhost:3306?"
	          + "user=root&password=password");
System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);

	// Statements allow to issue SQL queries to the database
	  PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability,(select name  from language where language_id=f.language_id) as Language from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
	  //PreparedStatement st = con.prepareStatement("select title,rating,release_year,rental_duration,price,replacement_cost from dvd_rental.film where title like ?");  
//	  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	 st.setString(1,"%"+s1+"%");
	 st.setString(2,"%"+s4+"%");
	 st.setString(3,"%"+s5+"%");
	 st.setString(4,"%"+s5+"%");
	 st.setString(5,"%"+s2+"%");
	 st.setString(6,"%"+s3+"%");
	 st.execute("use dvd_rental");
	 System.out.println("QUERY : "+st);
	 filmBeans fb=null;
	  // Result set get the result of the SQL query
	  ResultSet r1=st.executeQuery();
	  
System.out.println(r1.getFetchSize());
	  //status=r1.next();
	  
	  while(r1.next()){
		  fb=new filmBeans();
		  System.out.println();
		  fb.settitle(r1.getString(1));
		  System.out.print(r1.getString(1));
		  fb.setrating(r1.getString(2));
		  System.out.print(r1.getString(2));
		  fb.setrelease_year(r1.getInt(3));
		  System.out.print(r1.getInt(3));
		  fb.setrental_duration(r1.getInt(4));
		  System.out.print(r1.getInt(4));
		  fb.setprice(r1.getInt(5));
		  System.out.print(r1.getInt(5));
		  fb.setreplacement_cost(r1.getInt(6));
		  System.out.print(r1.getInt(6));
		  fb.setavailability(r1.getInt(7));
		  System.out.print(r1.getInt(7));
		  System.out.println();
		  fb.setlanguage(r1.getString(8));
		  System.out.print(r1.getString(8));
		  
		  filmlist.add(fb);
	  }
	  
	  for (int i=0;i<filmlist.size();i++){
		  
		  System.out.print(filmlist.get(i).gettitle());
	  }
	  
	  System.out.println(filmlist.size());
	  
	  

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return filmlist; 
	  
	}  


	public static  List<filmBeans> validate1(String s1,String s4,String s5,String s2,String s3){  
	//boolean status=false;
	List<filmBeans> filmlist=new ArrayList<filmBeans>();
	try {
		if(s1==null){
			s1="";
		}
		if(s2==null){
			s2="";
		}
		if(s3==null){
			s3="";
		}
		if(s4==null){
			s4="";
		}
		if(s5==null){
			s5="";
		}
		
		System.out.println("Now in film_search_java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con = DriverManager
	      .getConnection("jdbc:mysql://localhost:3306?"
	          + "user=root&password=password");
System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);

	// Statements allow to issue SQL queries to the database
	  //PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability,(select name  from language where language_id=f.language_id) as Language from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
	  PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability, (select name  from language where language_id=f.language_id) as Language,  (select name from category where category_id =(select category_id from dvd_rental.category where name = ?)) as category,(select first_name from actor where actor_id in (select actor_id from dvd_rental.actor where first_name = ? or last_name = ?)) as actor from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name = ? or last_name = ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name = ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
//	  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	  st.setString(1,s2);
	  st.setString(2,s5);
	  st.setString(3,s5);
	  st.setString(4,"%"+s1+"%");
	 st.setString(5,"%"+s4+"%");
	 st.setString(6,s5);
	 st.setString(7,s5);
	 st.setString(8,s2);
	 st.setString(9,"%"+s3+"%");
	 st.execute("use dvd_rental");
	 System.out.println("QUERY : "+st);
	 filmBeans fb=null;
	  // Result set get the result of the SQL query
	  ResultSet r1=st.executeQuery();
	  
System.out.println(r1.getFetchSize());
	  //status=r1.next();
	  
	  while(r1.next()){
		  fb=new filmBeans();
		  System.out.println();
		  fb.settitle(r1.getString(1));
		  System.out.print(r1.getString(1));
		  fb.setrating(r1.getString(2));
		  System.out.print(r1.getString(2));
		  fb.setrelease_year(r1.getInt(3));
		  System.out.print(r1.getInt(3));
		  fb.setrental_duration(r1.getInt(4));
		  System.out.print(r1.getInt(4));
		  fb.setprice(r1.getInt(5));
		  System.out.print(r1.getInt(5));
		  fb.setreplacement_cost(r1.getInt(6));
		  System.out.print(r1.getInt(6));
		  fb.setavailability(r1.getInt(7));
		  System.out.print(r1.getInt(7));
		  System.out.println();
		  fb.setlanguage(r1.getString(8));
		  System.out.print(r1.getString(8));
		  fb.setcategory(r1.getString(9));
		  System.out.print(r1.getString(9));
		  fb.setactor(r1.getString(10));
		  System.out.print(r1.getString(10));
		  
		  filmlist.add(fb);
	  }
	  
	  for (int i=0;i<filmlist.size();i++){
		  
		  System.out.print(filmlist.get(i).gettitle());
	  }
	  
	  System.out.println(filmlist.size());
	  
	  

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return filmlist; 
	  
	} 
	

	public static  List<filmBeans> validate2(String s1,String s4,String s5,String s2,String s3){  
	//boolean status=false;
	List<filmBeans> filmlist=new ArrayList<filmBeans>();
	try {
		if(s1==null){
			s1="";
		}
		if(s2==null){
			s2="";
		}
		if(s3==null){
			s3="";
		}
		if(s4==null){
			s4="";
		}
		if(s5==null){
			s5="";
		}
		
		System.out.println("Now in film_search_java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con = DriverManager
	      .getConnection("jdbc:mysql://localhost:3306?"
	          + "user=root&password=password");
System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);

	// Statements allow to issue SQL queries to the database
	  //PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability,(select name  from language where language_id=f.language_id) as Language from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
	  PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability, (select name  from language where language_id=f.language_id) as Language,  (select name from category where category_id =(select category_id from dvd_rental.category where name = ?)) as category from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name = ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
//	  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	  st.setString(1,s2);
	 // st.setString(2,s5);
	  //st.setString(3,s5);
	  st.setString(2,"%"+s1+"%");
	 st.setString(3,"%"+s4+"%");
	 st.setString(4,"%"+s5+"%");
	 st.setString(5,"%"+s5+"%");
	 st.setString(6,s2);
	 st.setString(7,"%"+s3+"%");
	 st.execute("use dvd_rental");
	 System.out.println("QUERY : "+st);
	 filmBeans fb=null;
	  // Result set get the result of the SQL query
	  ResultSet r1=st.executeQuery();
	  
System.out.println(r1.getFetchSize());
	  //status=r1.next();
	  
	  while(r1.next()){
		  fb=new filmBeans();
		  System.out.println();
		  fb.settitle(r1.getString(1));
		  System.out.print(r1.getString(1));
		  fb.setrating(r1.getString(2));
		  System.out.print(r1.getString(2));
		  fb.setrelease_year(r1.getInt(3));
		  System.out.print(r1.getInt(3));
		  fb.setrental_duration(r1.getInt(4));
		  System.out.print(r1.getInt(4));
		  fb.setprice(r1.getInt(5));
		  System.out.print(r1.getInt(5));
		  fb.setreplacement_cost(r1.getInt(6));
		  System.out.print(r1.getInt(6));
		  fb.setavailability(r1.getInt(7));
		  System.out.print(r1.getInt(7));
		  System.out.println();
		  fb.setlanguage(r1.getString(8));
		  System.out.print(r1.getString(8));
		  fb.setcategory(r1.getString(9));
		  System.out.print(r1.getString(9));
		  //fb.setactor(r1.getString(10));
		  //System.out.print(r1.getString(10));
		  
		  filmlist.add(fb);
	  }
	  
	  for (int i=0;i<filmlist.size();i++){
		  
		  System.out.print(filmlist.get(i).gettitle());
	  }
	  
	  System.out.println(filmlist.size());
	  
	  

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return filmlist; 
	  
	} 
	
	
		
	public static  List<filmBeans> validate3(String s1,String s4,String s5,String s2,String s3){  
		//boolean status=false;
		List<filmBeans> filmlist=new ArrayList<filmBeans>();
		try {
			if(s1==null){
				s1="";
			}
			if(s2==null){
				s2="";
			}
			if(s3==null){
				s3="";
			}
			if(s4==null){
				s4="";
			}
			if(s5==null){
				s5="";
			}
			
			System.out.println("Now in film_search_java");
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
	System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);

		// Statements allow to issue SQL queries to the database
		  //PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability,(select name  from language where language_id=f.language_id) as Language from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
		  PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability, (select name  from language where language_id=f.language_id) as Language,  (select first_name from actor where actor_id in (select actor_id from dvd_rental.actor where first_name = ? or last_name = ?)) as actor from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name = ? or last_name = ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
//		  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
		  //st.setString(1,s2);
		 st.setString(1,s5);
		 st.setString(2,s5);
		  st.setString(3,"%"+s1+"%");
		 st.setString(4,"%"+s4+"%");
		 st.setString(5,s5);
		 st.setString(6,s5);
		 st.setString(7,"%"+s2+"%");
		 st.setString(8,"%"+s3+"%");
		 st.execute("use dvd_rental");
		 System.out.println("QUERY : "+st);
		 filmBeans fb=null;
		  // Result set get the result of the SQL query
		  ResultSet r1=st.executeQuery();
		  
	System.out.println(r1.getFetchSize());
		  //status=r1.next();
		  
		  while(r1.next()){
			  fb=new filmBeans();
			  System.out.println();
			  fb.settitle(r1.getString(1));
			  System.out.print(r1.getString(1));
			  fb.setrating(r1.getString(2));
			  System.out.print(r1.getString(2));
			  fb.setrelease_year(r1.getInt(3));
			  System.out.print(r1.getInt(3));
			  fb.setrental_duration(r1.getInt(4));
			  System.out.print(r1.getInt(4));
			  fb.setprice(r1.getInt(5));
			  System.out.print(r1.getInt(5));
			  fb.setreplacement_cost(r1.getInt(6));
			  System.out.print(r1.getInt(6));
			  fb.setavailability(r1.getInt(7));
			  System.out.print(r1.getInt(7));
			  System.out.println();
			  fb.setlanguage(r1.getString(8));
			  System.out.print(r1.getString(8));
			  //fb.setcategory(r1.getString(9));
			  //System.out.print(r1.getString(9));
			  fb.setactor(r1.getString(9));
			  System.out.print(r1.getString(9));
			  
			  filmlist.add(fb);
		  }
		  
		  for (int i=0;i<filmlist.size();i++){
			  
			  System.out.print(filmlist.get(i).gettitle());
		  }
		  
		  System.out.println(filmlist.size());
		  
		  

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  // Setup the connection with the DB
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmlist; 
		  
		} 

	public static boolean validate4(String s1){  
		boolean status=false;
		try {
			if(s1==null){
				s1="";
			}
					
			System.out.println("Now in film_search_java");
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
	System.out.println(s1);

		// Statements allow to issue SQL queries to the database
		  //PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability,(select name  from language where language_id=f.language_id) as Language from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
		  PreparedStatement st = con.prepareStatement("select * from film where title like ?");  
//		  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
		  //st.setString(1,s2);
		 st.setString(1,"%"+s1+"%");
		 st.execute("use dvd_rental");
		 System.out.println("QUERY : "+st);
		  // Result set get the result of the SQL query
		  ResultSet r1=st.executeQuery();
		  
	System.out.println(r1.getFetchSize());
		  //status=r1.next();
		  
		  while(r1.next()){
			  status=true;
		  }
		  
		  

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
	
	public static boolean validate5(String s5){  
		boolean status=false;
		try {
			if(s5==null){
				s5="";
			}
					
			System.out.println("Now in film_search_java");
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con = DriverManager
		      .getConnection("jdbc:mysql://localhost:3306?"
		          + "user=root&password=password");
	System.out.println(s5);

		// Statements allow to issue SQL queries to the database
		  //PreparedStatement st = con.prepareStatement("select f.title,f.rating,f.release_year,f.rental_duration,f.price,f.replacement_cost,( select count(dvd.dvd_barcode) from dvd_rental.dvd where dvd.film_id=f.film_id and ((dvd.rented_date = '0000-00-00 00:00:00' and dvd.returned_date ='0000-00-00 00:00:00') or  (dvd.rented_date <> '0000-00-00 00:00:00' and dvd.returned_date <>'0000-00-00 00:00:00')) )  as availability,(select name  from language where language_id=f.language_id) as Language from dvd_rental.film f  where f.title like ?  and  f.release_year like ? and f.film_id in (select a.film_id from dvd_rental.acted_by a where a.actor_id in(select  actor_id from dvd_rental.actor where first_name like ? or last_name like ?))  and f.film_id in (select i.film_id from dvd_rental.in_category i where i.category_id in(select category_id from dvd_rental.category where name like ?))  and f.language_id in(select language_id from dvd_rental.language where name like ?)");  
		  PreparedStatement st = con.prepareStatement("select * from actor where first_name=? or last_name=?");  
//		  System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5);
		  //st.setString(1,s2);
		 st.setString(1,s5);
		 st.setString(2,s5);
		 st.execute("use dvd_rental");
		 System.out.println("QUERY : "+st);
		  // Result set get the result of the SQL query
		  ResultSet r1=st.executeQuery();
		  
	System.out.println(r1.getFetchSize());
		  //status=r1.next();
		  
		  while(r1.next()){
			  status=true;
		  }
		  
		  

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
