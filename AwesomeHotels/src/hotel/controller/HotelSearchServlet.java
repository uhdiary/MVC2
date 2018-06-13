package hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/hsearch") // 호텔검색 Servlet
public class HotelSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		// 문자열 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int currentPage = 1; // 현재 페이지
		int limit = 10; // 한번에 출력되는 최대갯수
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword"); // 검색값
		String checkedItem = request.getParameter("hotel"); // 라디오버튼
		HotelService hser = new HotelService();
		ArrayList<Hotel> list = null;
		int listCount = 0; // 검색값 총 갯수
		if (keyword == null){ // 검색값이 없으면 호텔 전체 검색
			list = hser.selectList(currentPage, limit);
			listCount = hser.getListCount();
		}
		else {
			if (checkedItem.equals("hotel")){ // 호텔명으로 검색
				list = hser.selectHotelList(keyword, currentPage, limit);
				listCount = hser.getHotelListCount(keyword);
			}
			else{ // 도시로 검색
				list = hser.selectCityList(keyword, currentPage, limit);
				listCount = hser.getCityListCount(keyword);
			}
		}
		// 현재 페이지에 보여질 시작 페이지 값 (1, 11, 21, 31, ....)
		int startPage = (((int) ((double) currentPage / limit + 0.9))
				- 1) * limit + 1;
		// 현재 페이지에 보여질 마지막 페이지 값 (10, 20, 30, ....)
		int endPage = startPage + limit - 1;
		int maxPage = 0;
		if (listCount % limit != 0) // 예) 총 갯수가 10의 배수가 아닐 때
			maxPage = listCount / limit + 1;
		else // 예) 총 갯수가 10의 배수일 때
			maxPage = listCount / limit;
		if (maxPage < endPage) // 마지막 페이지 제한
			endPage = maxPage;
		RequestDispatcher view = null;
		if (list != null) { // 성공했을 때
			view = request.getRequestDispatcher("view/search/search.jsp");
			request.setAttribute("list", list);
			request.setAttribute("keyword", keyword);
			request.setAttribute("listCount", listCount);
			request.setAttribute("checkedItem", checkedItem);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			view.forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *  HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
