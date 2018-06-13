package reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.service.ReservationService;

/**
 * Servlet implementation class HotelCancle
 */
@WebServlet("/hcancle")
public class HotelCancle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelCancle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//호텔 관리자에서 예약취소
		response.setContentType("text/html; charset=utf-8");
		int rev_no = Integer.parseInt(request.getParameter("rev_no"));
		
		String hotel_name = request.getParameter("hotel_name");
		
		int result = ReservationService.hotelCancle(rev_no);
		RequestDispatcher view = null;
		if(result > 0){
			view = request.getRequestDispatcher("revhmg");
			request.setAttribute("list", hotel_name);
			view.forward(request, response);
			
		}else{
			//response.sendRedirect("view/main/main.html");
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
