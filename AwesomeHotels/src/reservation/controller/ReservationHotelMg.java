package reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.service.ReservationService;
import reservation.model.vo.MReservation;


/**
 * Servlet implementation class ReverveHotelMg
 */
@WebServlet("/revhmg")
public class ReservationHotelMg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationHotelMg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 호텔관리자 리스트 뿌리기
		
		response.setContentType("text/html; charset=utf-8");
		
		
		ReservationService res = new ReservationService();
		String hotel_name = request.getParameter("hotel_name");
		
		int currentPage = 1;
		int limit = 10;	//한 페이지에 10개씩 출력할 경우
		
		if(request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
				
		int listCount = res.getListCount(hotel_name);
		
		ArrayList<MReservation> list = new ReservationService().myreverve1(hotel_name, currentPage, limit);
		//
		
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지에 보여질 시작 페이지 값 (1, 11, 21, 31, ....)
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;
		//현재 페이지에 보여질 마지막 페이지 값 (10, 20, 30, ....)
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		
		RequestDispatcher view = null;
		if(list.size() > 0){
			view = request.getRequestDispatcher("view/mgreservation/mgreservation.jsp");
			request.setAttribute("list", list);
			request.setAttribute("listCount", new Integer(listCount));
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
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
