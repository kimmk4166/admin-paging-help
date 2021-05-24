package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminMajorListDao;
import com.project.mentoring.dto.AdminMajorListDto;

public class AdminPageMajorListShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		AdminMajorListDao adminMajorListDao = new AdminMajorListDao();
		ArrayList<AdminMajorListDto> majorDto = adminMajorListDao.majorList();
		request.setAttribute("majorList", majorDto);

	}

}
