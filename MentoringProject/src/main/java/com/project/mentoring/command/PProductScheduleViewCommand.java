package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;

public class PProductScheduleViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int pk = Integer.parseInt(request.getParameter("productpk"));
		PaymentDao dao = new PaymentDao();
		ArrayList<PaymentDto> dto = dao.productSchedulelist(pk);
		request.setAttribute("ScheduleSelect", dto);
	}

}
