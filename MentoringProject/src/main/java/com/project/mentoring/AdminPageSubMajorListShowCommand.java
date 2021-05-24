package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminSubMajorListDao;
import com.project.mentoring.dto.AdminSubMajorListDto;

public class AdminPageSubMajorListShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strMajorPk = request.getParameter("majorpk");
		
		int majorPk = Integer.parseInt(strMajorPk);

		AdminSubMajorListDao adminSubMajorListDao = new AdminSubMajorListDao();
		ArrayList<AdminSubMajorListDto> subMajorDto = adminSubMajorListDao.subMajorList(majorPk);
		request.setAttribute("subMajorList", subMajorDto);
	}

}
