package board.model.service;

import static common.JDBCTemplate.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import board.model.dao.BoardDao;
import board.model.vo.*;


public class BoardService {

	public BoardService(){}
	
	public ArrayList<Board> selectList(){
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(con);
		close(con);
		return list;
	}
	
	
	public Board selectOne(int boardNo) {
		Connection con = getConnection();
		Board board = new BoardDao().selectOne(con, boardNo);
		close(con);
		return board;
	}
	
	public int updateBoard(Board board) {
		Connection con = getConnection();
		int result=new BoardDao().updateBoard(con, board);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		Connection con = getConnection();
		int result = new BoardDao().deleteBoard(con, boardNo);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	
	public int updateReadCount(int boardNo) {
		Connection con = getConnection();
		int result = new BoardDao().updateReadCount(con, boardNo);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
		
	}

	public int insertBoard(Board board) {
		Connection con = getConnection();
		int result = new BoardDao().insertBoard(con, board);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new BoardDao().getListCount(con);
		close(con);
		return listCount;
	}
	

	public ArrayList<Board> selectTitleList(String keyword) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectTitleList(con, keyword);
		close(con);
		return list;
	}

	public ArrayList<Board> selectWriterList(String keyword) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectWriterList(con, keyword);
		close(con);
		return list;
	}

	public int getListCount(String keyword) {
		Connection con = getConnection();
		int listCount = new BoardDao().getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
	      ArrayList<Board> list = new BoardDao().selectList(con,currentPage, limit);
	      close(con);
	      return list;
	}

	public ArrayList<Board> selectBoardList(int currentPage, int limit) {
		Connection con = getConnection();
	      ArrayList<Board> list = new BoardDao().selectBoardList(con, currentPage, limit);
	      close(con);
	      return list;
	}

	public int getListTitleCount(String keyword) {
		Connection con = getConnection();
		int listCount = new BoardDao().getListTitleCount(con, keyword);
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> selectBoardTitleList(int currentPage, int limit, String keyword) {
		Connection con = getConnection();
	      ArrayList<Board> list = new BoardDao().selectBoardTitleList(con, keyword, currentPage, limit);
	      close(con);
	      return list;
	}

	public int getListWriterCount(String keyword) {
		Connection con = getConnection();
		int listCount = new BoardDao().getListWriterCount(con, keyword);
		close(con);
		return listCount;
	}

	public ArrayList<Board> selectBoardWriterList(int currentPage, int limit, String keyword) {
		Connection con = getConnection();
	      ArrayList<Board> list = new BoardDao().selectBoardWriterList(con, keyword, currentPage, limit);
	      close(con);
	      return list;
	}

	public int replyBoard(Board reboard) {
		Connection con = getConnection();
		int result = new BoardDao().replyBoard(con, reboard);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}



}
