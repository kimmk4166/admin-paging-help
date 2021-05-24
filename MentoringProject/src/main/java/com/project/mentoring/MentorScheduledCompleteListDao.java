package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminUserListDto;
import com.project.mentoring.dto.MentorScheduledCompleteListDto;
import com.project.mentoring.dto.MentorScheduledListDto;

public class MentorScheduledCompleteListDao {
	DataSource dataSource;

	public MentorScheduledCompleteListDao() {
		
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<MentorScheduledCompleteListDto> showCompleteList(int userPk){
		
		
		
		ArrayList<MentorScheduledCompleteListDto> mentorScheduledCompleteListDtos = new ArrayList<MentorScheduledCompleteListDto>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String mentorScheduledListShowQuery1 = "select s.schedulepk, u.username, u.userphone, mj.majorname, sb.submajorname, p.price ";
			String mentorScheduledListShowQuery2 = "from payment as py inner join schedule as s on s.schedulepk = py.schedule_schedulepk ";
			String mentorScheduledListShowQuery3 = "inner join user as u on u.userpk = py.user_userpk ";
			String mentorScheduledListShowQuery4 = "inner join product as p on p.productpk = s.product_productpk ";
			String mentorScheduledListShowQuery5 = "inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk ";
			String mentorScheduledListShowQuery6 = "inner join major as mj on mj.majorpk=sb.major_majorpk ";
			String mentorScheduledListShowQuery7 = "inner join mentor as m on p.mentor_mentorpk = m.mentorpk ";
			String mentorScheduledListShowQuery8 = "inner join user as mu on mu.userpk = m.user_userpk ";
			String mentorScheduledListShowQuery9 = "where m.user_userpk = " + userPk;
			String mentorScheduledListShowQuery10 = " and py.paymentsenddate is null and py.paymenttoken is not null";
			
			
			prepareStatement = connection.prepareStatement(mentorScheduledListShowQuery1 + mentorScheduledListShowQuery2 + mentorScheduledListShowQuery3 +mentorScheduledListShowQuery4 +mentorScheduledListShowQuery5 + mentorScheduledListShowQuery6 +mentorScheduledListShowQuery7 + mentorScheduledListShowQuery8 +mentorScheduledListShowQuery9 + mentorScheduledListShowQuery10);
			resultSet = prepareStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				int scheduledPk = resultSet.getInt("schedulepk");
				String userName = resultSet.getString("username");
				String userPhone = resultSet.getString("userphone");
				String majorName = resultSet.getString("majorname");
				String subMajorName = resultSet.getString("submajorname");
				String price = resultSet.getString("price");
				
				

				MentorScheduledCompleteListDto mentorScheduledCompleteListDto = new MentorScheduledCompleteListDto(scheduledPk, userName, userPhone, majorName, subMajorName, price);
				mentorScheduledCompleteListDtos.add(mentorScheduledCompleteListDto);				
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
		
		
		
		
		return mentorScheduledCompleteListDtos;
	}
	
	
	
	
}
