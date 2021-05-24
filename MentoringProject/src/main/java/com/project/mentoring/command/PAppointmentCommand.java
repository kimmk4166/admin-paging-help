package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;
import com.project.mentoring.dto.ShareVar;

public class PAppointmentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int productpk = Integer.parseInt(request.getParameter("productpk"));
		ShareVar.productpk = productpk;
		//System.out.println(ShareVar.productpk);
		PaymentDao dao = new PaymentDao();
		PaymentDto dto = dao.PAppointment(productpk);
		
		request.setAttribute("Appointment", dto);
	}

}
