package reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.model.service.ReservationService;
import reservation.model.vo.MyReservationDetail;


/**
 * Servlet implementation class MyReservationDetail
 */
@WebServlet("/mrdetail")
public class MyReservationDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReservationDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//나의 예약관리에서 디테일하게 보여주기
				int rev_no = Integer.parseInt(request.getParameter("rev_no"));
				MyReservationDetail list = new ReservationService().selectListoneDetail(rev_no);
				RequestDispatcher view = null;
				
				
				if(list != null){
					view = request.getRequestDispatcher("view/reservation/myreservationdetail.jsp");
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
