package reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import reservation.model.service.ReservationService;
import reservation.model.vo.Reservation;

/**
 * Servlet implementation class ReserveCount
 */
@WebServlet("/resc")
public class ReservationCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//예약가능 확인 서블릿
		response.setContentType("application/json");
		// response.setContentType("text/html; charset=utf-8");
		int checkin = Integer.parseInt(request.getParameter("checkin"));
		int checkout = Integer.parseInt(request.getParameter("checkout"));
		int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));

		ArrayList list = new ArrayList();
		int b = 0;
		for (int i = checkin; i <= checkout; i++) {
			int a = new ReservationService().resCount(i, hotel_no);
			if (a == 1) {
				//예약불가능
			
				list.add(i);
				b++;
			}
		}

		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		jarr.put(list);

		RequestDispatcher view = null;

		if (b > 0) {
			response.setContentType("application/json");
			json.put("list", jarr);
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();
			out.close();
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
