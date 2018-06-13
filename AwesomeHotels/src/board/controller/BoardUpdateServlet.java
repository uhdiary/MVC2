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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/bupdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
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
		
	    int boardNo = Integer.parseInt(request.getParameter("boardno"));
	    
	    String boardTitle = request.getParameter("btitle");
		String boardContent = request.getParameter("bcontent");
		
		Board board = new Board(boardTitle, boardContent, boardNo);
	
		int result = new BoardService().updateBoard(board);

		if (result > 0) {
			response.sendRedirect("/hotel/blist");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("view/board/boardError.jsp");
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
