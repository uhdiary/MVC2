package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet("/mdel")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원탈퇴 처리용 컨트롤러
		String user_id = request.getParameter("user_id");
		
		int result = new MemberService().deleteMember(user_id);
		
		System.out.println(result);
		if(result > 0){
			response.sendRedirect("/hotel/logout");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("view/member/memberError.jsp");
			request.setAttribute("message", "회원정보 수정 실패!!");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
