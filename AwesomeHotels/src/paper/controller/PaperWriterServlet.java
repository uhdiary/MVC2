package paper.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;



import paper.model.service.PaperService;
import paper.model.vo.Paper;



/**
 * Servlet implementation class PaperWriterServlet
 */
@WebServlet("/pws")
public class PaperWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전송값에 한글이 있을 경우 인코팅처리
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	    
	    String paper_title = request.getParameter("ptitle");
	    String paper_writer = request.getParameter("pwriter");
		String paper_content1 = request.getParameter("pcontent");
		
		
		String paper_content = paper_content1.substring(paper_content1.indexOf(">") + 1, paper_content1.lastIndexOf("<"));
		
		
		
		Paper paper = new Paper(paper_title, paper_writer, paper_content);
	
		int result = new PaperService().insertPaper(paper);

		if (result > 0) {
			response.sendRedirect("/hotel/pls");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("view/paper/paperError.jsp");
			request.setAttribute("message", "실패");
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
