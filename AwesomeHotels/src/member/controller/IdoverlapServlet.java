package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class IdoverlapServlet
 */
@WebServlet("/idove")
public class IdoverlapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdoverlapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 중복 처리용 컨트롤러
		//1. 전송값에 한들이 포함되어 있을 경우 인코딩 처리함
	    request.setCharacterEncoding("utf-8");
	      
	    //2. 처리결과 응답페이지 종류 지정
	    response.setContentType("text/html; charset=utf-8");
	      
	    //3. 전송값 꺼내서 변수에 담기
	    String user_id = request.getParameter("userid");
	     //System.out.println(user_id + ", " + user_pwd);
	    
	    //4. 비즈니스로직 처리용 클래스로 전달하고 결과받기
	    int idoverUser = new MemberService().idoverCheck(user_id); 
	    //5. 받은 결과를 가지고 값을 비교하여 출력
	    System.out.println(idoverUser);
	        JSONObject job = new JSONObject();
	        job.put("result", String.valueOf(idoverUser));
	        PrintWriter out = response.getWriter();
	        out.print(job.toJSONString());
	        out.flush();
	        out.close();
	    	
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
