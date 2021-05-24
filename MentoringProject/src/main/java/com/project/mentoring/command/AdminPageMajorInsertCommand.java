package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminMajorListDao;

public class AdminPageMajorInsertCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String majorName = request.getParameter("majorname");
		
		AdminMajorListDao adminMajorInsertDao = new AdminMajorListDao();
		int adminMajorInsertResult = adminMajorInsertDao.adminMajorInsert(majorName);
		
		return adminMajorInsertResult;
	}

}
