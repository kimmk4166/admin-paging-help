package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;

public class PMentorProductListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PaymentDao dao = new PaymentDao();
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		ArrayList<PaymentDto> dto = dao.ProductList(userPk);
		request.setAttribute("ProductList", dto);
	}

}
