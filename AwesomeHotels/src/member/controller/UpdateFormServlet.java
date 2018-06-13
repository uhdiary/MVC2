package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet("/upform")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 조회한 회원정보를 form 으로 전달(포워딩)하는 컨트롤러
		String user_id = request.getParameter("user_id");
		
		Member member = new MemberService().selectMember(user_id);
		
		RequestDispatcher view = null;
		if(member != null){
			view = request.getRequestDispatcher("view/member/updateForm.jsp");
			request.setAttribute("member", member);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("view/member/memberError.jsp");
			request.setAttribute("message", "회원정보 수정폼 출력서비스 요청 실패");
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
