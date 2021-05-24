package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorProfileDao;
import com.project.mentoring.dao.UserLoginDao;

public class MentorSelectMentorPkCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strUserPk = UserLoginDao.userPk;
		
		int userPk = Integer.parseInt(strUserPk);
		
		MentorProfileDao getMentorpkDao = new MentorProfileDao();
		int mentorPk = getMentorpkDao.getMentorPk(userPk);
		
		return mentorPk;
	}

}
