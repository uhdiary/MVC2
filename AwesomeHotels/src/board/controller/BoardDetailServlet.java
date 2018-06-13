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
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/bdetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문의사항 상세조회 서비스용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardno"));
		
		//조회수 1증가 처리
		BoardService bservice = new BoardService();
		int result = bservice.updateReadCount(boardNo);
		
		//글번호로 문의사항글 조회
		Board board = bservice.selectOne(boardNo);
		
		RequestDispatcher view = null;
		if(board != null){
			view = request.getRequestDispatcher("view/board/boardDetailView.jsp");
			request.setAttribute("board", board);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("view/board/boardError.jsp");
			request.setAttribute("message", "공지글 상세조회 실패");
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
