package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserFindIdDao {
	DataSource dataSource;
	
	public UserFindIdDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	public String userFindId(String userName, String userEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String userId="";
		
		try {
			connection = dataSource.getConnection();
			
			String findIdQuery = "select userid from user where username = ? and useremail = ?";
			preparedStatement = connection.prepareStatement(findIdQuery);
			
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,userEmail);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userId = resultSet.getString("userid"); 
				
				return userId;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return userId;
		
	}
	public String userFindIdByPhone(String userName, String userPhone) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String userId="";
		
		try {
			connection = dataSource.getConnection();
			
			String findIdQuery = "select userid from user where username = ? and userphone = ?";
			preparedStatement = connection.prepareStatement(findIdQuery);
			
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,userPhone);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				userId = resultSet.getString("userid"); 
				System.out.println(userId);
				return userId;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return userId;
		
	}
	
	

}
