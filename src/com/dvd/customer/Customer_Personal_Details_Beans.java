/*This java file contains all getter,setter methods for list of fields to be displayed 
 * for customer_details*/

package com.dvd.customer;

public class Customer_Personal_Details_Beans {

	private String first_name;
	private String last_name;
	private String email;
	private int phone;
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPhone() {
		return phone;
	}

}
