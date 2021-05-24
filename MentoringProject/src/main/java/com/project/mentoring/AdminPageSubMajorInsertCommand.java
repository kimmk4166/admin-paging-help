package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminSubMajorListDao;

public class AdminPageSubMajorInsertCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String subMajorName = request.getParameter("submajorname");
		
		String strMajorPk = request.getParameter("majorpk");
		
		
		int majorPk = Integer.parseInt(strMajorPk);
		
		AdminSubMajorListDao adminSubMajorInsertDao = new AdminSubMajorListDao();
		int adminSubMajorInsertResult = adminSubMajorInsertDao.adminSubMajorInsert(majorPk,subMajorName);
		
		return adminSubMajorInsertResult;
	}

}
