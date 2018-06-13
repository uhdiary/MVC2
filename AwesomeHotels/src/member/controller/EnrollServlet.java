package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		String hotel_name = request.getParameter("hotel_name");
		
		Member member = new Member(user_id, user_pwd, user_name, user_no, phone, phone_o, phone_t, postal, address, email, email_o, gender, user_code, hotel_name, null);
		
		int result = new MemberService().intsertMember(member);

		if(result > 0){
			response.sendRedirect("/hotel/view/member/enrollSuccess.jsp");
		}else{
			response.sendRedirect("/hotel/view/member/enrollFail.jsp");
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
