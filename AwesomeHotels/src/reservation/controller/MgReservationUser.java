package reservation.controller;

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
 * Servlet implementation class MgReservationUser
 */
@WebServlet("/mruser")
public class MgReservationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgReservationUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		
		
		Member member = new MemberService().selectMember(user_id);
		
		
		RequestDispatcher rd = null;
		
		if(member != null){
			rd = request.getRequestDispatcher("view/mgreservation/mruserdetail.jsp");
			request.setAttribute("member", member);
			rd.forward(request, response);
		}else{
		
			rd = request.getRequestDispatcher("view/member/memberError.jsp"); 
		
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
