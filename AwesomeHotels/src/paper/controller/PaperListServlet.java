package paper.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paper.model.service.PaperService;
import paper.model.vo.Paper;

/**
 * Servlet implementation class PaperListServlet
 */
@WebServlet("/pls")
public class PaperListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 전제 조회용 컨트롤러
				response.setContentType("text/html; charset=utf-8");
				

				PaperService pservice = new PaperService();
				
				int currentPage = 1;
				int limit = 10;		//한 페이지에 10개씩 출력할 경우
				
				 String keyword = null;
		            String sitem = null;
		            
		            if(request.getParameter("page") != null)
		               currentPage = Integer.parseInt(request.getParameter("page"));
		            if(request.getParameter("keyword") != null)
		               keyword = request.getParameter("keyword");
		            if(request.getParameter("sitem") != null)
		               sitem = request.getParameter("sitem");
		            int listCount = 0;
		            ArrayList<Paper> list = null;
		            //ArrayList<Board> list = bservice.selectList(); 전체
		            //ArrayList<Board> list = bservice.selectList(currentPage, limit); 
		            
		            //현재 페이지
				
		            if(keyword != null && sitem.equals("title")){
		                listCount = pservice.getListTitleCount(keyword);
		                list = new PaperService().selectTitleList(currentPage, limit, keyword);
		             }else if(keyword != null && sitem.equals("writer")){
		                listCount = pservice.getListWriterCount(keyword);
		                list = new PaperService().selectWriterList(currentPage, limit, keyword);
		             } else{
		                listCount = pservice.getListCount();
		                list = new PaperService().selectList(currentPage, limit);
		             }

				
				//총 페이지 수 계산 : 목록이 최소 1개일 때 1page 로 처리
				//0.9 를 더함
				int maxPage = (int)((double)listCount / limit + 0.9);
				//현재 페이제에 보여질 시작 페이지 값 (1, 11, 21, 31, ...)
				int startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;
				//현재 페이지에 보여질 마지막 페이지 값 (10, 20, 30, ...)
				int endPage = startPage + limit - 1;
				
				if(maxPage < endPage)
					endPage = maxPage;
				
				RequestDispatcher view = null;
				
					view = request.getRequestDispatcher("view/paper/paperListView.jsp");
					request.setAttribute("list", list);
					request.setAttribute("listCount", new Integer(listCount)); //오토박싱되므로 굳이 써줄 필요는 없다
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
