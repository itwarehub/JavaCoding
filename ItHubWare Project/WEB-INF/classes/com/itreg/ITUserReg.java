package com.itreg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "itUserData", eager = true)
@RequestScoped
public class ITUserReg {
	
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String EmailID;
	private String phone1;
	private String phone2;
	private String phone3;
	private String Address1;
	private String Address2;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
		System.out.println("Name"+FirstName);
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	
	//Storing IT user data into Mysql database
	
	
	public String storeUserData()
	{
	PreparedStatement ps = null;
	Connection con = null; 
	int i = 0;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithubwar_ithubdata", "ithubwar_hubdata", "VOOTLAreddy123");
	String sql = "INSERT INTO ittrainingusersdata(FirstName,MiddleName,LastName,EmailID,Phone,Address1,Address2,TimeStamp) VALUES(?,?,?,?,?,?,?,?)";
	ps= con.prepareStatement(sql); 


	ps.setString(1, FirstName);
	ps.setString(2, MiddleName);
	ps.setString(3, LastName);
	ps.setString(4, EmailID);
	ps.setString(5, phone1+phone2+phone3);
	ps.setString(6, Address1);
	ps.setString(7, Address2);
	ps.setTimestamp(8, new java.sql.Timestamp(new java.util.Date().getTime()));
	
	
	i=ps.executeUpdate();
	
	

	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	finally
	{
	try
	{
	con.close();
	ps.close();
	
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	}//finally closed
	
	
	
	if(i!=0)
	{
		System.out.println("Data Added Successfully");
		return "ITUserRegSubmitted";
		
	}else{
		System.out.println("Database error");
		return "failed";
	}
	
	
}//

}
