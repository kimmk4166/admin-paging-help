package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserLoginDao {
	DataSource dataSource;
	public static String userPk;
	
	public UserLoginDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public int userLogin(String userId, String userPw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String userSignUpQuery = " select userpk, userpw from user where userid = ?";
			preparedStatement = connection.prepareStatement(userSignUpQuery);
			
			preparedStatement.setString(1, userId);
			
			
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				if(resultSet.getString("userpw").equals(userPw)) {
					userPk = resultSet.getString("userpk");
					
					return 1;
				}else {
					return 0;
				}
			}
			

			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();	
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
		
		return -1;
		
		
	}
	
	
	
}
