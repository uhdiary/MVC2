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
 * Servlet implementation class BoradRepalyWrite
 */
@WebServlet("/prws")
public class PaperReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int paper_no = Integer.parseInt(request.getParameter("paper_no"));
		
		
		
		
		String paper_title = "Re: "+request.getParameter("ptitle");
		String paper_write = request.getParameter("pwriter");
		String paper_content1 = request.getParameter("pcontent");
		String paper_content = paper_content1.substring(paper_content1.indexOf(">") + 1, paper_content1.lastIndexOf("<"));
		int paper_reply_lev = Integer.parseInt(request.getParameter("setp"));
		int paper_reply_seq = 0;
		
		
		
		System.out.println(paper_title);
		
				 paper_reply_seq = Integer.parseInt(request.getParameter("seq"));
	
		
		
		Paper paper = new Paper(paper_title, paper_write, paper_content, paper_no, paper_reply_lev, paper_reply_seq);
		
		
		
		int result = new PaperService().replyPaper(paper);
			
			
			if (result > 0) {
				response.sendRedirect("/hotel/pls");
			} else {
				RequestDispatcher view1 = request.getRequestDispatcher("view/paper/paperError.jsp");
				request.setAttribute("message", "");
				view1.forward(request, response);
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
