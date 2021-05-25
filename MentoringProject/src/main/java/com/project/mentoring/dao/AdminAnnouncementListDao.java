package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminAnnouncementListDto;



public class AdminAnnouncementListDao {
	DataSource datasource;
	
	public AdminAnnouncementListDao() {
		System.out.println("Connectiong database...");
		try {
			Context context = new InitialContext();
			datasource=(DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			System.out.println("Database connection success");
		}catch(Exception e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
	}

	public ArrayList<AdminAnnouncementListDto> list(int requestPage, int numOfTuplePerPage){

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		ArrayList<AdminAnnouncementListDto> dtos=new ArrayList<AdminAnnouncementListDto>();

		String query = "SELECT * FROM notice where outdate is null ORDER BY noticepk DESC LIMIT ?, ?";

		int offset = requestPage - 1;
		
		try {
			connection=datasource.getConnection();


			preparedStatement=connection.prepareStatement(query);
			

			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*numOfTuplePerPage);
			}
			preparedStatement.setInt(2, numOfTuplePerPage);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {				
				int noticepk=resultSet.getInt("noticepk");
				int admin_adminpk=resultSet.getInt("admin_adminpk");
				String noticetitle=resultSet.getString("noticetitle");
				String noticetext=resultSet.getString("noticetext");
				Timestamp indate=resultSet.getTimestamp("indate");
				Timestamp outdate=resultSet.getTimestamp("outdate");
				
				AdminAnnouncementListDto dto=new AdminAnnouncementListDto(noticepk, admin_adminpk, noticetitle, noticetext, indate, outdate);
				dtos.add(dto);
				System.out.println("list-data load success");

			}
		}catch(Exception e) {
			System.out.println("list-data load fail");
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				System.out.println("< resultSet, preparedStatement, connection close success>");
			}catch(Exception e) {
				System.out.println("< resultSet, preparedStatement, connection close Fail>");
				e.printStackTrace();
			}
		}
		
		
		return dtos;
	}
	
	public int countTuple() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		String query = "SELECT COUNT(*) FROM notice";
		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				count = resultSet.getInt(1);
				System.out.println("list-count success");
			}			
		} catch (Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("< resultSet, preparedStatement, connection close success>");
			} catch (Exception e) {
				System.out.println("< resultSet, preparedStatement, connection close Fail>");
			}
		}
		
		return count;
	}
		
	
	
	
	
	

	public void write(String noticetitle,String noticetext) {

		
		int admin_adminpk = 1; //getAttribute("")
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		System.out.println("작성완료");
		
		try {
			connection=datasource.getConnection();
			

			String query="insert into notice (admin_adminpk,noticetitle,noticetext,indate) values (?,?,?,now())";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, admin_adminpk);
			preparedStatement.setString(2, noticetitle);
			preparedStatement.setString(3, noticetext);
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public AdminAnnouncementListDto contentView(String Noticepk) {
		AdminAnnouncementListDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		

		
		try {
			connection=datasource.getConnection();
			
			String query="select * from notice where noticepk=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(Noticepk));
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int noticepk=resultSet.getInt("noticepk");
				int admin_adminpk=resultSet.getInt("admin_adminpk");
				String noticetitle=resultSet.getString("noticetitle");
				String noticetext=resultSet.getString("noticetext");
				Timestamp indate=resultSet.getTimestamp("indate");
				Timestamp outdate=resultSet.getTimestamp("outdate");
				
				
				dto=new AdminAnnouncementListDto(noticepk, admin_adminpk, noticetitle, noticetext, indate, outdate);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return dto;
	}
	

	public void update(String noticetitle, String noticetext, String noticepk) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		System.out.println(noticepk);
		
		try {
			connection=datasource.getConnection();
			

			String query="update notice set noticetitle=?,noticetext=?,indate=now() where noticepk=?";
			preparedStatement=connection.prepareStatement(query);
	
		
			preparedStatement.setString(1, noticetitle);
			preparedStatement.setString(2, noticetext);
			preparedStatement.setString(3, noticepk);
			
			preparedStatement.executeUpdate();
			System.out.println("update 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String noticepk) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=datasource.getConnection();
			
			String query="update notice set outdate=now() where noticepk=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, noticepk);
			preparedStatement.executeUpdate();
			
			
//			String query="delete from notice where noticepk=?";
//			preparedStatement=connection.prepareStatement(query);
//			
//			preparedStatement.setString(1, noticepk);
//			preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}