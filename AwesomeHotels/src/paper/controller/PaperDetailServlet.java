package paper.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paper.model.service.PaperService;
import paper.model.vo.Paper;

/**
 * Servlet implementation class PaperDetailServlet
 */
@WebServlet("/pdts")
public class PaperDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 공지글 상세조회 서비스용 컨트롤러
				response.setContentType("text/html; charset=utf-8");
				
				int paper_no = Integer.parseInt(request.getParameter("paper_no"));
				
				//조회수 1증가처리
				PaperService pservice = new PaperService();
				int result = pservice.updateReadCount(paper_no);
				
				//글번호로 공지글 조회
				Paper paper = pservice.selectOne(paper_no);
				
				RequestDispatcher view = null;
				if(paper != null){
					view = request.getRequestDispatcher("view/paper/paperDetailView.jsp");
					request.setAttribute("paper", paper);
					view.forward(request, response);
				}else{
					view = request.getRequestDispatcher("view/paper/paperError.jsp");
					request.setAttribute("message", "공지글 상세조회 실패");
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
