package paper.model.dao;

import java.sql.*;
import java.util.*;

import paper.model.vo.Paper;

import static common.JDBCTemplate.*;

public class PaperDao {
	public PaperDao() {
	}

		// 페이지 단위로 게시글 목록 조회용
		/*public ArrayList<Paper> selectList(Connection con) {
			ArrayList<Paper> list = new ArrayList<Paper>();
			Statement stmt = null;
			ResultSet rset = null;

			String query = "select * from paper order by paper_no desc";
			try {
				stmt = con.createStatement();
				rset = stmt.executeQuery(query);
				while (rset.next()) {
					Paper p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					list.add(p);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			return list;

		}*/

		public Paper selectOne(Connection con, int paper_no) {
			Paper p = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = "select * from paper where paper_no = ?";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, paper_no);

				rset = pstmt.executeQuery();

				if (rset.next()) {
					p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					p.setPaper_reply_ref(rset.getInt("paper_reply_ref"));
					p.setPaper_reply_lev(rset.getInt("paper_reply_lev"));
					p.setPaper_reply_seq(rset.getInt("paper_reply_seq"));
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return p;
		}

		public int updatePaper(Connection con, Paper paper) {
			int result = 0;

			PreparedStatement pstmt = null;

			String query = "update paper set paper_title = ?, paper_content = ? where paper_no = ?";
			try {

				pstmt = con.prepareStatement(query);

				pstmt.setString(1, paper.getPaper_title());
				pstmt.setString(2, paper.getPaper_content());
				pstmt.setInt(3, paper.getPaper_no());

				result = pstmt.executeUpdate();

				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}

			return result;
		}

		public int insertBoard(Connection con, Paper paper) {
			int result = 0;
			PreparedStatement pstmt = null;

			String query = "insert into paper(paper_no, paper_title, paper_writer, paper_content, paper_date, paper_reply_ref, paper_reply_lev, paper_reply_seq) values (seq_paper.nextval, ?, ?, ?, sysdate, default, default, SEQ_PAPER.NEXTVAL)";

			try {

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, paper.getPaper_title());
				pstmt.setString(2, paper.getPaper_writer());
				pstmt.setString(3, paper.getPaper_content());

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

			String query = "select count(*) from paper";

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

		public ArrayList<Paper> selectTitleList(Connection con, String keyword) {
			ArrayList<Paper> list = new ArrayList<Paper>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = "select * from paper where paper_title like ? order by paper_no desc";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + keyword + "%");

				rset = pstmt.executeQuery();

				while (rset.next()) {
					Paper p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					p.setPaper_reply_ref(rset.getInt("paper_reply_ref"));
					p.setPaper_reply_lev(rset.getInt("paper_reply_lev"));
					p.setPaper_reply_seq(rset.getInt("paper_reply_seq"));
					list.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return list;
		}

		public ArrayList<Paper> selectWriterList(Connection con, String keyword) {
			ArrayList<Paper> list = new ArrayList<Paper>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = "select * from board where board_writer like ? order by board_no desc";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + keyword + "%");

				rset = pstmt.executeQuery();

				while (rset.next()) {

					Paper p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					p.setPaper_reply_ref(rset.getInt("paper_reply_ref"));
					p.setPaper_reply_lev(rset.getInt("paper_reply_lev"));
					p.setPaper_reply_seq(rset.getInt("paper_reply_seq"));
					list.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return list;
		}

		public ArrayList<Paper> selectList(Connection con, int currentPage, int limit) {
			ArrayList<Paper> list = new ArrayList<Paper>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			// 최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
			String query = "select * from (select rownum rnum, paper_no, paper_title, paper_writer, paper_content, paper_date, paper_count from (select * from paper order by paper_REPLY_SEQ desc, paper_REPLY_REF asc, paper_reply_lev asc)) where rnum >= ? and rnum <= ?";
			Paper paper = null;

			int startRow = (currentPage - 1) * limit + 1;
			// 읽기 시작할 행 번호
			int endRow = startRow + limit - 1;
			// 읽을 마지막 행 번호

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);

				rset = pstmt.executeQuery();

				while (rset.next()) {
					Paper p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					list.add(p);
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

			String query = "select count(*) from paper where paper_title like ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + keyword + "%");
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

		public ArrayList<Paper> selectPaperTitleList(Connection con, String keyword, int currentPage, int limit) {
			ArrayList<Paper> list = new ArrayList<Paper>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			// 최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
			String query = "select * from (select rownum rnum, paper_no, paper_title, paper_writer, paper_content, paper_date, paper_count from (select * from paper where paper_title like  ? order by paper_REPLY_SEQ desc, paper_REPLY_REF asc, paper_reply_lev asc)) where rnum >= ? and rnum <= ?";

			int startRow = (currentPage - 1) * limit + 1;
			// 읽기 시작할 행 번호
			int endRow = startRow + limit - 1;
			// 읽을 마지막 행 번호

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);

				rset = pstmt.executeQuery();

				while (rset.next()) {
					Paper p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					list.add(p);
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

			String query = "select count(*) from paper where paper_writer like ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + keyword + "%");
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

		public ArrayList<Paper> selectPaperWriterList(Connection con, String keyword, int currentPage, int limit) {
			ArrayList<Paper> list = new ArrayList<Paper>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			// 최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
			String query = "select * from (select rownum rnum, paper_no, paper_title, paper_writer, paper_content, paper_date, paper_count from (select * from paper where paper_writer like ? order by paper_REPLY_SEQ desc, paper_REPLY_REF asc, paper_reply_lev asc)) where rnum >= ? and rnum <= ?";

			int startRow = (currentPage - 1) * limit + 1;
			// 읽기 시작할 행 번호
			int endRow = startRow + limit - 1;
			// 읽을 마지막 행 번호

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);

				rset = pstmt.executeQuery();

				while (rset.next()) {
					Paper p = new Paper();
					p.setPaper_no(rset.getInt("paper_no"));
					p.setPaper_title(rset.getString("paper_title"));
					p.setPaper_writer(rset.getString("paper_writer"));
					p.setPaper_content(rset.getString("paper_content"));
					p.setPaper_date(rset.getDate("paper_date"));
					p.setPaper_count(rset.getInt("paper_count"));
					list.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

		public int updateReadCount(Connection con, int paper_no) {
			int result = 0;
			PreparedStatement pstmt = null;

			String query = "update paper set paper_count = " + "(select paper_count + 1 from paper where paper_no = ?)"
					+ " where paper_no = ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, paper_no);
				pstmt.setInt(2, paper_no);

				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}

			return result;
		}

		public int deletePaper(Connection con, int paper_no) {
			int result = 0;
			PreparedStatement pstmt = null;

			String query = "delete from paper where paper_no = ?";

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, paper_no);

				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}

			return result;
		}
		public int replyPaper(Connection con, Paper paper) {
			int result = 0;
			PreparedStatement pstmt = null;

			String query = "insert into paper(paper_no, paper_title, paper_writer, paper_content, paper_date, paper_count, paper_reply_ref, paper_reply_lev, paper_reply_seq) values "
					+ "(SEQ_paper.nextval, ?, ?, ?, sysdate, default, 1, ?, ?)";


			try {
				
					
				//paperReplyLev
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, paper.getPaper_title());
				pstmt.setString(2, paper.getPaper_writer());
				pstmt.setString(3, paper.getPaper_content());
				pstmt.setInt(4, (paper.getPaper_reply_lev())+1);
				pstmt.setInt(5, paper.getPaper_reply_seq());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();	
			} finally {
				close(pstmt);
			}

			return result;
		}

	}
