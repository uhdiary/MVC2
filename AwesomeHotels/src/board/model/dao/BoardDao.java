package board.model.dao;

import java.sql.*;
import java.util.*;
import board.model.vo.Board;

import static common.JDBCTemplate.*;

public class BoardDao {
	public BoardDao() {
	}

	public ArrayList<Board> selectList(Connection con) {
		ArrayList<Board> list = new ArrayList<Board>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from (select * from board order by BOARD_REPLY_SEQ desc) order by BOARD_REPLY_LEV asc";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Board board = new Board();

				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_Writer"));
				board.setBoardContent(rset.getString("board_Content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				list.add(board);
		
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;

	}

	public Board selectOne(Connection con, int boardNo) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from board where board_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board();

				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
	}
	public int updateBoard(Connection con, Board board) {
		  int result=0;
	      
	      PreparedStatement pstmt= null;
	      
	      String query= "update board set board_title = ?, board_content = ? where board_no = ?";
	      try {
	    	  
	    	 pstmt  = con.prepareStatement(query);
	    	 
	         pstmt.setString(1, board.getBoardTitle());
	         pstmt.setString(2, board.getBoardContent());
	         pstmt.setInt(3, board.getBoardNo());
	         
	         result = pstmt.executeUpdate();
	         
	         System.out.println(result);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally{
	         close(pstmt);
	      }
	      
	      return result;
	}
	
	public int insertBoard(Connection con, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into board values "
				+ "(SEQ_BOARD.nextval, ?, ?, ?, sysdate, default, default, default, SEQ_BOARD.nextval)";

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardWriter());
			pstmt.setString(3, board.getBoardContent());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from board";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	
	public ArrayList<Board> selectTitleList(Connection con, String keyword) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from board where board_title like ? order by board_no desc";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Board> selectWriterList(Connection con, String keyword) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from board where board_writer like ? order by board_no desc";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		String query = "select * from (select rownum rnum, " + "BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, "
				+ "BOARD_DATE, READ_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ from (select * from board order by "
				+ "BOARD_NO desc)) where rnum >= ? and rnum <= ?";
	    Board board = null;

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				 board = new Board();
				 
				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public ArrayList<Board> selectBoardList(Connection con, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from (select rownum rnum, " + "BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, "
				+ "BOARD_DATE, READ_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ from (select * from board order by "
				+ "BOARD_REPLY_SEQ desc, BOARD_REPLY_REF asc, board_reply_lev asc)) where rnum >= ? and rnum <= ?";

		int startRow = (currentPage - 1) * limit + 1;
		
		int endRow = startRow + limit - 1;
		

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				 Board board = new Board();
				 
				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int getListTitleCount(Connection con, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from board where board_title like ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Board> selectBoardTitleList(Connection con, String keyword, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

	
		String query = "select * from (select rownum rnum, " + "BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, "
				+ "BOARD_DATE, READ_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ from (select * from board "
				+ "where board_title like ? order by "
				+ "BOARD_REPLY_SEQ desc, BOARD_REPLY_REF asc, BOARD_reply_lev asc)) where rnum >= ? and rnum <= ?";

		int startRow = (currentPage - 1) * limit + 1;
		
		int endRow = startRow + limit - 1;
		

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				 Board board = new Board();
				 
				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int getListWriterCount(Connection con, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from board where board_writer like ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Board> selectBoardWriterList(Connection con, String keyword, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		String query = "select * from (select rownum rnum, " + "BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, "
				+ "BOARD_DATE, READ_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ from (select * from board "
				+ "where board_writer like ? order by "
				+ "BOARD_REPLY_SEQ desc, BOARD_REPLY_REF asc, BOARD_reply_lev asc)) where rnum >= ? and rnum <= ?";

		int startRow = (currentPage - 1) * limit + 1;
		
		int endRow = startRow + limit - 1;
		

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				 Board board = new Board();
				 
				board.setBoardNo(rset.getInt("board_no"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setReadCount(rset.getInt("read_count"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateReadCount(Connection con, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board set read_count = " + 
		"(select read_count + 1 from board where board_no = ?)" +
				" where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection con, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from board where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int replyBoard(Connection con, Board reboard) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into board values "
				+ "(SEQ_BOARD.nextval, ?, ?, ?, sysdate, default, 1, ?, ?)";


		try {
			
				
			//boardReplyLev
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reboard.getBoardTitle());
			pstmt.setString(2, reboard.getBoardWriter());
			pstmt.setString(3, reboard.getBoardContent());
			pstmt.setInt(4, (reboard.getBoardReplyLev())+1);
			pstmt.setInt(5, reboard.getBoardReplySeq());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			close(pstmt);
		}

		return result;
	}


}
