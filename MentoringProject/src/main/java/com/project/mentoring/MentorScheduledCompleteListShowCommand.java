package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorScheduledCompleteListDao;
import com.project.mentoring.dto.MentorScheduledCompleteListDto;

public class MentorScheduledCompleteListShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MentorScheduledCompleteListDao mentorScheduledCompleteListDao = new MentorScheduledCompleteListDao();
		
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		
		ArrayList<MentorScheduledCompleteListDto> mentorScheduledCompleteListDto = mentorScheduledCompleteListDao.showCompleteList(userPk);
		request.setAttribute("scheduledCompletedList", mentorScheduledCompleteListDto);

	}

}
