package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorScheduledListDao;
import com.project.mentoring.dto.MentorScheduledListDto;

public class MentorScheduledListShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		MentorScheduledListDao mentorScheduledListDao = new MentorScheduledListDao();
		
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		
		ArrayList<MentorScheduledListDto> mentorScheduledDto = mentorScheduledListDao.showScheduledList(userPk);
		request.setAttribute("scheduledList", mentorScheduledDto);

	}

}
