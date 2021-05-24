package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.UserSignUpDao;

public class UserSignUpPageInsertCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		
		// phone 은 3군데의 input 에서 받아옴
		
		String fuserphone = request.getParameter("fuserphone");  
		String muserphone = request.getParameter("muserphone");
		String euserphone = request.getParameter("euserphone");
		
		//-- phone 끝 
		
		String userPhone = fuserphone + muserphone + euserphone;
		
		UserSignUpDao userSignUpdao = new UserSignUpDao();
		
		int userSignUpResult = userSignUpdao.userSignUp(userId, userPw, userName, userEmail, userPhone);
		
		
		return userSignUpResult;
		

	}

}
