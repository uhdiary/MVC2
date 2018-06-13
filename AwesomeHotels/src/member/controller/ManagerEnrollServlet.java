package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ManagerEnrollServlet
 */
@WebServlet("/menroll")
public class ManagerEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerEnrollServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 회원가입 처리용 컨트롤러
request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		String user_no = request.getParameter("user_no") + "-" + request.getParameter("user_one");
		String phone = request.getParameter("phone");
		String phone_o = request.getParameter("phone_o");
		String phone_t = request.getParameter("phone_t");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String email_o = request.getParameter("email_o");		
		char gender = request.getParameter("gender").charAt(0);
		String user_code = request.getParameter("user_code");
		
		Member member = new Member(user_id, user_pwd, user_name, user_no, phone, phone_o, phone_t, postal, address, email, email_o, gender, user_code, null);
		
		int result = new MemberService().insertManager(member);

		if(result > 0){
			response.sendRedirect("/hotel/view/manager/enrollSuccess.html");
		}else{
			response.sendRedirect("/hotel/view/member/enrollFail.html");
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
