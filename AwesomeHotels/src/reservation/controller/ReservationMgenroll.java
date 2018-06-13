package reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.service.ReservationService;
import reservation.model.vo.Reservation;

/**
 * Servlet implementation class reservationMg
 */
@WebServlet("/resmodify")
public class ReservationMgenroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationMgenroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자 단에서 입력하는 서블릿
				request.setCharacterEncoding("utf-8");
				//2. 응답할 뷰 페이지 타입 지정
				response.setContentType("text/html; charset=utf-8");
				
				//3. 전송값 꺼내서 변수에 담기
				String hotel_name = request.getParameter("hotel_name");
				String user_id = request.getParameter("userid");
				int rev_price = Integer.parseInt(request.getParameter("price"));
				int rev_checkin = Integer.parseInt(request.getParameter("checkin"));
				int rev_checkout =Integer.parseInt(request.getParameter("checkout"));
				int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
				int rev_person_count = Integer.parseInt(request.getParameter("people"));
				
				
				Reservation reser = new Reservation(user_id, hotel_no, rev_checkin, rev_checkout, rev_price, rev_person_count);
				
				int result = new ReservationService().insertReservation(reser);
						
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
