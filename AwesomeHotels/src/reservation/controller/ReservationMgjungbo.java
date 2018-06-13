package reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.model.vo.Hotel;
import reservation.model.service.ReservationService;

/**
 * Servlet implementation class reservationMgjungbo
 */
@WebServlet("/resmgjung")
public class ReservationMgjungbo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationMgjungbo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 단에서 예약 할때 호텔 정보 가지고 가는 서블릿
		response.setContentType("text/html; charset=utf-8");		
		
		int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
		
		
		Hotel list = new ReservationService().selectList(hotel_no);
		RequestDispatcher view = null;
		
		if(list != null){
			view = request.getRequestDispatcher("view/mgreservation/mgreservationenroll.jsp");
			request.setAttribute("list", list);
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
