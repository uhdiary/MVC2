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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 수정 처리용 컨트롤러
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    //1. 전송값에 한글이 있을 경우 인코딩처리
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		String user_no = request.getParameter("user_no");
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
		
		int result = new MemberService().updateMember(member); 
		
		if(result > 0){
			response.sendRedirect("/hotel/myinfo?user_id=" + user_id);
		}else{
			 RequestDispatcher view = request.getRequestDispatcher("view/member/memberError.jsp");
             request.setAttribute("message", "회원정보 수정 실패!!");
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
