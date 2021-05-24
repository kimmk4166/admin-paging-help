package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import com.project.mentoring.dto.AdminSubMajorListDto;

public class MentorFindSubMajorDao {
	DataSource dataSource;
	
	public MentorFindSubMajorDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public String findMajorPk(String majorName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String strMajorPk = "";
		
		try {
			connection = dataSource.getConnection();
			
			String getMajorPkQuery = "select majorpk from major where majorname = ?";
			preparedStatement = connection.prepareStatement(getMajorPkQuery);
			
			preparedStatement.setString(1,majorName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				String majorPk = resultSet.getString("majorpk");
				
				strMajorPk = majorPk;
				
				return strMajorPk;
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
		return strMajorPk;
		
	}
	
	
}
