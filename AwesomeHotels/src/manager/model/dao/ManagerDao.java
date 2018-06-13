package manager.model.dao;

import static common.JDBCTemplate.*;

import java.sql.*;
import java.util.*;

import manager.model.vo.Manager;
import paper.model.vo.Paper;

public class ManagerDao {
	public ManagerDao() {
	}

	public ArrayList<Manager> selectList(Connection con) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from ahotel";
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				Manager mg = new Manager();

				mg.setHotel_no(rset.getInt("hotel_no"));
				mg.setHotel_name(rset.getString("hotel_name"));
				mg.setHotel_address(rset.getString("hotel_address"));
				mg.setHotel_info(rset.getString("hotel_info"));
				mg.setHotel_link(rset.getString("hotel_link"));
				mg.setHotel_fac1(rset.getString("hotel_fac1"));
				mg.setHotel_fac2(rset.getString("hotel_fac2"));
				mg.setHotel_fac3(rset.getString("hotel_fac3"));
				mg.setHotel_fac4(rset.getString("hotel_fac4"));
				mg.setHotel_start_time(rset.getString("hotel_start_time"));
				mg.setHotel_end_time(rset.getString("hotel_end_time"));
				mg.setHotel_travel(rset.getString("hotel_travel"));
				mg.setHotel_price(rset.getInt("hotel_price"));
				list.add(mg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int insertManager(Connection con, Manager manager) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into ahotel(hotel_no, hotel_name, hotel_address, hotel_info, hotel_link, hotel_fac1, hotel_fac2, hotel_fac3, hotel_fac4, hotel_start_time, hotel_end_time, hotel_travel, hotel_price) values(hotel_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, manager.getHotel_name());
			pstmt.setString(2, manager.getHotel_address());
			pstmt.setString(3, manager.getHotel_info());
			pstmt.setString(4, manager.getHotel_link());
			pstmt.setString(5, manager.getHotel_fac1());
			pstmt.setString(6, manager.getHotel_fac2());
			pstmt.setString(7, manager.getHotel_fac3());
			pstmt.setString(8, manager.getHotel_fac4());
			pstmt.setString(9, manager.getHotel_start_time());
			pstmt.setString(10, manager.getHotel_end_time());
			pstmt.setString(11, manager.getHotel_travel());
			pstmt.setInt(12, manager.getHotel_price());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;

	}

	public Manager selectManager(Connection con, int hotel_no) {
		Manager manager = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from ahotel where hotel_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotel_no);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				manager = new Manager();

				manager.setHotel_no(hotel_no);
				manager.setHotel_name(rset.getString("hotel_name"));
				manager.setHotel_address(rset.getString("hotel_address"));
				manager.setHotel_info(rset.getString("hotel_info"));
				manager.setHotel_link(rset.getString("hotel_link"));
				manager.setHotel_fac1(rset.getString("hotel_fac1"));
				manager.setHotel_fac2(rset.getString("hotel_fac2"));
				manager.setHotel_fac3(rset.getString("hotel_fac3"));
				manager.setHotel_fac4(rset.getString("hotel_fac4"));
				manager.setHotel_start_time(rset.getString("hotel_start_time"));
				manager.setHotel_end_time(rset.getString("hotel_end_time"));
				manager.setHotel_travel(rset.getString("hotel_travel"));
				manager.setHotel_price(rset.getInt("hotel_price"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return manager;
	}

	public int deleteManager(Connection con, int hotel_no) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from ahotel where hotel_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotel_no);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Manager> selectNameList(Connection con, String keyword) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from ahotel where hotel_name like ? order by hotel_no desc";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Manager manager = new Manager();

				manager.setHotel_no(rset.getInt("hotel_no"));
				manager.setHotel_name(rset.getString("hotel_name"));
				manager.setHotel_address(rset.getString("hotel_address"));
				manager.setHotel_info(rset.getString("hotel_info"));
				manager.setHotel_link(rset.getString("hotel_link"));
				manager.setHotel_fac1(rset.getString("hotel_fac1"));
				manager.setHotel_fac2(rset.getString("hotel_fac2"));
				manager.setHotel_fac3(rset.getString("hotel_fac3"));
				manager.setHotel_fac4(rset.getString("hotel_fac4"));
				manager.setHotel_start_time(rset.getString("hotel_start_time"));
				manager.setHotel_end_time(rset.getString("hotel_end_time"));
				manager.setHotel_travel(rset.getString("hotel_travel"));
				manager.setHotel_price(rset.getInt("hotel_price"));
				list.add(manager);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Manager> selectAddressList(Connection con, String keyword) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from ahotel where hotel_address like ? order by hotel_no desc";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Manager manager = new Manager();

				manager.setHotel_no(rset.getInt("hotel_no"));
				manager.setHotel_name(rset.getString("hotel_name"));
				manager.setHotel_address(rset.getString("hotel_address"));
				manager.setHotel_info(rset.getString("hotel_info"));
				manager.setHotel_link(rset.getString("hotel_link"));
				manager.setHotel_fac1(rset.getString("hotel_fac1"));
				manager.setHotel_fac2(rset.getString("hotel_fac2"));
				manager.setHotel_fac3(rset.getString("hotel_fac3"));
				manager.setHotel_fac4(rset.getString("hotel_fac4"));
				manager.setHotel_start_time(rset.getString("hotel_start_time"));
				manager.setHotel_end_time(rset.getString("hotel_end_time"));
				manager.setHotel_travel(rset.getString("hotel_travel"));
				manager.setHotel_price(rset.getInt("hotel_price"));
				list.add(manager);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Manager> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
		String query = "select * from (select rownum rnum, " + "hotel_no, hotel_name, hotel_address, hotel_info, "
				+ "hotel_link, hotel_fac1, hotel_fac2, "
				+ "hotel_fac3, hotel_fac4, hotel_start_time, hotel_end_time, hotel_travel, hotel_price from (select * from ahotel order by "
				+ "hotel_no desc)) where rnum >= ? and rnum <= ?";

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
				Manager mg = new Manager();

				mg.setHotel_no(rset.getInt("hotel_no"));
				mg.setHotel_name(rset.getString("hotel_name"));
				mg.setHotel_address(rset.getString("hotel_address"));
				mg.setHotel_info(rset.getString("hotel_info"));
				mg.setHotel_link(rset.getString("hotel_link"));
				mg.setHotel_fac1(rset.getString("hotel_fac1"));
				mg.setHotel_fac2(rset.getString("hotel_fac2"));
				mg.setHotel_fac3(rset.getString("hotel_fac3"));
				mg.setHotel_fac4(rset.getString("hotel_fac4"));
				mg.setHotel_start_time(rset.getString("hotel_start_time"));
				mg.setHotel_end_time(rset.getString("hotel_end_time"));
				mg.setHotel_travel(rset.getString("hotel_travel"));
				mg.setHotel_price(rset.getInt("hotel_price"));
				list.add(mg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from ahotel";

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

	public int getListCount(Connection con, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from ahotel where hotel_name like ?";

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

	public ArrayList<Manager> selectList(Connection con, String keyword, int currentPage, int limit) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from ahotel where hotel_name like ? order by hotel_no desc";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Manager mg = new Manager();

				mg.setHotel_no(rset.getInt("hotel_no"));
				mg.setHotel_name(rset.getString("hotel_name"));
				mg.setHotel_address(rset.getString("hotel_address"));
				mg.setHotel_info(rset.getString("hotel_info"));
				mg.setHotel_link(rset.getString("hotel_link"));
				mg.setHotel_fac1(rset.getString("hotel_fac1"));
				mg.setHotel_fac2(rset.getString("hotel_fac2"));
				mg.setHotel_fac3(rset.getString("hotel_fac3"));
				mg.setHotel_fac4(rset.getString("hotel_fac4"));
				mg.setHotel_start_time(rset.getString("hotel_start_time"));
				mg.setHotel_end_time(rset.getString("hotel_end_time"));
				mg.setHotel_travel(rset.getString("hotel_travel"));
				mg.setHotel_price(rset.getInt("hotel_price"));
				list.add(mg);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateManager(Connection con, Manager manager) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "update ahotel set hotel_name = ?, hotel_address = ?, "
				+ "hotel_info = ?, hotel_link = ?, hotel_fac1 = ?, hotel_fac2 = ?, hotel_fac3 = ?, hotel_fac4 = ?, hotel_start_time = ?, hotel_end_time = ?,"
				+ "hotel_travel = ?, hotel_price = ? where hotel_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, manager.getHotel_name());
			pstmt.setString(2, manager.getHotel_address());
			pstmt.setString(3, manager.getHotel_info());
			pstmt.setString(4, manager.getHotel_link());
			pstmt.setString(5, manager.getHotel_fac1());
			pstmt.setString(6, manager.getHotel_fac2());
			pstmt.setString(7, manager.getHotel_fac3());
			pstmt.setString(8, manager.getHotel_fac4());
			pstmt.setString(9, manager.getHotel_start_time());
			pstmt.setString(10, manager.getHotel_end_time());
			pstmt.setString(11, manager.getHotel_travel());
			pstmt.setInt(12, manager.getHotel_price());
			pstmt.setInt(13, manager.getHotel_no());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int getListHotelCount(Connection con, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from ahotel where hotel_name like ?";

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

	public ArrayList<Manager> selectManagerHotelList(Connection con, String keyword, int currentPage, int limit) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
		String query = "select * from (select rownum rnum, hotel_no, hotel_name, hotel_address, hotel_info, hotel_link, hotel_fac1, hotel_fac2, hotel_fac3, hotel_fac4, hotel_start_time, hotel_end_time, hotel_travel, hotel_price from (select * from ahotel where hotel_name like ? order by hotel_no desc)) where rnum >= ? and rnum <= ?";

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
				Manager mg = new Manager();

				mg.setHotel_no(rset.getInt("hotel_no"));
				mg.setHotel_name(rset.getString("hotel_name"));
				mg.setHotel_address(rset.getString("hotel_address"));
				mg.setHotel_info(rset.getString("hotel_info"));
				mg.setHotel_link(rset.getString("hotel_link"));
				mg.setHotel_fac1(rset.getString("hotel_fac1"));
				mg.setHotel_fac2(rset.getString("hotel_fac2"));
				mg.setHotel_fac3(rset.getString("hotel_fac3"));
				mg.setHotel_fac4(rset.getString("hotel_fac4"));
				mg.setHotel_start_time(rset.getString("hotel_start_time"));
				mg.setHotel_end_time(rset.getString("hotel_end_time"));
				mg.setHotel_travel(rset.getString("hotel_travel"));
				mg.setHotel_price(rset.getInt("hotel_price"));
				list.add(mg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListAddressCount(Connection con, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from ahotel where hotel_address like ?";

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

	public ArrayList<Manager> selectManagerAddressList(Connection con, String keyword, int currentPage, int limit) {
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
		String query = "select * from (select rownum rnum, hotel_no, hotel_name, hotel_address, hotel_info, hotel_link, hotel_fac1, hotel_fac2, hotel_fac3, hotel_fac4, hotel_start_time, hotel_end_time, hotel_travel, hotel_price from (select * from ahotel where hotel_address like ? order by hotel_no desc)) where rnum >= ? and rnum <= ?";

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
				Manager mg = new Manager();

				mg.setHotel_no(rset.getInt("hotel_no"));
				mg.setHotel_name(rset.getString("hotel_name"));
				mg.setHotel_address(rset.getString("hotel_address"));
				mg.setHotel_info(rset.getString("hotel_info"));
				mg.setHotel_link(rset.getString("hotel_link"));
				mg.setHotel_fac1(rset.getString("hotel_fac1"));
				mg.setHotel_fac2(rset.getString("hotel_fac2"));
				mg.setHotel_fac3(rset.getString("hotel_fac3"));
				mg.setHotel_fac4(rset.getString("hotel_fac4"));
				mg.setHotel_start_time(rset.getString("hotel_start_time"));
				mg.setHotel_end_time(rset.getString("hotel_end_time"));
				mg.setHotel_travel(rset.getString("hotel_travel"));
				mg.setHotel_price(rset.getInt("hotel_price"));
				list.add(mg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
}
