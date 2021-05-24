package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementListDao;


public class AdminPageAnnouncementModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String noticetitle=request.getParameter("noticetitle");
		String noticetext=request.getParameter("noticetext");
		String noticepk=request.getParameter("noticepk");
		
		AdminAnnouncementListDao dao=new AdminAnnouncementListDao();

		dao.update(noticetitle, noticetext, noticepk);
		
	}

}