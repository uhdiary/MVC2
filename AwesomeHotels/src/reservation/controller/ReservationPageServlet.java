package reservation.controller;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serialize.IndentPrinter;

import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;
import reservation.model.service.ReservationService;


/**
 * Servlet implementation class RevervePageServlet
 */
@WebServlet("/revpage")
public class ReservationPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//예약페이지에 정보를 뿌리는 페이지
		response.setContentType("text/html; charset=utf-8");		
		
		int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
		Hotel list = new ReservationService().selectList(hotel_no);
		RequestDispatcher view = null;
		
		
		if(list != null){
			view = request.getRequestDispatcher("view/reservation/reservation.jsp");
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
