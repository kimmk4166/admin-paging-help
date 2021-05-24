package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.PaymentDao;

public class MenteeMentoringReviewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String reviewtitle = request.getParameter("reviewtitle");
		String reviewtext = request.getParameter("reviewtext");
		String strreviewscore = request.getParameter("reviewscore");
		int reviewscore = Integer.parseInt(strreviewscore);
		String paymentpk = request.getParameter("paymentpk");
		
		System.out.println(paymentpk);
		
		// int userpk = session.getParameter("USERPK");
		// 병합시 유저피케이 넣어주기
		// 완료
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userpk = Integer.parseInt(strUserPk);
		

		PaymentDao dao = new PaymentDao();
		dao.MMenteeMentoringReview(userpk, reviewtitle, reviewtext, reviewscore, paymentpk);
	}

}
