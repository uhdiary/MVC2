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
		//���̵� �ߺ� ó���� ��Ʈ�ѷ�
		//1. ���۰��� �ѵ��� ���ԵǾ� ���� ��� ���ڵ� ó����
	    request.setCharacterEncoding("utf-8");
	      
	    //2. ó����� ���������� ���� ����
	    response.setContentType("text/html; charset=utf-8");
	      
	    //3. ���۰� ������ ������ ���
	    String user_id = request.getParameter("userid");
	     //System.out.println(user_id + ", " + user_pwd);
	    
	    //4. ����Ͻ����� ó���� Ŭ������ �����ϰ� ����ޱ�
	    int idoverUser = new MemberService().idoverCheck(user_id); 
	    //5. ���� ����� ������ ���� ���Ͽ� ���
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
