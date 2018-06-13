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
		// ���ǻ��� ����ȸ ���񽺿� ��Ʈ�ѷ�
		response.setContentType("text/html; charset=utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardno"));
		
		//��ȸ�� 1���� ó��
		BoardService bservice = new BoardService();
		int result = bservice.updateReadCount(boardNo);
		
		//�۹�ȣ�� ���ǻ��ױ� ��ȸ
		Board board = bservice.selectOne(boardNo);
		
		RequestDispatcher view = null;
		if(board != null){
			view = request.getRequestDispatcher("view/board/boardDetailView.jsp");
			request.setAttribute("board", board);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("view/board/boardError.jsp");
			request.setAttribute("message", "������ ����ȸ ����");
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
