package com.project.mentoring.command;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorTokenUpdateDao;

public class MentorTokenUpdateCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String token = randomToken();
		

		String strPaymentPk = request.getParameter("paymentPk");
		int paymentPk = Integer.parseInt(strPaymentPk);
		
		MentorTokenUpdateDao mentorTokenUpdateDao = new MentorTokenUpdateDao();
		int tokenUpdateResult = mentorTokenUpdateDao.tokenUpdate(token, paymentPk);
		System.out.println("업데이트 완료");
		System.out.println(token);
		System.out.println(tokenUpdateResult);
		return tokenUpdateResult;
	}
	
	public String randomToken() {
		
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		
		for(int i=0;i<6;i++){
		    if(random.nextBoolean()){
		        stringBuffer.append((char)((int)(random.nextInt(26))+97));
		    }else{
		        stringBuffer.append((random.nextInt(10))); 
		    }
		}
		
		String token = stringBuffer.toString();
		
		return token;
		
	}

}
