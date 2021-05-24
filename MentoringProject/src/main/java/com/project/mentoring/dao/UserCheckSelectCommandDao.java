package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserCheckSelectCommandDao {
	DataSource dataSource;
	
	public UserCheckSelectCommandDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int userCheck(int userPk) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int userCheck = 0;
		try {
			connection = dataSource.getConnection();
			
			String userSignUpQuery = "select usercheck from user where userpk = ?";
			preparedStatement = connection.prepareStatement(userSignUpQuery);
			
			preparedStatement.setInt(1, userPk);
			
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				userCheck = resultSet.getInt("usercheck");
				
				return userCheck;
				
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		return userCheck;
	}
	
	
}
