package com.project.mentoring.command;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.mentoring.dao.MentorProfileDao;

public class MentorProfileInsertCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		MultipartRequest multipartRequest = null;
		String mentorimage = null;
//		생년월일 3개의 input field 에서 가져온다.		
		String year = null;
		String month = null;
		String day = null;
		String mentorbirth = null;
// -- 생년 월 일
		String mentorgender = null;
		String mentoraddress = null;
		
		int mentorProfileInsertResult = 0;
		
		int fileSize = 1024 * 1024 * 6;
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		File folder = new File(uploadPath);
		
		if(!folder.exists()) {
			try {	
				folder.mkdir(); 
				} catch (Exception e) {
					e.getStackTrace();
				}
		}
		
		
		try {
			multipartRequest = new MultipartRequest(request, uploadPath,fileSize,"UTF-8",new DefaultFileRenamePolicy());
			year = multipartRequest.getParameter("year");
			month = multipartRequest.getParameter("month");
			day = multipartRequest.getParameter("day");
			mentorbirth = year + month +day;
			String uploadFile = multipartRequest.getFilesystemName("mentorimage");
			mentorimage = "upload/" + uploadFile;
			mentoraddress = multipartRequest.getParameter("mentoraddress");
			mentorgender = multipartRequest.getParameter("mentorgender");
			
			MentorProfileDao mentorProfileDao = new MentorProfileDao();
			
			mentorProfileInsertResult = mentorProfileDao.mentorProfileInsert(mentorbirth, mentorgender, mentoraddress, mentorimage);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		
			
				
		}
			
	
		
		
		
		return mentorProfileInsertResult;
	
		
	
	}

}
