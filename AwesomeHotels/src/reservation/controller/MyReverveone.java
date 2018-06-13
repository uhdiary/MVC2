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
 * Servlet implementation class MyReverveone
 */
@WebServlet("/mreverve")
public class MyReverveone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyReverveone() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//나의 예약 정보
		response.setContentType("text/html; charset=utf-8"); 
		String user_id = request.getParameter("user_id");
		
		ArrayList<MReservation> list = new ReservationService().myreverve(user_id);
		RequestDispatcher view = null;
		if(list.size() > 0){
			view = request.getRequestDispatcher("view/reservation/myreservation.jsp");
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
