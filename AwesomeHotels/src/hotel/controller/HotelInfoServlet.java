package hotel.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import hotel.model.service.HotelService;
import hotel.model.vo.Hotel;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/hinfo") // 호텔 세부정도 Servlet
public class HotelInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디를 이용한 조회용 컨트롤러
		//1. 인코딩 처리
		response.setContentType("text/html; charset=utf-8");
		
		//2. 전송값(parameter) 추출해서 변수에 기록
		int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
		
		//3. 모델용 서비스클래스의 처리 메소드로 넘기고, 결과받기
		Hotel hotel = new HotelService().selectHotel(hotel_no);
		
		//4. 받은 결과에 대한 성공시에만 내보내기
		RequestDispatcher rd = null;
		if(hotel != null){
			rd = request.getRequestDispatcher("view/search/info.jsp");
			request.setAttribute("hotel", hotel);
			rd.forward(request, response);			
		}		
	}

}








