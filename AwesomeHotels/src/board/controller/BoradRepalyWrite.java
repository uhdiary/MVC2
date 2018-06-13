package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoradRepalyWrite
 */
@WebServlet("/brwrite")
public class BoradRepalyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoradRepalyWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int boardNo=Integer.parseInt(request.getParameter("boardno"));
		
		
		
		
		String boardTitle = "Re: "+request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWrite");
		String boardContent = request.getParameter("boardContent");
		int boardReplyLev = Integer.parseInt(request.getParameter("setp"));
		int boardReplySeq = 0;
		
		
				 boardReplySeq = Integer.parseInt(request.getParameter("seq"));
	
		
		
		Board reboard = new Board(boardTitle, boardWriter, boardContent, boardNo, boardReplyLev,boardReplySeq);
		
		int result = new BoardService().replyBoard(reboard);
			
			
			if (result > 0) {
				response.sendRedirect("/hotel/blist");
			} else {
				RequestDispatcher view1 = request.getRequestDispatcher("view/board/boardError.jsp");
				request.setAttribute("message", "½ÇÆÐ");
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
