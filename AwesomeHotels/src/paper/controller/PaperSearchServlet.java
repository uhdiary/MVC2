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
 * Servlet implementation class PaperSearchServlet
 */
@WebServlet("/pss")
public class PaperSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 전체 조회용 컨트롤러
	      response.setContentType("text/html; charset=utf-8");
	      
	      String keyword = request.getParameter("keyword");
	      String sitem = request.getParameter("sitem");
	    
	      PaperService pservice = new PaperService();
	      
	      int currentPage = 1;
	      int limit = 10;   //한 페이지에 10개씩 출력할 경우
	      
	      
	      
	      if(request.getParameter("page") != null)
	         currentPage = Integer.parseInt(request.getParameter("page"));
	            
	      int listCount = 0;
	      
	      ArrayList<Paper> list = null;
	      //ArrayList<Board> list = bservice.selectList(); 전체
	      //ArrayList<Board> list = bservice.selectList(currentPage, limit);   // 현재페이지
	      
	      if(keyword == null){
	         listCount = pservice.getListCount();
	         list = new PaperService().selectList(currentPage, limit);
	      }else{ 
	         if(keyword != null && sitem.equals("title")){
	         listCount = pservice.getListTitleCount(keyword);
	         list = new PaperService().selectTitleList(currentPage, limit,keyword);
	      }else if(keyword != null && sitem.equals("writer")){
	         listCount = pservice.getListWriterCount(keyword);
	         list = new PaperService().selectWriterList(currentPage, limit, keyword);
	      }
	   }
	      
	      
	      /*// 목록조회
	      list = bservice.selectList(currentPage, limit);*/
	      
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
	      
	      if(list.size() > 0){
	         view = request.getRequestDispatcher("view/paper/paperListView.jsp");
	         request.setAttribute("list", list);
	         request.setAttribute("listCount", new Integer(listCount));
	         request.setAttribute("currentPage", currentPage);
	         request.setAttribute("maxPage", maxPage);
	         request.setAttribute("startPage", startPage);
	         request.setAttribute("endPage", endPage);
	         request.setAttribute("keyword", keyword);
	         request.setAttribute("sitem", sitem);
	         view.forward(request, response);
	      }else{
	         view = request.getRequestDispatcher("view/paper/paperError.jsp");
	         request.setAttribute("message", "공지글 목록 조회 실패");
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
