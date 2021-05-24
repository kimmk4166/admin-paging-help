package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminUserListDao;
import com.project.mentoring.dto.AdminUserListDto;


public class AdminPageUserListShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminUserListDao adminUserListDao = new AdminUserListDao();
		ArrayList<AdminUserListDto> userDto = adminUserListDao.userList();
		request.setAttribute("userList", userDto);

	}

}
