package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    public LoginServlet() {
        super();
    }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // 로그인 서비스 처리용 컨트롤러
	  //System.out.println("LoginServlet 클래스 구동 확인...");
	  //1. 전송값에 한들이 포함되어 있을 경우 인코딩 처리함
      request.setCharacterEncoding("utf-8");
      
      //2. 처리결과 응답페이지 종류 지정
      response.setContentType("text/html; charset=utf-8");
      
      //3. 전송값 꺼내서 변수에 담기
      String user_id = request.getParameter("user_id");
      String user_pwd = request.getParameter("user_pwd");
     
      //System.out.println(user_id + ", " + user_pwd);
      
      //4. 비즈니스로직 처리용 클래스로 전달하고 결과받기
      Member loginUser = new MemberService().loginCheck(user_id, user_pwd);      
      
      //5. 받은 결과를 가지고 뷰를 선택해서 클라이언트에게 내보냄(응답)
      if(loginUser != null){
	    	 //로그인 상태 관리를 위한 세션객체 생성함
	         HttpSession session = request.getSession(); 
	        
	         session.setAttribute("loginUser", loginUser); // 키와 객체로 반드시 

	         JSONObject job = new JSONObject();
             job.put("result", String.valueOf(loginUser.getUser_id()));
             PrintWriter out = response.getWriter();
             out.print(job.toJSONString());
             out.flush();
             out.close();
             
	         }else{
	         response.sendRedirect("/hotel/view/main/main.html");
       }
     }
}