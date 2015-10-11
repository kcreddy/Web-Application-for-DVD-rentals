package film_search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class film_add {
	  
	public static  Boolean validate(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,String s11,String s12,String s13)
	{  
	boolean status=false;
	boolean status1=true;

	//List<filmBeans> filmlist=new ArrayList<filmBeans>();
	try {
		/*if(s1==null){
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
		} */
		
		System.out.println("Now in film_search_java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con = DriverManager
	      .getConnection("jdbc:mysql://localhost:3306?"
	          + "user=root&password=password");
System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7+" "+s8+" "+s9+" "+s10+" "+s11+" "+s12+" "+s13);

PreparedStatement st11 = con.prepareStatement("select * from film where title =? and release_year = ? and language_id = (select language_id from language where name=?)");

st11.setString(1,s1);  
st11.setString(2,s2);
st11.setString(3,s8);
 st11.execute("use dvd_rental");
  // Result set get the result of the SQL query
 //st.execute();
 ResultSet r11=st11.executeQuery();
 while(r11.next()){
	 status1=false;
 }
 
 if(status1==true){

	// Statements allow to issue SQL queries to the database
	  PreparedStatement st = con.prepareStatement("insert into film(title,release_year,rating,price,length,rental_duration,replacement_cost,language_id) values(?,?,?,?,?,?,?,(select language_id from language where name = ?))");
	  PreparedStatement st1 = con.prepareStatement("select film_id from dvd_rental.film where title =? and release_year=? and rating=? and price =? and length=? and rental_duration=? and replacement_cost =? and language_id=(select language_id from language where name = ?)");

	  PreparedStatement st2 = con.prepareStatement("insert into in_category(category_id,film_id) values((select category_id from category where name =?),?)");
	  PreparedStatement st3 = con.prepareStatement("select category_id from in_category where film_id =?");

	  PreparedStatement st4 = con.prepareStatement("select actor_id from actor where first_name =? and last_name =?");
	  PreparedStatement st5 = con.prepareStatement("insert into actor(first_name,last_name) values(?,?)");
	  PreparedStatement st6 = con.prepareStatement("select actor_id from actor where first_name =? and last_name =?");
	  PreparedStatement st7 = con.prepareStatement("insert into acted_by(actor_id,film_id) values((select actor_id from actor where first_name =? and last_name =?),?)");
	  PreparedStatement st8 = con.prepareStatement("select actor_id from acted_by where film_id =?");
	  
	  PreparedStatement st9 = con.prepareStatement("alter table dvd auto_increment=?");
	  PreparedStatement st10 = con.prepareStatement("insert into dvd(film_id) values(?)");

	 st.setString(1,s1);
	 st.setString(2,s2);	 
	 st.setString(3,s3);	 
	 st.setString(4,s4);	 
	 st.setString(5,s5);	 
	 st.setString(6,s6);
	 st.setString(7,s7);	 
	 st.setString(8,s8);
	 System.out.println("QUERY : "+st);
	 st.execute("use dvd_rental");
	 st.execute();
	 System.out.println("QUERY : "+st);
	 
	 st1.setString(1,s1);
	 st1.setString(2,s2);	 
	 st1.setString(3,s3);	 
	 st1.setString(4,s4);	 
	 st1.setString(5,s5);	 
	 st1.setString(6,s6);
	 st1.setString(7,s7);	 
	 st1.setString(8,s8);
	 st1.execute("use dvd_rental");
	 System.out.println("QUERY r1=: "+st1);
	 ResultSet r1=st1.executeQuery();
	 int assign_film =0;
	 while(r1.next()){
		 assign_film=r1.getInt(1);
	 }
	 System.out.println(assign_film);

	 
	
	 st2.setString(1,s9);
	 st2.setInt(2,assign_film);
	 st2.execute("use dvd_rental");
	 System.out.println("QUERY : "+st2);
	 st2.execute();
	 		 
	 st3.setInt(1,assign_film); 
	 st3.execute("use dvd_rental");
	 System.out.println("QUERY : "+st3);	 
	  ResultSet r2=st3.executeQuery();

	st4.setString(1,s10); 
	st4.setString(2,s11);
	System.out.println("QUERY : "+st4);
	ResultSet r3=st4.executeQuery();
	if (!r3.next())
	{
		st5.setString(1, s10);
		st5.setString(2, s11);
		st5.execute("use dvd_rental");
		System.out.println("QUERY : "+st5);
		st5.execute();
		
		st6.setString(1,s10);
		st6.setString(2, s11);
		System.out.println("QUERY : "+st6);
		ResultSet r4=st6.executeQuery();		
	}
	
	st7.setString(1,s10);
	st7.setString(2, s11);
	st7.setInt(3, assign_film);
	st7.execute("use dvd_rental");
	System.out.println("QUERY : "+st7);
	st7.execute();
	
	st8.setInt(1,assign_film);
	st8.execute("use dvd_rental");
	System.out.println("QUERY : "+st8);
	ResultSet r5=st8.executeQuery();
	
	int assign_copies=Integer.parseInt(s12);
	st9.setInt(1,assign_copies);
	st9.execute("use dvd_rental");
	System.out.println("QUERY : "+st9);
	st9.execute();
	
	for(int i=0;i<Integer.parseInt(s13);i++)
	{

	st10.setInt(1, assign_film);
	st10.execute("use dvd_rental");
	System.out.println("QUERY : "+st10);
	st10.execute();
	status=true;
	}
	
 }
	  
	  

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  // Setup the connection with the DB
	catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("ERROR MESSAGE :"+e.getMessage());
		e.printStackTrace();
	}
	return status; 
	  
	}  

		



}
