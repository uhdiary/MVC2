package paper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paper.model.service.PaperService;
import paper.model.vo.Paper;

/**
 * Servlet implementation class PaperUpdateServlet
 */
@WebServlet("/pus")
public class PaperUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전송값에 한글이 있을 경우 인코팅처리
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
	    int paper_no = Integer.parseInt(request.getParameter("paper_no"));
	    
	    String paper_title = request.getParameter("ptitle");
		String paper_content = request.getParameter("pcontent");
		
		Paper paper = new Paper(paper_title, paper_content, paper_no);
	
		int result = new PaperService().updatePaper(paper);

		if (result > 0) {
			response.sendRedirect("/hotel/pls");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("view/paper/paperError.jsp");
			request.setAttribute("message", "실패");
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
