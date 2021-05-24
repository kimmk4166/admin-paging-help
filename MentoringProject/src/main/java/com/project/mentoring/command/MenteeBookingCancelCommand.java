package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;

public class MenteeBookingCancelCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String paymentpk = request.getParameter("paymentpk");
		
		
		
		PaymentDao dao = new PaymentDao();
		dao.MenteeBookingCancel(paymentpk);
	}

}
