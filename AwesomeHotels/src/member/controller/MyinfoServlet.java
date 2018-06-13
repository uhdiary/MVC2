package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyinfoServlet
 */
@WebServlet("/myinfo")
public class MyinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 아이디를 이용한 회원정보 조회용 컨트롤러
			//1. 인코딩 처리
			response.setContentType("text/html; charset=utf-8");
			
			//2. 전송값(parameter) 추출해서 변수에 기록
			String user_id = request.getParameter("user_id");
			
			//3. 모델용 서비스클래스의 처리 메소드로 넘기고, 결과받기
			Member member = new MemberService().selectMember(user_id);
			
			//4. 받은 결과에 대한 성공/실패 페이지 내보내기
			RequestDispatcher rd = null;
			if(member != null){
				rd = request.getRequestDispatcher("view/member/memberDetailView.jsp");
				request.setAttribute("member", member);
				rd.forward(request, response);
			}else{
				request.setAttribute("message", "회원정보 조회 실패");
				rd = request.getRequestDispatcher("view/member/memberError.jsp"); //서블릿은 무조건 루트안에서 실행
				//절대경로 사용 못 함. 상대경로만 사용할 수 있음.
				rd.forward(request, response);
			}
			
		
	}

}
