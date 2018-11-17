package com.forum;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "forumBean", eager = true)
@RequestScoped
public class ForumBean {
	
	private String fullName;    // Follow java naming convention   FullName
	private String emailID;
	private String comment;
	
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	
	public String commentFormValues()
	{
		System.out.println("method");
		
		return "forumhome";
	}
	
	
	
	/*//Storing IT user data into Mysql database
	
	
		public String storeProjectData()
		{
		PreparedStatement ps = null;
		Connection con = null; 
		int i = 0;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithubsite", "root", "root");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithubwar_ithubdata", "ithubwar_hubdata", "VOOTLAreddy123");
		String sql = "INSERT INTO itprojectregdata(FirstName,MiddleName,LastName,EmailID,Phone,Address1,Address2,TimeStamp) VALUES(?,?,?,?,?,?,?,?)";
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
			
			
			// EMAIL ALERT NOTIFICATIONS CODE
			
			
			String mailSmtpHost = "smtp.ithubware.com";

			String mailTo = "vootla.prashanth@gmail.com";
			String mailCc = "prashanthreddy1217@gmail.com";
			String mailFrom = "prashanth123.vootla@gmail.com";
			String mailSubject = "ITHUBWARE TESTING MAIL";
			String Text1 = "Hello" + ","+ "\n";
			String Text2 = "Thankyou for accepting this testing mail";

			String mailText = Text1 + Text2;

			//SendEmail se = new SendEmail();
					
			//se.sendEmail(mailTo, mailCc, mailFrom, mailSubject, mailText, mailSmtpHost);
	
			
			
			return "ITProjectsRegSubmitted";
			
		}else{
			System.out.println("Database error");
			return "failed";
		}
		*/
		
	}//

