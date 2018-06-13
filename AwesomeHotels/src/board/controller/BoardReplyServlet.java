package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardReplyServlet
 */
@WebServlet("/breply")
public class BoardReplyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      
      int boardNo = Integer.parseInt(request.getParameter("boardno"));
      
      BoardService bservice = new BoardService();
      
     
      Board board = bservice.selectOne(boardNo);
      
      RequestDispatcher view = null;
      if(board != null){
         view = request.getRequestDispatcher("view/board/boardReply.jsp");
         request.setAttribute("board", board);
         view.forward(request, response);
      }else{
         view = request.getRequestDispatcher("view/board/boardError.jsp");
         request.setAttribute("message", "메세지 전송 실패");
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