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
			System.out.println("Connectiong database...");
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			System.out.println("Database connection success");
			
		}catch(Exception e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
			
		}
	}
	
	
	/* Admin Page 에 User의 list 를 
	 * 
	 *  아이디, 이름 , 핸드폰번호, 이메일, 멘토/ 멘티 ,가입날짜 , 탈퇴 날짜 보여주기 */
	//사용자가 요청한 페이지(offset)와 페이지당 표시할 게시글의 수(limit)을 매개변수로 받는다.
	public ArrayList<AdminUserListDto> userList(int requestPage, int numOfTuplePerPage){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ArrayList<AdminUserListDto> dtos = new ArrayList<AdminUserListDto>();
		// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력  
		String query = "SELECT * FROM user ORDER BY userpk DESC LIMIT ?, ? ";
		//page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = requestPage - 1;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			if (offset  == 0) {
				psmt.setInt(1, offset);
			} else {
				psmt.setInt(1, offset*numOfTuplePerPage);
			}
			psmt.setInt(2, numOfTuplePerPage);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("userId");
				String userName = rs.getString("userName");
				String userPhone = rs.getString("userPhone");
				String userEmail = rs.getString("userEmail");
				String userCheck = rs.getString("userCheck");
				Timestamp InDate = rs.getTimestamp("InDate");
				Timestamp OutDate = rs.getTimestamp("OutDate");
				
				AdminUserListDto dto = new AdminUserListDto(userId, userName, userPhone, userEmail, userCheck, InDate, OutDate);
				dtos.add(dto);
				System.out.println("list-data load success");
			}			
		} catch (Exception e) {
			System.out.println("list-data load fail");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				System.out.println("< rs, psmt, conn close Fail>");
			}
		}
		return dtos;
	}
	//list에서 사용하는 릴레이션이 가진 튜플의 총 갯수를 리턴한다.
	public int countTuple() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		String query = "SELECT COUNT(*) FROM user";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				System.out.println("list-count success");
			}			
		} catch (Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				System.out.println("< rs, psmt, conn close Fail>");
			}
		}
		return count;
	}
	
	
	
}//--end Line

