package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;

public class PPaymentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		PaymentDao dao = new PaymentDao();
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userpk = Integer.parseInt(strUserPk);
		
		PaymentDto dto = dao.PPayment(userpk);
		
		request.setAttribute("Payment", dto);
	}

}
