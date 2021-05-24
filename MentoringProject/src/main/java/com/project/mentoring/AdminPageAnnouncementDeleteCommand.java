package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementListDao;


public class AdminPageAnnouncementDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String noticepk=request.getParameter("noticepk");
		
		AdminAnnouncementListDao dao=new AdminAnnouncementListDao();
		dao.delete(noticepk);
	}

}