package paper.model.service;

import static common.JDBCTemplate.*;
import java.util.*;

import paper.model.dao.PaperDao;
import paper.model.vo.*;
import java.sql.*;

public class PaperService {

		   public PaperService(){}
		   
		  /* public ArrayList<Paper> selectList(){
		      Connection con = getConnection();
		      ArrayList<Paper> list = new PaperDao().selectList(con);
		      close(con);
		      return list;
		   }*/
		   
		   
		   public Paper selectOne(int paper_no) {
		      Connection con = getConnection();
		      Paper paper = new PaperDao().selectOne(con, paper_no);
		      close(con);
		      return paper;
		   }
		   
		   public int updatePaper(Paper paper) {
		      Connection con = getConnection();
		      int result=new PaperDao().updatePaper(con, paper);
		      if(result > 0)
		         commit(con);
		      else
		         rollback(con);
		      close(con);
		      return result;
		   }
		   
		   public int deletePaper(int paper_no) {
		      Connection con = getConnection();
		      int result = new PaperDao().deletePaper(con, paper_no);
		      if(result > 0)
		         commit(con);
		      else
		         rollback(con);
		      close(con);
		      return result;
		   }
		   
		   public int updateReadCount(int paper_no) {
		      Connection con = getConnection();
		      int result = new PaperDao().updateReadCount(con, paper_no);
		      if(result > 0)
		         commit(con);
		      else
		         rollback(con);
		      close(con);
		      return result;
		      
		   }

		   public int insertPaper(Paper paper) {
		      Connection con = getConnection();
		      int result = new PaperDao().insertBoard(con, paper);
		      if(result > 0)
		         commit(con);
		      else
		         rollback(con);
		      close(con);
		      return result;
		   }

		   public int getListCount() {
		      Connection con = getConnection();
		      int listCount = new PaperDao().getListCount(con);
		      close(con);
		      return listCount;
		   }
		   

		   public ArrayList<Paper> selectTitleList(String keyword) {
		      Connection con = getConnection();
		      ArrayList<Paper> list = new PaperDao().selectTitleList(con, keyword);
		      close(con);
		      return list;
		   }

		   public ArrayList<Paper> selectWriterList(String keyword) {
		      Connection con = getConnection();
		      ArrayList<Paper> list = new PaperDao().selectWriterList(con, keyword);
		      close(con);
		      return list;
		   }

		   public int getListCount(String keyword) {
		      Connection con = getConnection();
		      int listCount = new PaperDao().getListCount(con);
		      close(con);
		      return listCount;
		   }

		   public ArrayList<Paper> selectList(int currentPage, int limit) {
		      Connection con = getConnection();
		         ArrayList<Paper> list = new PaperDao().selectList(con,currentPage, limit);
		         close(con);
		         return list;
		   }


		   public int getListTitleCount(String keyword) {
		      Connection con = getConnection();
		      int listCount = new PaperDao().getListTitleCount(con, keyword);
		      close(con);
		      
		      return listCount;
		   }

		   public ArrayList<Paper> selectTitleList(int currentPage, int limit, String keyword) {
		      Connection con = getConnection();
		         ArrayList<Paper> list = new PaperDao().selectPaperTitleList(con, keyword, currentPage, limit);
		         close(con);
		         return list;
		   }

		   public int getListWriterCount(String keyword) {
		      Connection con = getConnection();
		      int listCount = new PaperDao().getListWriterCount(con, keyword);
		      close(con);
		      return listCount;
		   }

		   public ArrayList<Paper> selectWriterList(int currentPage, int limit, String keyword) {
		      Connection con = getConnection();
		         ArrayList<Paper> list = new PaperDao().selectPaperWriterList(con, keyword, currentPage, limit);
		         close(con);
		         return list;
		   }

		public int replyPaper(Paper paper) {
			Connection con = getConnection();
			int result = new PaperDao().replyPaper(con, paper);
			if(result > 0)
				commit(con);
			else
				rollback(con);
			close(con);
			return result;
		}
}