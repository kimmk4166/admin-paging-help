package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.project.mentoring.dao.MentorProfileDao;

public class MentorProfileIntroduceInsertCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String strMentorPk = request.getParameter("mentorpk");
		int mentorPk = Integer.parseInt(strMentorPk);
		String strSubMajorPk = request.getParameter("submajorpk");
		int submajorPk = Integer.parseInt(strSubMajorPk);
		String title = request.getParameter("title");
		String introduce = request.getParameter("introduce");
		String price = request.getParameter("price");
		
		
		MentorProfileDao mentorProfileDao = new MentorProfileDao();
		
		int mentorProfileIntroduceResult = mentorProfileDao.mentorProfileIntroduceInsert(mentorPk, submajorPk, title, introduce, price);
		
		
		return mentorProfileIntroduceResult;
	}

}
