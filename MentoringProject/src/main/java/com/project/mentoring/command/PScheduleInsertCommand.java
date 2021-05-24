package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;

public class PScheduleInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strid = request.getParameter("productpk");
		int id = Integer.parseInt(strid);
		String startday = request.getParameter("startday");
		String endday = request.getParameter("endday");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		PaymentDao dao=new PaymentDao();
		dao.creatschedule(startday, endday, starttime, endtime, id);
	}

}
