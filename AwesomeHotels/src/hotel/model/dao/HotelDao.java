package hotel.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;
import hotel.model.vo.Hotel;

public class HotelDao {
	public HotelDao(){}	

//	호텔의 상세정보 출력할 때, hotel_no 가 primary key 로 지정
	public Hotel selectHotel(Connection con, int hotel_no) {
		Hotel hotel = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ahotel where hotel_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotel_no);			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				hotel = new Hotel();
				hotel.setHotel_no(rset.getInt("hotel_no"));
				hotel.setHotel_name(rset.getString("hotel_name"));
				hotel.setHotel_address(rset.getString("hotel_address"));
				hotel.setHotel_info(rset.getString("hotel_info"));
				hotel.setHotel_link(rset.getString("hotel_link"));
				hotel.setHotel_fac1(rset.getString("hotel_fac1"));
				hotel.setHotel_fac2(rset.getString("hotel_fac2"));
				hotel.setHotel_fac3(rset.getString("hotel_fac3"));
				hotel.setHotel_fac4(rset.getString("hotel_fac4"));
				hotel.setHotel_start_time(
						rset.getString("hotel_start_time"));
				hotel.setHotel_end_time(
						rset.getString("hotel_end_time"));
				hotel.setHotel_travel(rset.getString("hotel_travel"));
				hotel.setHotel_price(rset.getInt("hotel_price"));
			}
			
		} 
		catch (Exception e) {e.printStackTrace();}
		finally{
			close(rset);
			close(pstmt);
		}		
		return hotel;
	}

//	전체 호텔 검색
	public ArrayList<Hotel> selectList(Connection con, int limit) {
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		Statement stmt = null;
		ResultSet rset = null;
		Hotel hotel = null;
		String query = "select * from ahotel";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {				
				hotel = new Hotel();
				hotel.setHotel_no(rset.getInt("hotel_no"));
				hotel.setHotel_name(rset.getString("hotel_name"));
				hotel.setHotel_address(
						rset.getString("hotel_address"));
				hotel.setHotel_info(rset.getString("hotel_info"));
				hotel.setHotel_link(rset.getString("hotel_link"));
				hotel.setHotel_fac1(rset.getString("hotel_fac1"));
				hotel.setHotel_fac2(rset.getString("hotel_fac2"));
				hotel.setHotel_fac3(rset.getString("hotel_fac3"));
				hotel.setHotel_fac4(rset.getString("hotel_fac4"));
				hotel.setHotel_start_time(
						rset.getString("hotel_start_time"));
				hotel.setHotel_end_time(
						rset.getString("hotel_end_time"));
				hotel.setHotel_travel(rset.getString("hotel_travel"));
				hotel.setHotel_price(rset.getInt("hotel_price"));
				list.add(hotel);
			}
		}
		catch (Exception e) {e.printStackTrace();} 
		finally {
			close(rset);
			close(stmt);
		}		
		return list;
	}

//	전체 호텔 갯수
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;		
		String query = "select count(*) from ahotel";
		
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				listCount = rset.getInt(1);			
		} 
		catch (Exception e) {e.printStackTrace();}
		finally{
			close(rset);
			close(stmt);
		}		
		return listCount;
	}

	public ArrayList<Hotel> selectList(Connection con,
			int currentPage, int limit) {
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//최신글이 맨 위로 오게하고, 해당 페이지에 보여질 목록 10개를 조회
		String query = "select * from (select rownum rnum, " +
				"hotel_no, hotel_name, hotel_address, hotel_info, " 
				+ "hotel_link, hotel_fac1, hotel_fac2, " 
				+ "hotel_fac3, hotel_fac4, hotel_start_time, "
				+ "hotel_end_time, hotel_travel, hotel_price "
				+ "from (select * from ahotel order by "
				+ "hotel_no)) where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		//읽기 시작할 행 번호
		int endRow = startRow + limit - 1;
		//읽을 마지막 행 번호
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Hotel hotel = new Hotel();
				hotel.setHotel_no(rset.getInt("hotel_no"));
				hotel.setHotel_name(rset.getString("hotel_name"));
				hotel.setHotel_address(
						rset.getString("hotel_address"));
				hotel.setHotel_info(rset.getString("hotel_info"));
				hotel.setHotel_link(rset.getString("hotel_link"));
				hotel.setHotel_fac1(rset.getString("hotel_fac1"));
				hotel.setHotel_fac2(rset.getString("hotel_fac2"));
				hotel.setHotel_fac3(rset.getString("hotel_fac3"));
				hotel.setHotel_fac4(rset.getString("hotel_fac4"));
				hotel.setHotel_start_time(
						rset.getString("hotel_start_time"));
				hotel.setHotel_end_time(
						rset.getString("hotel_end_time"));
				hotel.setHotel_travel(rset.getString("hotel_travel"));
				hotel.setHotel_price(rset.getInt("hotel_price"));
				list.add(hotel);
			}
			
		}
		catch (Exception e) {e.printStackTrace();}
		finally{
			close(rset);
			close(pstmt);
		}		
		return list;
	}

//	도시로 검색할 때
	public ArrayList<Hotel> selectCityList(Connection con,
			String keyword, int currentPage, int limit) {
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = "select * from ( select rownum rnum, hotel_no, "
				+ "hotel_name, hotel_address, hotel_info, hotel_link, "
				+ "hotel_fac1, hotel_fac2, hotel_fac3, hotel_fac4, "
				+ "hotel_start_time, hotel_end_time, hotel_travel, "
				+ "hotel_price from ahotel where hotel_address "
				+ "like ";
		if(keyword.equals("경기")) // 주소에 경기 키워드 없는 호텔들도 있으므로
			query += "'%수원%' or hotel_address like '%고양%' or "
			+ "hotel_address like ?) where rnum >= ? and rnum <= ?";
		else if(keyword.equals("대구")) // 부산 해운대구 제외하기 위한 query
			query += "? and hotel_address not like '%해운%') "
			+ "where rnum >= ? and rnum <= ?";
		else
			query += "?) where rnum >= ? and rnum <= ?";
		Hotel hotel = null;
		int startRow = (currentPage - 1) * limit + 1;
		//읽기 시작할 행 번호
		int endRow = startRow + limit - 1;		
		//읽을 마지막 행 번호
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");	
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {				
				hotel = new Hotel();
				hotel.setHotel_no(rset.getInt("hotel_no"));
				hotel.setHotel_name(rset.getString("hotel_name"));
				hotel.setHotel_address(
						rset.getString("hotel_address"));
				hotel.setHotel_info(rset.getString("hotel_info"));
				hotel.setHotel_link(rset.getString("hotel_link"));
				hotel.setHotel_fac1(rset.getString("hotel_fac1"));
				hotel.setHotel_fac2(rset.getString("hotel_fac2"));
				hotel.setHotel_fac3(rset.getString("hotel_fac3"));
				hotel.setHotel_fac4(rset.getString("hotel_fac4"));
				hotel.setHotel_start_time(
						rset.getString("hotel_start_time"));
				hotel.setHotel_end_time(
						rset.getString("hotel_end_time"));
				hotel.setHotel_travel(rset.getString("hotel_travel"));
				hotel.setHotel_price(rset.getInt("hotel_price"));
				list.add(hotel);
			}
			
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			close(rset);
			close(pstmt);
		}		
		return list;
	}

//	호텔명으로 검색
	public ArrayList<Hotel> selectHotelList(Connection con,
			String keyword, int currentPage, int limit) {
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = "select * from ( select rownum rnum, hotel_no, "
				+ "hotel_name, hotel_address, hotel_info, hotel_link, "
				+ "hotel_fac1, hotel_fac2, hotel_fac3, hotel_fac4, "
				+ "hotel_start_time, hotel_end_time, hotel_travel, "
				+ "hotel_price from ahotel where hotel_name "
				+ "like ?) where rnum >= ? and rnum <= ? ";
		Hotel hotel = null;
		int startRow = (currentPage - 1) * limit + 1;
		//읽기 시작할 행 번호
		int endRow = startRow + limit - 1;
		//읽을 마지막 행 번호
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {				
				hotel = new Hotel();
				hotel.setHotel_no(rset.getInt("hotel_no"));
				hotel.setHotel_name(rset.getString("hotel_name"));
				hotel.setHotel_address(
						rset.getString("hotel_address"));
				hotel.setHotel_info(rset.getString("hotel_info"));
				hotel.setHotel_link(rset.getString("hotel_link"));
				hotel.setHotel_fac1(rset.getString("hotel_fac1"));
				hotel.setHotel_fac2(rset.getString("hotel_fac2"));
				hotel.setHotel_fac3(rset.getString("hotel_fac3"));
				hotel.setHotel_fac4(rset.getString("hotel_fac4"));
				hotel.setHotel_start_time(
						rset.getString("hotel_start_time"));
				hotel.setHotel_end_time(
						rset.getString("hotel_end_time"));
				hotel.setHotel_travel(rset.getString("hotel_travel"));
				hotel.setHotel_price(rset.getInt("hotel_price"));
				list.add(hotel);
			}			
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			close(rset);
			close(pstmt);
		}		
		return list;
	}

//	호텔명으로 검색했을 때 갯수 구하기
	public int getHotelListCount(Connection con, String keyword) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;		
		String query = "select count(*) from ahotel "
				+ "where hotel_name like '%" + keyword + "%'";		
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				listCount = rset.getInt(1);			
		} 
		catch (Exception e) {e.printStackTrace();}
		finally{
			close(rset);
			close(stmt);
		}		
		return listCount;
	}

//	도시로 검색했을 때 총 갯수 구하기
	public int getCityListCount(Connection con, String keyword) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;		
		String query = "select count(*) from(select * from ahotel "
				+ "where hotel_address like '%";
		if(keyword.equals("대구"))
			query += keyword + "%' and hotel_address not like '%해운%')";
		else if(keyword.equals("경기"))
			query += keyword + "%' or hotel_address like '%수원%' "
			+ "or hotel_address like '%고양%')";
		else
			query += keyword + "%')";
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				listCount = rset.getInt(1);			
		} 
		catch (Exception e) {e.printStackTrace();}
		finally{
			close(rset);
			close(stmt);
		}		
		return listCount;
	}
}