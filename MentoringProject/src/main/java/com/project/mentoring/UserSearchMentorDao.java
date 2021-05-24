package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import com.project.mentoring.dto.HomePageMentorListDto;
import com.project.mentoring.dto.UserSearchMentorDto;

public class UserSearchMentorDao {
	
	DataSource dataSource;
	
	public UserSearchMentorDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public ArrayList<UserSearchMentorDto> searchMentorProfile(String mentorAddress,String mentorMajor , String mentorSubMajor){
		ArrayList<UserSearchMentorDto> userSearchMentorDtos = new ArrayList<UserSearchMentorDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		System.out.println(mentorAddress + mentorMajor +  mentorSubMajor);
		
		
		try {
			
			connection = dataSource.getConnection();
			
			String mentorListQuery1 = "select m.mentorimage , mj.majorname , p.title , s.submajorname ,p.productpk, u.username,p.price from product as p ";
			String mentorListQuery2 = "inner join mentor as m on m.mentorpk = p.mentor_mentorpk ";
			String mentorListQuery3 = "inner join submajor as s on p.submajor_submajorpk = s.submajorpk ";
			String mentorListQuery4 = "inner join major as mj on mj.majorpk=s.major_majorpk ";
			String mentorListQuery5 = "inner join user as u on u.userpk = m.user_userpk ";
			String mentorListQuery6 = "where m.outdate is null and m.mentoraddress like '%"+mentorAddress+"%' ";
			String mentorListQuery7 = "and mj.majorname = '"+ mentorMajor+"' and s.submajorname like '%"+mentorSubMajor+"%'";
			prepareStatement = connection.prepareStatement(mentorListQuery1+mentorListQuery2+mentorListQuery3+mentorListQuery4+mentorListQuery5+mentorListQuery6+mentorListQuery7);
			
			
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String mentorimage = resultSet.getString("mentorimage");
				String majorname = resultSet.getString("majorname");
				String title = resultSet.getString("title");
				String submajorname = resultSet.getString("submajorname");
				String productPk = resultSet.getString("productpk");
				String username = resultSet.getString("username");
				String price = resultSet.getString("price");
				
				UserSearchMentorDto userSearchMentorDto = new UserSearchMentorDto(mentorimage, majorname, title, submajorname, productPk, username, price);
				userSearchMentorDtos.add(userSearchMentorDto);
				
			}
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
		
		
		
		return userSearchMentorDtos;
	}
	

	
}
