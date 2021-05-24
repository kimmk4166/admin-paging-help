package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementListDao;
import com.project.mentoring.dto.AdminAnnouncementListDto;


public class AdminPageAnnouncementContentCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String noticepk=request.getParameter("noticepk");
		AdminAnnouncementListDao dao=new AdminAnnouncementListDao();
		AdminAnnouncementListDto dto=dao.contentView(noticepk);
		
		request.setAttribute("adminAnnouncementContentPage", dto);
	}

}