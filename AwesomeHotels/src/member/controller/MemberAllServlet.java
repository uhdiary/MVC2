package member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/mall")
public class MemberAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자용 전체 회원조회 서비스처리용 컨트롤러
		response.setContentType("text/html; charset=uft-8");
		
		String user_code = request.getParameter("user_code");
		
		Map<String, Member> memberMap = new MemberService().selectAll(user_code);
		
		RequestDispatcher view = null;
		if(memberMap != null){
			HttpSession session = request.getSession(); 
		        
	        session.setAttribute("memberMap", memberMap);
	        
	        
			view = request.getRequestDispatcher("view/member/memberListView.jsp");
			request.setAttribute("memberMap", memberMap);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("view/main/main.html");
			request.setAttribute("memberMap", memberMap);
			view.forward(request, response);
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
