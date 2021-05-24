package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.UserCheckSelectCommandDao;

public class UserCheckSelectCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String strUserPk = (String)session.getAttribute("userpk");
		
		int userPk = Integer.parseInt(strUserPk);
		
		UserCheckSelectCommandDao userCheckSelectCommandDao = new UserCheckSelectCommandDao();
		
		int userCheck = userCheckSelectCommandDao.userCheck(userPk);
		
		
		return userCheck;
	}

}
