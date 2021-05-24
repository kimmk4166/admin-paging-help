package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.project.mentoring.dao.UserFindIdDao;

public class UserFindIdByEmailCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		
		System.out.println(userName);
		System.out.println(userEmail);
		
		UserFindIdDao userFindIdByEmailDao = new UserFindIdDao();
		String userFindId = userFindIdByEmailDao.userFindId(userName,userEmail);
		
		if(userFindId.equals("")) {
			return 0;
		}else {
			
			request.setAttribute("userid", userFindId);
			return 1;
		}
		
		
	}

}
