package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.UserLoginDao;

public class UserLoginPageSelectCommand implements IntCommand{
	
		
	
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw"); 
		
		
		
		UserLoginDao userLoginDao = new UserLoginDao();
		
		int loginProcess = userLoginDao.userLogin(userId, userPw);
		
		
		return loginProcess;
		
		
	}
	
	

}
