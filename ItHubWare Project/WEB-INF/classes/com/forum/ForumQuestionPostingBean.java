package com.forum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "forumQuestionBean", eager = true)
@RequestScoped

public class ForumQuestionPostingBean {
	
	private String QuestRelatedTag;
	private String QuestTitle;
	private String QuestDescription;
	private String FullName;
	private String EmailID;
	public String getQuestRelatedTag() {
		return QuestRelatedTag;
	}
	public void setQuestRelatedTag(String questRelatedTag) {
		QuestRelatedTag = questRelatedTag;
	}
	public String getQuestTitle() {
		return QuestTitle;
	}
	public void setQuestTitle(String questTitle) {
		QuestTitle = questTitle;
	}
	public String getQuestDescription() {
		return QuestDescription;
	}
	public void setQuestDescription(String questDescription) {
		QuestDescription = questDescription;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	
	
	public String submittingNewQuestion()
	{
		PreparedStatement ps = null;
		Connection con = null; 
		int i = 0;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithubsite", "root", "root");
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ithubwar_ithubdata", "ithubwar_hubdata", "VOOTLAreddy123");
		String sql = "INSERT INTO forumpostingquestions(QuestionRelatedTag,QuestionTitle,QuestionDescription,FullName,EmailID,TimeStamp) VALUES(?,?,?,?,?,?)";
		ps= con.prepareStatement(sql); 


		ps.setString(1, QuestRelatedTag);
		ps.setString(2, QuestTitle);
		ps.setString(3, QuestDescription);
		ps.setString(4, FullName);
		ps.setString(5, EmailID);
		ps.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
				
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
			return "questsubmitting";
			
		}else{
			System.out.println("Database error");
			return "failed";
		}
		
	}
	

}
