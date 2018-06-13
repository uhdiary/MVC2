package manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.model.dao.ManagerDao;
import manager.model.service.ManagerService;
import manager.model.vo.Manager;

/**
 * Servlet implementation class ManagerOneServlet
 */
@WebServlet("/mgone")
public class ManagerOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 회원정보 상세보기 서비스용
				response.setContentType("text/html; charset=utf-8");
				
				int hotel_no = Integer.parseInt(request.getParameter("hotel_no"));
				Manager manager = new ManagerService().selectManager(hotel_no);
				
				if(manager != null){  //회원정보 조회 성공
					RequestDispatcher rd = 
						request.getRequestDispatcher("view/manager/managerChange.jsp");
					request.setAttribute("manager", manager);
					rd.forward(request, response);
					
				}else{  //회원정보 조회 실패
					response.sendRedirect("view/manager/managerError.jsp");
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
