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

/**
 * Servlet implementation class MemberpwdServlet
 */
@WebServlet("/mpwd")
public class MemberpwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberpwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");  
		String email = request.getParameter("email");
		String email_o = request.getParameter("email_o");
		String phone = request.getParameter("phone");
		String phone_o = request.getParameter("phone_o");
		String phone_t = request.getParameter("phone_t");
		String result = "";
		
		if(user_id =="" || user_id == null || email =="" || email_o =="" || email == null ||  email_o == null) { result = new MemberService().memberPwd(user_id, user_name, phone, phone_o, phone_t);  }
		else { result = new MemberService().memberPwd(user_id, user_name, email, email_o);    }

	    JSONObject job = new JSONObject();
	    job.put("user_pwd", result);
	    PrintWriter out = response.getWriter();
	    out.print(job.toJSONString());
	    out.flush();
	    out.close();
	}

}
