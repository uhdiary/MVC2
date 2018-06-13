package reservation.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import hotel.model.vo.Hotel;
import reservation.model.dao.ReservationDao;
import reservation.model.vo.MReservation;
import reservation.model.vo.MyReservationDetail;
import reservation.model.vo.Reservation;

import static common.JDBCTemplate.*;


public class ReservationService {

	public ReservationService(){
		
	}

	public ArrayList<MReservation> myreverve(String user_id) {
		Connection con = getConnection();
		ArrayList<MReservation> list = new ReservationDao().myreverve(con, user_id);
		close(con);
		return list;
		
		
		
	}

	public Hotel selectList(int hotel_no) {
		Connection con = getConnection();
		Hotel list = new ReservationDao().reservationPage(con, hotel_no);
		close(con);
		
		return list;
	}

	public int resCount(int i, int hotel_no) {
		Connection con = getConnection();
		
		int a = new ReservationDao().resCount(con, i, hotel_no);
		
		return a;
	}

	public int insertReservation(Reservation reser) {
		Connection con = getConnection();
		
		int result = new ReservationDao().reservationInsert(con, reser);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public Reservation selectListone(int rev_no) {
		Connection con = getConnection();
		Reservation list = new ReservationDao().reservationOne(con, rev_no);
		close(con);
		
		return list;
	}

	public static int hotelCancle(int rev_no) {
		Connection con = getConnection();
		
		int result = new ReservationDao().reservationCancle(con, rev_no);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public MyReservationDetail selectListoneDetail(int rev_no) {
		Connection con = getConnection();
		MyReservationDetail list = new ReservationDao().reservationOneDetail(con, rev_no);
		close(con);
		
		return list;
	}
	

	public ArrayList<MReservation> myreverve1(String hotel_name, int currentPage,int limit) {
		Connection con = getConnection();
		ArrayList<MReservation> list = new ReservationDao().myreverve1(con, hotel_name, currentPage, limit);
		close(con);
		return list;
	}

	public int updateReservation(Reservation reser, int rev_no) {
		Connection con = getConnection();
	
		int result = new ReservationDao().reservationUpdate(con, reser, rev_no);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<MReservation> mgSearch(String keyword, String hotel_name,int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<MReservation> list = new ReservationDao().mgSearch(con, keyword, hotel_name ,currentPage, limit);
		close(con);
		return list;
	}

	public int getListCount(String hotel_name) {
		Connection con = getConnection();
		int listCount = new ReservationDao().getListCount(con,hotel_name);
		close(con);
		return listCount;
	}

	public int getListCount(String hotel_name, String keyword) {
		Connection con = getConnection();
		int listCount = new ReservationDao().getListCount(con,hotel_name,keyword);
		close(con);
		return listCount;
	}
	
	
	
}
