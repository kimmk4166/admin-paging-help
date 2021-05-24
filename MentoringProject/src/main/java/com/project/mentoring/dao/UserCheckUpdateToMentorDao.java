package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminMajorListDto;

public class UserCheckUpdateToMentorDao {
	
	DataSource dataSource;
	
	public UserCheckUpdateToMentorDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int userCheckUpdate(int userPk) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = dataSource.getConnection();
			
			String userCheckUpdateQuery = "update user set usercheck = 1 where userpk = ?";
			prepareStatement = connection.prepareStatement(userCheckUpdateQuery);
			
			prepareStatement.setInt(1, userPk);
			
			prepareStatement.executeUpdate();
			
			return 1;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return 0;
	}

}
