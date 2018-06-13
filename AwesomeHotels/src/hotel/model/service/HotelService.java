package hotel.model.service;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;
import hotel.model.dao.HotelDao;
import hotel.model.vo.Hotel;

public class HotelService {
	public HotelService(){}
	
//	특정 호텔 상세정보
	public Hotel selectHotel(int hotel_no){
		Connection con = getConnection();
		Hotel hotel = new HotelDao().selectHotel(con, hotel_no);
		close(con);
		return hotel;
	}
	
//	호텔 전체 검색
	public ArrayList<Hotel> selectList(int limit){
		Connection con = getConnection();
		ArrayList<Hotel> list = new HotelDao().selectList(con, limit);
		close(con);		
		return list;
	}

//	호텔 전체 갯수 구하기
	public int getListCount() {
		Connection con = getConnection();
		int listCount = new HotelDao().getListCount(con);
		close(con);
		return listCount;
	}

//	페이징을 위한 select list
	public ArrayList<Hotel> selectList(int currentPage, int limit) {
	      Connection con = getConnection();
	      ArrayList<Hotel> list = new HotelDao()
	            .selectList(con, currentPage, limit);
	      close(con);      
	      return list;
	}	
 
//	도시로 검색했을 때
	public ArrayList<Hotel> selectCityList(String keyword,
			int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Hotel> list = new HotelDao().selectCityList(con,
				keyword, currentPage, limit);
		close(con);
		return list;
	}

//	호텔명으로 검색했을 때
	public ArrayList<Hotel> selectHotelList(String keyword,
			int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Hotel> list = new HotelDao().selectHotelList(con,
				keyword, currentPage, limit);
		close(con);
		return list;
	}

//	호텔로 검색했을 때 총 갯수
	public int getHotelListCount(String keyword) {
		Connection con = getConnection();
		int listCount = new HotelDao().getHotelListCount(con, keyword);
		close(con);
		return listCount;
	}

//	도시로 검색했을 때 총 갯수
	public int getCityListCount(String keyword) {
		Connection con = getConnection();
		int listCount = new HotelDao().getCityListCount(con, keyword);
		close(con);
		return listCount;
	}	
}