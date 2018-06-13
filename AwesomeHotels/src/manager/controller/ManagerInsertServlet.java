package manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.model.service.ManagerService;
import manager.model.vo.Manager;


/**
 * Servlet implementation class ManagerInsertServlet
 */
@WebServlet("/mginsert")
public class ManagerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 호텔 정보 입력 컨트롤러
				//1. 전송값에 한글이 있을 경우 인코딩처리
				request.setCharacterEncoding("utf-8");
				//2. 응답할 뷰 페이지 타입 지정
				response.setContentType("text/html; charset=utf-8");
				
				//3. 전송값 꺼내서 변수에 담기
				
				String hotel_name = request.getParameter("hotel_name");
				String hotel_address = request.getParameter("hotel_address");
				String hotel_info = request.getParameter("hotel_info");
				String hotel_link = request.getParameter("hotel_link");
				String hotel_fac1 = request.getParameter("hotel_fac1");
				String hotel_fac2 = request.getParameter("hotel_fac2");
				String hotel_fac3 = request.getParameter("hotel_fac3");
				String hotel_fac4 = request.getParameter("hotel_fac4");
				String hotel_start_time = request.getParameter("hotel_start_time");
				String hotel_end_time = request.getParameter("hotel_end_time");
				String hotel_travel = request.getParameter("hotel_travel");
				
				int hotel_price = Integer.parseInt(request.getParameter("hotel_price"));
				
				Manager manager = new Manager(hotel_name, 
						hotel_address, hotel_info, hotel_link, hotel_fac1, hotel_fac2, 
						hotel_fac3, hotel_fac4, hotel_start_time, hotel_end_time, hotel_travel, hotel_price);
				int result = new ManagerService().insertManager(manager);
				
				
				if(result > 0){
					response.sendRedirect("/hotel/mglist");
				}else{
					response.sendRedirect("/hotel/view/manager/managerError.jsp");
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
