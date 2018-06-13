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
	  // �α��� ���� ó���� ��Ʈ�ѷ�
	  //System.out.println("LoginServlet Ŭ���� ���� Ȯ��...");
	  //1. ���۰��� �ѵ��� ���ԵǾ� ���� ��� ���ڵ� ó����
      request.setCharacterEncoding("utf-8");
      
      //2. ó����� ���������� ���� ����
      response.setContentType("text/html; charset=utf-8");
      
      //3. ���۰� ������ ������ ���
      String user_id = request.getParameter("user_id");
      String user_pwd = request.getParameter("user_pwd");
     
      //System.out.println(user_id + ", " + user_pwd);
      
      //4. ����Ͻ����� ó���� Ŭ������ �����ϰ� ����ޱ�
      Member loginUser = new MemberService().loginCheck(user_id, user_pwd);      
      
      //5. ���� ����� ������ �並 �����ؼ� Ŭ���̾�Ʈ���� ������(����)
      if(loginUser != null){
	    	 //�α��� ���� ������ ���� ���ǰ�ü ������
	         HttpSession session = request.getSession(); 
	        
	         session.setAttribute("loginUser", loginUser); // Ű�� ��ü�� �ݵ�� 

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