package com.project.mentoring.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public class UserFindPwDao {
	DataSource dataSource;
	
	public UserFindPwDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
		
	public String userFindPw(String userId ,String userName, String userPhone) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String userPw ="";
		
		try {
			connection = dataSource.getConnection();
			
			String findPwQuery = "select userpw from user where userid = ? and username = ? and userphone = ?";
			preparedStatement = connection.prepareStatement(findPwQuery);
			
			preparedStatement.setString(1,userId);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3,userPhone);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userPw = resultSet.getString("userpw");
				System.out.println(userPw);
				
				return userPw;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		return userPw;
		
	}
	
	
	
	
}
