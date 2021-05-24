package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorFindSubMajorDao;

public class MentorProfileSubMajorFindCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String majorName = request.getParameter("majorname");

		
		MentorFindSubMajorDao mentorFindSubMajorDao = new MentorFindSubMajorDao();
		String mentorFindMajorPk = mentorFindSubMajorDao.findMajorPk(majorName);
		
		int majorPk = Integer.parseInt(mentorFindMajorPk);
		
		
		return majorPk;
	}

}
