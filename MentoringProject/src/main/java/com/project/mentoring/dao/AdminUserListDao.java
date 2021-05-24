package com.project.mentoring.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminUserListDto;


import java.sql.*;
import java.util.ArrayList;

public class AdminUserListDao {

	DataSource dataSource;

	public AdminUserListDao() {
		
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	/* Admin Page 에 User의 list 를 
	 * 
	 *  아이디, 이름 , 핸드폰번호, 이메일, 멘토/ 멘티 ,가입날짜 , 탈퇴 날짜 보여주기 */
	public ArrayList<AdminUserListDto > userList(){
		ArrayList<AdminUserListDto> adminUserListDtos = new ArrayList<AdminUserListDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String userListQuery = "select userid, username, userphone, useremail, usercheck ,indate, outdate from user";
			prepareStatement = connection.prepareStatement(userListQuery);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String userId = resultSet.getString("userid");
				String userName = resultSet.getString("username");
				String userPhone = resultSet.getString("userphone");
				String userEmail = resultSet.getString("useremail");
				String userCheck = resultSet.getString("usercheck");
				Timestamp userInDate = resultSet.getTimestamp("indate");
				Timestamp userOutDate = resultSet.getTimestamp("outdate");
				
				AdminUserListDto adminUserListDto = new AdminUserListDto(userId, userName, userPhone, userEmail, userCheck, userInDate, userOutDate);
				adminUserListDtos.add(adminUserListDto);				
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
		
		return adminUserListDtos;
	}
	
	
	
	
	
}//--end Line

