package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;
import com.project.mentoring.dto.ShareVar;

public class PProductScheduleSelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		ShareVar.schedulepk = Integer.parseInt(request.getParameter("schedulepk"));
		System.out.println(ShareVar.schedulepk);
		PaymentDao dao = new PaymentDao();
		PaymentDto dto = dao.beforepayment(ShareVar.schedulepk);
		
		request.setAttribute("Paymentdata", dto);
	}

}
