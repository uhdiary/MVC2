package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/blist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardListServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");

				// 공지글 전체 조회용 컨트롤러
				response.setContentType("text/html; charset=utf-8");
				
				BoardService bservice = new BoardService();
				
				int currentPage = 1;
				int limit = 10;	//한 페이지에 10개씩 출력할 경우
				
				String keyword = null;
				String sitem = null;
				
				if(request.getParameter("page") != null)
					currentPage = Integer.parseInt(request.getParameter("page"));
				if(request.getParameter("keyword") != null)
					keyword = request.getParameter("keyword");
				if(request.getParameter("sitem") != null)
					sitem = request.getParameter("sitem");
				int listCount = 0;
				ArrayList<Board> list = null;
				//ArrayList<Board> list = bservice.selectList(); 전체
				//ArrayList<Board> list = bservice.selectList(currentPage, limit);	// 현재페이지
				
				
				if(keyword != null && sitem.equals("title")){
					listCount = bservice.getListTitleCount(keyword);
					list = new BoardService().selectBoardTitleList(currentPage, limit, keyword);
				}else if(keyword != null && sitem.equals("writer")){
					listCount = bservice.getListWriterCount(keyword);
					list = new BoardService().selectBoardWriterList(currentPage, limit, keyword);
				} else{
					listCount = bservice.getListCount();
					list = new BoardService().selectBoardList(currentPage, limit);
				}
				
				
				//총 페이지 수 계산 : 목록이 최소 1개일 때 1page 로 처리
				//한 페이지 만들려면 0.9를 더함
				int maxPage = (int)((double)listCount / limit + 0.9);
				
				//현재 페이지에 보여질 시작 페이지 값(1, 11, 21, 31, ....)
				//계간식을 만들어 준것
				int startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;
				//현재 페이지에 보여질 마지막 페이지 값 (10, 20, 30, ....)
				int endPage = startPage + limit - 1;
				
				if(maxPage < endPage)
					endPage = maxPage;
			
				RequestDispatcher view = null;
				
				
					view = request.getRequestDispatcher("view/board/boardListView.jsp");
					request.setAttribute("list", list);
					request.setAttribute("listCount", new Integer(listCount));
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("keyword", keyword);
					request.setAttribute("sitem", sitem);
					view.forward(request, response);
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
