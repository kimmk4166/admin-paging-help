package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;

public class PProductSelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PaymentDao dao = new PaymentDao();
		ArrayList<PaymentDto> dto = dao.ProductSelect();
		request.setAttribute("ProductSelect", dto);
	}

}
