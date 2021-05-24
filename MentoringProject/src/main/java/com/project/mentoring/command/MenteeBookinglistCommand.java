package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.MenteeDto;

public class MenteeBookinglistCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//String booking = "감자";
				String booking = request.getParameter("booking");			
				if(request.getParameter("booking") == null) {
					booking = "null";
				}
				System.out.println(booking);
				PaymentDao dao = new PaymentDao();
				HttpSession session = request.getSession();
				String strUserPk = (String) session.getAttribute("userpk");
				int userpk = Integer.parseInt(strUserPk);
				ArrayList<MenteeDto> dto = dao.MMenteeBookinglist(booking,userpk);

				
				request.setAttribute("MenteeBookingList", dto);
	}

}
