package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MentorTokenUpdateDao {
	DataSource dataSource;
	
	public MentorTokenUpdateDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int tokenUpdate(String token, int paymentPk) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = dataSource.getConnection();
			
			String tokenUpdateQuery1 = "update payment set paymenttoken = '"+token+"'"; 
			String tokenUpdateQuery2= "where paymentpk = " + paymentPk;
			prepareStatement = connection.prepareStatement(tokenUpdateQuery1 + tokenUpdateQuery2);
			
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
