package com.project.mentoring.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.command.AdminPageMajorInsertCommand;
import com.project.mentoring.command.AdminPageMajorListShowCommand;
import com.project.mentoring.command.AdminPageSubMajorInsertCommand;
import com.project.mentoring.command.AdminPageSubMajorListShowCommand;
import com.project.mentoring.command.AdminPageUserListShowCommand;
import com.project.mentoring.command.AdminPageAnnouncementContentCommand;
import com.project.mentoring.command.AdminPageAnnouncementDeleteCommand;
import com.project.mentoring.command.AdminPageAnnouncementListCommand;
import com.project.mentoring.command.AdminPageAnnouncementModifyCommand;
import com.project.mentoring.command.AdminPageAnnouncementWriteCommand;
import com.project.mentoring.command.Command;
import com.project.mentoring.command.HelpPageShowCommand;
import com.project.mentoring.command.HomePageMentorListShowCommand;
import com.project.mentoring.command.IntCommand;
import com.project.mentoring.command.LogoutCommand;
import com.project.mentoring.command.MenteeBookingCancelCommand;
import com.project.mentoring.command.MenteeBookinglistCommand;
import com.project.mentoring.command.MenteeMentoringListCommand;
import com.project.mentoring.command.MenteeMentoringReviewCommand;
import com.project.mentoring.command.MenteeReviewListCommand;
import com.project.mentoring.command.MentorProfileInsertCommand;
import com.project.mentoring.command.MentorProfileIntroduceInsertCommand;
import com.project.mentoring.command.MentorProfileSubMajorFindCommand;
import com.project.mentoring.command.MentorScheduledCompleteListShowCommand;
import com.project.mentoring.command.MentorScheduledListShowCommand;
import com.project.mentoring.command.MentorSelectMentorPkCommand;
import com.project.mentoring.command.MentorTokenUpdateCommand;
import com.project.mentoring.command.PAppointmentCommand;
import com.project.mentoring.command.PMentorProductListCommand;
import com.project.mentoring.command.PMentorProductPageCommand;
import com.project.mentoring.command.PPaymentCommand;
import com.project.mentoring.command.PProductScheduleSelectCommand;
import com.project.mentoring.command.PProductScheduleViewCommand;
import com.project.mentoring.command.PScheduleInsertCommand;
import com.project.mentoring.command.UserCheckSelectCommand;
import com.project.mentoring.command.UserCheckUpdateToMentorCommand;
import com.project.mentoring.command.UserFindIdByEmailCommand;
import com.project.mentoring.command.UserFindIdByPhoneCommand;
import com.project.mentoring.command.UserFindPwCommand;
import com.project.mentoring.command.UserLoginPageSelectCommand;
import com.project.mentoring.command.UserSearchPageShowCommand;
import com.project.mentoring.command.UserSignUpPageInsertCommand;
import com.project.mentoring.dao.UserLoginDao;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()");
		actionDo(request,response);

	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()");
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		
		Command command = null;
		IntCommand intCommand = null;
		
		System.out.println(com);
		
		switch(com) {
		
		case("/logout.do"):
			command = new LogoutCommand();
			command.execute(request, response);
		
		case("/home.do"):
			command = new HomePageMentorListShowCommand();
			command.execute(request, response);
			viewPage = "visitorPage.jsp";
			break;
			
		case("/help.do"):
			command = new HelpPageShowCommand();
			command.execute(request, response);
			viewPage = "helpPage.jsp";
		break;
			
		//-- adminPage 의 *.do
		case("/adminPage.do"):
			viewPage ="adminPage.jsp";
			break;
			
		case("/AdminAnnouncementList.do"):
			command=new AdminPageAnnouncementListCommand();
			command.execute(request, response);
			viewPage="adminAnnouncementPage.jsp";
			break;
			
		case("/AdminAnnouncementWrite_view.do"):
			viewPage="adminAnnouncementWritePage.jsp";
			break;
			
		case("/AdminAnnouncementWrite.do"):
			System.out.println("작성 들어옴");
			command=new AdminPageAnnouncementWriteCommand();
			command.execute(request, response);
			viewPage="AdminAnnouncementList.do";
			break;
			
		case("/AdminAnnouncementContent.do"):
			command=new AdminPageAnnouncementContentCommand();
			command.execute(request, response);
			viewPage="adminAnnouncementContentPage.jsp";
			break;
			
		case("/AdminAnnouncementModify.do"):
			System.out.println("수정 들어옴");
			command=new AdminPageAnnouncementModifyCommand();
			command.execute(request, response);
			viewPage="AdminAnnouncementList.do";
			break;
			
		case("/AdminAnnouncementDelete.do"):
			command=new AdminPageAnnouncementDeleteCommand();
			command.execute(request, response);
			viewPage="AdminAnnouncementList.do";
			break;
			
		case("/adminUserListShowPage.do"):
			command = new AdminPageUserListShowCommand();
			command.execute(request, response);
			viewPage = "adminUserListShowPage.jsp";
			break;
			
		case("/adminMajorListShowPage.do"):
			command = new AdminPageMajorListShowCommand();
			command.execute(request, response);
			viewPage = "adminManagementMajor.jsp";
			break;
			
		case("/adminInsertMajor.do"):
			intCommand = new AdminPageMajorInsertCommand();
			int majorInsertResult = intCommand.execute(request, response);
			
			if(majorInsertResult == 1) {
				request.setAttribute("majorInsertResult", majorInsertResult);
				viewPage="adminManagementMajorInsertPage.jsp";
			}else {
				request.setAttribute("majorInsertResult", majorInsertResult);
				viewPage="adminManagementMajorInsertPage.jsp";
			}
			break;
		case("/adminSubMajorListShowPage.do"):
			command = new AdminPageSubMajorListShowCommand();
			command.execute(request, response);
			viewPage = "adminManagementSubMajor.jsp";
			break;
			
		case("/adminInsertSubMajor.do"):
			intCommand = new AdminPageSubMajorInsertCommand();
			int subMajorInsertResult = intCommand.execute(request, response);
			
			if(subMajorInsertResult == 1) {
				request.setAttribute("subMajorInsertResult", subMajorInsertResult);
				viewPage="adminManagementSubMajorInsertPage.jsp";
				
			}else {
				request.setAttribute("subMajorInsertResult", subMajorInsertResult);
				viewPage="adminManagementSubMajorInsertPage.jsp";
				
			}
			break;
		case("/adminAnnouncementPage.do"):
			command = new AdminPageAnnouncementListCommand();//수정-showcommand 삭제함
			command.execute(request, response);
			viewPage="adminAnnouncementPage.jsp";
			break;
			
			
		// -- userPage 의 *.do
		case("/userLoginPage.do"):
			intCommand = new UserLoginPageSelectCommand();
			
			
			int loginResult = intCommand.execute(request, response);
			
			if(loginResult == 1) {
				command = new HomePageMentorListShowCommand();
				command.execute(request, response);
				request.setAttribute("loginResult", loginResult);
				
				String userId = request.getParameter("userid");
				String userpk = UserLoginDao.userPk;
					
				HttpSession session = request.getSession();
				session.setAttribute("userid", userId);
				session.setAttribute("userpk", userpk);
				
				
				System.out.println("로그인 성공! ");
				
				UserCheckSelectCommand userCheckSelectCommand = new UserCheckSelectCommand();
				int userCheck = userCheckSelectCommand.execute(request, response);
				session.setAttribute("userCheck", userCheck);
				// 로그인 성공후 멘토페이지 일반 유저 페이지 이동 여부 결정
				if(userCheck == 1) {
					
					System.out.println("멘토페이지로 이동");
					viewPage = "mentorPage.jsp";
				}else {
					System.out.println("일반 유저 페이지로 이동");
					viewPage = "homePage.jsp";
				}
				
				
			}else {
				request.setAttribute("loginResult", loginResult);
				viewPage = "visitorPage.jsp";
				
				
				System.out.println("로그인 실패! ");
				
				
			}
			break;
		
		case("/userSignUpPage.do"):
			intCommand = new UserSignUpPageInsertCommand();
			int signUpResult = intCommand.execute(request,response);
			
			if(signUpResult == 1) {
				
				viewPage = "visitorPage.jsp";
				
			}else {
				viewPage = "userSignUpPage.jsp";
			}
			
			break;
			
		case("/userFindIdByEmail.do"):
			intCommand = new UserFindIdByEmailCommand();
			int findIdByEmailResult = intCommand.execute(request, response);
			
			if(findIdByEmailResult  == 1) {
				
				request.setAttribute("findIdResult", findIdByEmailResult);
				viewPage="userIdFindResult.jsp";
				
			}else {
				request.setAttribute("findIdResult", findIdByEmailResult);
				System.out.println("id찾기 오류");
				viewPage="userFindId.jsp";
			}	
			
			break;
			
		case("/userFindIdByPhone.do"):
			intCommand = new UserFindIdByPhoneCommand();
		
			int findIdByPhoneResult = intCommand.execute(request, response);
			
			if(findIdByPhoneResult  == 1) {
				request.setAttribute("findIdResult", findIdByPhoneResult);
				viewPage="userIdFindResult.jsp";
				
			}else {
				request.setAttribute("findIdResult", findIdByPhoneResult);
				System.out.println("id찾기 오류");
				viewPage="userFindId.jsp";
				
			}
			break;
		case("/userFindPwResult.do"):
			intCommand = new UserFindPwCommand();
			int findPwResult = intCommand.execute(request, response);
			if(findPwResult == 1) {
				
				request.setAttribute("findPwResult", findPwResult);
				viewPage="userFindPwResult.jsp";
				
			}else {
				
				request.setAttribute("findPwResult", findPwResult);
				viewPage="userFindPw.jsp";
			}
			
			break;
			
		case("/userShowSearchListPage.do"):
			intCommand = new UserSearchPageShowCommand();
			int searchResult = intCommand.execute(request, response);
			
			if(searchResult == 0) {
				HttpSession session = request.getSession();
				request.setAttribute("userCheck", session.getAttribute("userCheck"));
				viewPage = "searchPage.jsp";
				
			}else {
				
				viewPage = "visitorPage.jsp";
			}
			
			break;
			
		// -- mentorPage 의 *.do
		case("/mentorProfile.do"):
			intCommand = new MentorProfileInsertCommand();
		
			int mentorProfileInsertResult = intCommand.execute(request, response);
			
			if(mentorProfileInsertResult == 1) {
				
				
				System.out.println("프로필 등록 성공");
				viewPage = "userBeMentorPage2.jsp";
				
			}else {
			
				System.out.println("프로필 등록 실패");
				viewPage = "userBeMentorPage.jsp";
			}
			break;
		
		case("/mentorProfileMajor.do"):
			intCommand = new MentorProfileSubMajorFindCommand();
			MentorSelectMentorPkCommand mentorSelectMentorPkCommand = new MentorSelectMentorPkCommand();
			int mentorPk = mentorSelectMentorPkCommand.execute(request, response);
			
			int majorPk = intCommand.execute(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("mentorPk", mentorPk);
			
			request.setAttribute("majorPk", majorPk);
			viewPage = "userBeMentorPage3.jsp";

			break;
			
		case("/mentorProfileIntroduce.do"):
			intCommand = new MentorProfileIntroduceInsertCommand();
			
			int mentorProfileIntroduceResult = intCommand.execute(request, response);
			
			if(mentorProfileIntroduceResult == 1) {
				System.out.println("상품 정보 등록 성공");
				viewPage="userBeMentorPage4.jsp";
			}else {
				System.out.println("상품 정보 등록 실패");
				viewPage="userBeMentorPage3.jsp";
			}
			
			break;
			
		
		
		case("/userCheckUpdate.do"):
			intCommand = new UserCheckUpdateToMentorCommand();
		
			int userCheckUpdateToMentorResult = intCommand.execute(request, response);
			
			if(userCheckUpdateToMentorResult == 1) {
				
				viewPage="mentorPage.jsp";
				
			}else {
				
				viewPage="userBeMentorPage4";
			}
		 break;
		 
		case("/mentorScheduledList.do"):
			command = new MentorScheduledListShowCommand();
			command.execute(request, response);
			viewPage="mentorScheduledList.jsp";
			break;
			
		case("/mentorScheduledCompleteList.do"):
			System.out.println("업데이트 컨트롤러 들어옴");
			intCommand = new MentorTokenUpdateCommand();
			int tokenSendResult = intCommand.execute(request, response);
			
			if(tokenSendResult == 1) {
				command = new MentorScheduledCompleteListShowCommand();
				command.execute(request, response);
				viewPage="mentorScheduledCompletePage.jsp";
				
			}else {
				viewPage = "mentorScheduledList.jsp";
			}
			break;
		case("/mentorScheduledCompleteListPage.do"):
			command = new MentorScheduledCompleteListShowCommand();
			command.execute(request, response);
			viewPage="mentorScheduledCompletePage.jsp";

			break;
		 
		case("/mentorProductList.do"):
			System.out.println("멘토 마이페이지 product");
			command=new PMentorProductListCommand();
			command.execute(request, response);
			viewPage="mentorProductList.jsp";
			break;
			//
			
		case("/mentorProductPage.do"):
			command=new PMentorProductPageCommand();
			command.execute(request, response);
			viewPage="mentorProductPage.jsp";
			break;
			// -> 뭔가 구성이 이상해
			
		case("/mentorScheduleInsert.do"):
			System.out.println("멘토 product 페이지");
			command=new PMentorProductListCommand();
			command.execute(request, response);
			viewPage="productInsertSchedule.jsp";
			break;
			
			//
			
		case("/insertScheduleView.do"):
			System.out.println("스케쥴 입력 선택");
			viewPage="insertScheduleView.jsp";
			break;
			
			//-> 일단 없는 걸로 체크
			
		case("/insertScheduleAction.do"):
			System.out.println("스케쥴 입력");
			command=new PScheduleInsertCommand();
			command.execute(request, response);
			viewPage="/mentorProductPage.do";
			break;
			
			
		// 예약 관련 한 .do
		case("/appointment.do"):
			System.out.println("product 클릭 pageview");
			command = new PAppointmentCommand();
			command.execute(request, response);
			viewPage="appointment.jsp";
			break;
			
			//
			
		case("/paymentScheduleSelect.do"):
			System.out.println("예약하기 클릭 calendarview");
			command = new PProductScheduleViewCommand();
			command.execute(request, response);
			viewPage = "paymentScheduleSelect.jsp";
			break;
			
			//
			
		case("/paymentDatatView.do"):
			System.out.println("payment 전 정보 view");
			command = new PProductScheduleSelectCommand();
			command.execute(request, response);
			viewPage = "paymentDataView.jsp";
			break;
			
			//
			
		case("/paymentSuccess.do"):
			System.out.println("payment db insert process");
			command = new PPaymentCommand();
			command.execute(request, response);
			viewPage = "paymentSuccess.jsp";
			break;
			//
			
		case("/menteeBookingList.do"):
			System.out.println("멘티예약리스트로가기");
			command = new MenteeBookinglistCommand();
			command.execute(request, response);
			viewPage = "menteeBookingList.jsp";
			break;
			
			//
			
		case("/menteeBookingCancel.do"):
			System.out.println("멘티가 예약 취소");
			command = new MenteeBookingCancelCommand();
			command.execute(request, response);
			viewPage = "menteeBookingList.do";
			break;
			
			//
			
		case("/menteeMentoringList.do"):
			System.out.println("멘티예약완료리스트로가기");
			command = new MenteeMentoringListCommand();
			command.execute(request, response);
			viewPage = "menteeMentoringList.jsp";
			break;
			
			//
			
		case("/menteeMentoringReview.do"):
			System.out.println("멘티리뷰작성 가기");
			command = new MenteeMentoringReviewCommand();
			command.execute(request, response);
			viewPage = "menteeReviewList.do";
			break;
			
			//
			
		case("/menteeReviewList.do"):
			System.out.println("멘티리뷰리스트 가기");
			command = new MenteeReviewListCommand();
			command.execute(request, response);
			viewPage = "menteeReviewList.jsp";
			break;	
			
			//
		 
			
//		그외의 확인용 jsp .do 완료시에는 지우기
		case("/sessionCheck.do"):
			
			viewPage="sessionCheck.jsp";
			
		
		}
		
		
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		
	}

}//-- end Line
