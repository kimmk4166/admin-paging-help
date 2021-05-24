package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.UserSearchMentorDao;
import com.project.mentoring.dto.UserSearchMentorDto;

public class UserSearchPageShowCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String mentorAddress = request.getParameter("mentoraddress");
		String mentorMajor = request.getParameter("mentorMajor");
		String mentorSubMajor = request.getParameter("mentorSubMajor");
		
		
		

		
		UserSearchMentorDao userSearchMentorDao = new UserSearchMentorDao();
		ArrayList<UserSearchMentorDto> userSearchMentorDto = userSearchMentorDao.searchMentorProfile(mentorAddress , mentorMajor, mentorSubMajor);
		
		
		request.setAttribute("mentorSearchList", userSearchMentorDto);
		
		return 0;
	}

}
