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
			// ���̵� �̿��� ȸ������ ��ȸ�� ��Ʈ�ѷ�
			//1. ���ڵ� ó��
			response.setContentType("text/html; charset=utf-8");
			
			//2. ���۰�(parameter) �����ؼ� ������ ���
			String user_id = request.getParameter("user_id");
			
			//3. �𵨿� ����Ŭ������ ó�� �޼ҵ�� �ѱ��, ����ޱ�
			Member member = new MemberService().selectMember(user_id);
			
			//4. ���� ����� ���� ����/���� ������ ��������
			RequestDispatcher rd = null;
			if(member != null){
				rd = request.getRequestDispatcher("view/member/memberDetailView.jsp");
				request.setAttribute("member", member);
				rd.forward(request, response);
			}else{
				request.setAttribute("message", "ȸ������ ��ȸ ����");
				rd = request.getRequestDispatcher("view/member/memberError.jsp"); //������ ������ ��Ʈ�ȿ��� ����
				//������ ��� �� ��. ����θ� ����� �� ����.
				rd.forward(request, response);
			}
			
		
	}

}
