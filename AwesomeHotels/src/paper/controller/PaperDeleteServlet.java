package paper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paper.model.service.PaperService;

/**
 * Servlet implementation class PaperDeleteServlet
 */
@WebServlet("/pds")
public class PaperDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 공지글 삭제 서비스 처리용 컨트롤러
				response.setContentType("text/html; charset=utf-8");
				int paper_no = Integer.parseInt(request.getParameter("paper_no"));
				int result = new PaperService().deletePaper(paper_no);
				
				if(result > 0){
					response.sendRedirect("/hotel/pls");
				}else{
					RequestDispatcher view = request.getRequestDispatcher("view/paper/paperError.jsp");
					request.setAttribute("message", "공지글 삭제 실패");
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
