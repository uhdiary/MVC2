package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α׾ƿ� ó���� ��Ʈ�ѷ�
		HttpSession session = request.getSession(false); //�α׾ƿ������� ������ �����Ǹ� �ȵǹǷ� �ݵ�� false
		if(session != null){
			session.invalidate();
			response.sendRedirect("/hotel/view/main/main.html");
		}
	}

}
