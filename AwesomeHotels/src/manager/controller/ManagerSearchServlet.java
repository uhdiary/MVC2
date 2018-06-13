package manager.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.model.service.ManagerService;
import manager.model.vo.Manager;

/**
 * Servlet implementation class ManaerSearchServlet
 */
@WebServlet("/mgsearch")
public class ManagerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		ManagerService mservice = new ManagerService();

		int currentPage = 1;
		int limit = 10; // 한 페이지에 10개씩 출력할 경우
		String keyword = null;
        String hitem = null;
		
		
		if(request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		if(request.getParameter("keyword") != null)
            keyword = request.getParameter("keyword");
         if(request.getParameter("hitem") != null)
            hitem = request.getParameter("hitem");
		int listCount = 0;
		
		ArrayList<Manager> list = null;
		
		 if(keyword != null && hitem.equals("hotel")){
	            listCount = mservice.getListHotelCount(keyword);
	            list = new ManagerService().selectHotelList(currentPage, limit, keyword);
	         }else if(keyword != null && hitem.equals("address")){
	            listCount = mservice.getListAddressCount(keyword);
	            list = new ManagerService().selectAddressList(currentPage, limit, keyword);
	         } else{
	            listCount = mservice.getListCount();
	            list = new ManagerService().selectList(currentPage, limit);
	         }

			// 총 페이지 수 계산 : 목록이 최소 1개일 때 1page 로 처리
			// 0.9 를 더함
			int maxPage = (int) ((double) listCount / limit + 0.9);
			// 현재 페이제에 보여질 시작 페이지 값 (1, 11, 21, 31, ...)
			int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
			// 현재 페이지에 보여질 마지막 페이지 값 (10, 20, 30, ...)
			int endPage = startPage + limit - 1;

			if (maxPage < endPage)
				endPage = maxPage;

			RequestDispatcher view = null;
			if (list.size() > 0) {

				view = request.getRequestDispatcher("view/manager/managerListView.jsp");
				request.setAttribute("list", list);
				request.setAttribute("listCount", listCount);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("keyword", keyword);
		         request.setAttribute("hitem", hitem);
				view.forward(request, response);

			} else {
				view = request.getRequestDispatcher("view/manager/managerError.jsp");
				request.setAttribute("massage", "검색 실패");
				view.forward(request, response);
			}
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
