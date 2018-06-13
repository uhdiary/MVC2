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
 * Servlet implementation class MemberidServlet2
 */
@WebServlet("/mid")
public class MemberidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String user_name = request.getParameter("user_name");  
		String email = request.getParameter("email");
		String email_o = request.getParameter("email_o");
		String phone = request.getParameter("phone");
		String phone_o = request.getParameter("phone_o");
		String phone_t = request.getParameter("phone_t");
		String result = "";
		if(email =="" || email_o =="" || email == null ||  email_o == null) { result = new MemberService().memberId(user_name, phone, phone_o, phone_t);  }
		else { result = new MemberService().memberId(user_name, email, email_o);    }

	    JSONObject job = new JSONObject();
	    job.put("user_id", result);
	    PrintWriter out = response.getWriter();
	    out.print(job.toJSONString());
	    out.flush();
	    out.close();
	}

}
