package reservation.model.dao;

import static common.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import hotel.model.vo.Hotel;
import reservation.model.vo.MReservation;
import reservation.model.vo.MyReservationDetail;
import reservation.model.vo.Reservation;



public class ReservationDao {

	public ArrayList<MReservation> myreverve(Connection con, String user_id) {
		ArrayList<MReservation> list = new ArrayList<MReservation>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query="select rev_no, user_id, hotel_no, rev_checkin, rev_checkout, rev_date, "
				+"rev_price, rev_person_count, hotel_name, hotel_link from " +
				"(select rev_no, hotel_no, user_id, rev_checkin, rev_checkout, rev_date, "
				+"rev_price, rev_person_count from reservation left join member using(user_id) order by rev_date desc) "
				+"left join ahotel using(hotel_no) where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			rset = pstmt.executeQuery();
			while(rset.next()){
				MReservation reservation = new MReservation();
			
				reservation.setRev_no(rset.getInt("rev_no"));
				reservation.setUser_id(rset.getString("user_id"));
				reservation.setHotel_no(rset.getInt("hotel_no"));
				reservation.setRev_checkin(rset.getInt("rev_checkin"));
				reservation.setRev_checkout(rset.getInt("rev_checkout"));
				reservation.setRev_date(rset.getDate("rev_date"));
				reservation.setRev_price(rset.getInt("rev_price"));
				reservation.setRev_person_count(rset.getInt("rev_person_count"));
				reservation.setHotel_link(rset.getString("hotel_link"));
				reservation.setHotel_name(rset.getString("hotel_name"));
			
				
				list.add(reservation);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Hotel reservationPage(Connection con, int hotel_no) {
		Hotel list =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query="select * from ahotel where hotel_no = ?";
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotel_no);

			rset = pstmt.executeQuery();
			
			
			if (rset.next()) {
				list = new Hotel();
				
				list.setHotel_no(rset.getInt("hotel_no"));
				list.setHotel_name(rset.getString("hotel_name"));
				list.setHotel_address(rset.getString("hotel_address"));
				list.setHotel_info(rset.getString("hotel_info"));
				list.setHotel_link(rset.getString("hotel_link"));
				list.setHotel_fac1(rset.getString("hotel_fac1"));
				list.setHotel_fac2(rset.getString("hotel_fac2"));
				list.setHotel_fac3(rset.getString("hotel_fac3"));
				list.setHotel_fac4(rset.getString("hotel_fac4"));
				list.setHotel_start_time(rset.getString("hotel_start_time"));
				list.setHotel_end_time(rset.getString("hotel_end_time"));
				list.setHotel_travel(rset.getString("hotel_travel"));
				list.setHotel_price(rset.getInt("hotel_price"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public int resCount(Connection con, int i, int hotel_no) {
		Hotel list =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query="SELECT COUNT(*) FROM RESERVATION WHERE HOTEL_NO = ? and ? BETWEEN REV_CHECKIN AND REV_CHECKOUT";
		int a = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, hotel_no);
			pstmt.setInt(2, i);

			rset = pstmt.executeQuery();
			
			
			if (rset.next()) {
				if( rset.getInt(1) > 9 ){
					a = 1;
				}else{
					a = 0;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return a;
	}

	public int reservationInsert(Connection con, Reservation reser) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into RESERVATION values(SEQ_REVERVE.NEXTVAL, ?, ?, ?, ?, sysdate, ?, ?)";
		
			
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, reser.getUser_id());
			pstmt.setInt(2, reser.getHotel_no());
			pstmt.setInt(3, reser.getRev_checkin());
			pstmt.setInt(4, reser.getRev_checkout());
			pstmt.setInt(5, reser.getRev_price());
			pstmt.setInt(6, reser.getRev_person_count());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}	
		
		return result;
	}

	public Reservation reservationOne(Connection con, int rev_no) {
		Reservation reservation =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query="select * from reservation where rev_no = ?";
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rev_no);

			rset = pstmt.executeQuery();
			
			
			if (rset.next()) {
				reservation = new Reservation();
				

				reservation.setRev_no(rset.getInt("rev_no"));
				reservation.setUser_id(rset.getString("user_id"));
				reservation.setHotel_no(rset.getInt("hotel_no"));
				reservation.setRev_checkin(rset.getInt("rev_checkin"));
				reservation.setRev_checkout(rset.getInt("rev_checkout"));
				reservation.setRev_date(rset.getDate("rev_date"));
				reservation.setRev_price(rset.getInt("rev_price"));
				reservation.setRev_person_count(rset.getInt("rev_person_count"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return reservation;
	}

	public int reservationCancle(Connection con, int rev_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from reservation where rev_no = ?";
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, rev_no);
			
			
			//System.out.println(reser.getUser_id());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}	
		
		return result;
	
	}

	public MyReservationDetail reservationOneDetail(Connection con, int rev_no) {
		MyReservationDetail list =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query="select * from RESERVATION left join AHOTEL using(hotel_no) where rev_no = ?";
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rev_no);

			rset = pstmt.executeQuery();
			
			
			if (rset.next()) {
				list = new MyReservationDetail();
				

				list.setRev_no(rset.getInt("rev_no"));
				list.setUser_id(rset.getString("user_id"));
				list.setHotel_no(rset.getInt("hotel_no"));
				list.setRev_checkin(rset.getInt("rev_checkin"));
				list.setRev_checkout(rset.getInt("rev_checkout"));
				list.setRev_date(rset.getDate("rev_date"));
				list.setRev_price(rset.getInt("rev_price"));
				list.setRev_person_count(rset.getInt("rev_person_count"));
				
				list.setHotel_name(rset.getString("hotel_name"));
				list.setHotel_address(rset.getString("hotel_address"));
				list.setHotel_info(rset.getString("hotel_info"));
				list.setHotel_link(rset.getString("hotel_link"));
				list.setHotel_fac1(rset.getString("hotel_fac1"));
				list.setHotel_fac2(rset.getString("hotel_fac2"));
				list.setHotel_fac3(rset.getString("hotel_fac3"));
				list.setHotel_fac4(rset.getString("hotel_fac4"));
				list.setHotel_start_time(rset.getString("hotel_start_time"));
				list.setHotel_end_time(rset.getString("hotel_end_time"));
				list.setHotel_travel(rset.getString("hotel_travel"));
				list.setHotel_price(rset.getInt("hotel_price"));
				
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	
		public ArrayList<MReservation> myreverve1(Connection con, String hotel_name,int currentPage, int limit) {
			ArrayList<MReservation> list = new ArrayList<MReservation>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			
			String query="select * from (select rownum rnum, rev_no, user_id, hotel_no, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count, hotel_name, hotel_link from " +
					"(select rev_no, hotel_no, user_id, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count from reservation left join member using(user_id) order by rev_date desc) "
					+"left join ahotel using(hotel_no) where hotel_name = ?) where rnum >= ? and rnum <= ?";
			
			int startRow = (currentPage - 1) * limit + 1;
			//읽기 시작할 행 번호
			int endRow = startRow + limit - 1;
			//읽을 마지막 행 번호
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, hotel_name);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				while(rset.next()){
					MReservation reservation = new MReservation();
				
					reservation.setRev_no(rset.getInt("rev_no"));
					reservation.setUser_id(rset.getString("user_id"));
					reservation.setHotel_no(rset.getInt("hotel_no"));
					reservation.setRev_checkin(rset.getInt("rev_checkin"));
					reservation.setRev_checkout(rset.getInt("rev_checkout"));
					reservation.setRev_date(rset.getDate("rev_date"));
					reservation.setRev_price(rset.getInt("rev_price"));
					reservation.setRev_person_count(rset.getInt("rev_person_count"));
					reservation.setHotel_link(rset.getString("hotel_link"));
					reservation.setHotel_name(rset.getString("hotel_name"));
				
					
					list.add(reservation);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				close(rset);
				close(pstmt);
			}
			
			return list;
		}

		public int reservationUpdate(Connection con, Reservation reser, int rev_no) {
			//관리자단에서 예약을 수정하는 파트
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "update reservation set rev_price = ?, rev_checkin = ?, rev_checkout = ?, rev_person_count = ?, hotel_no = ? where rev_no = ?";		
			
			try {
				
				pstmt = con.prepareStatement(query);			
				pstmt.setInt(1, reser.getRev_price());			
				pstmt.setInt(2, reser.getRev_checkin());
				pstmt.setInt(3, reser.getRev_checkout());
				pstmt.setInt(4, reser.getRev_person_count());
				pstmt.setInt(5, reser.getHotel_no());
				pstmt.setInt(6, rev_no);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				close(pstmt);
			}	
			
			return result;
		}

		public ArrayList<MReservation> mgSearch(Connection con, String keyword, String hotel_name,int currentPage, int limit) {
			ArrayList<MReservation> list = new ArrayList<MReservation>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			
			String query="select * from (select rownum rnum, rev_no, user_id, hotel_no, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count, hotel_name, hotel_link from " +
					"(select rev_no, hotel_no, user_id, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count from reservation left join member using(user_id) order by rev_date desc) "
					+"left join ahotel using(hotel_no) where user_id = ? and hotel_name = ?) where rnum >= ? and rnum <= ?";
			
			int startRow = (currentPage - 1) * limit + 1;
			//읽기 시작할 행 번호
			int endRow = startRow + limit - 1;
			//읽을 마지막 행 번호
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, keyword);
				pstmt.setString(2, hotel_name);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				rset = pstmt.executeQuery();
				while(rset.next()){
					MReservation reservation = new MReservation();
				
					reservation.setRev_no(rset.getInt("rev_no"));
					reservation.setUser_id(rset.getString("user_id"));
					reservation.setHotel_no(rset.getInt("hotel_no"));
					reservation.setRev_checkin(rset.getInt("rev_checkin"));
					reservation.setRev_checkout(rset.getInt("rev_checkout"));
					reservation.setRev_date(rset.getDate("rev_date"));
					reservation.setRev_price(rset.getInt("rev_price"));
					reservation.setRev_person_count(rset.getInt("rev_person_count"));
					reservation.setHotel_link(rset.getString("hotel_link"));
					reservation.setHotel_name(rset.getString("hotel_name"));
				
					
					list.add(reservation);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				close(rset);
				close(pstmt);
			}
			
			return list;
		}

		public int getListCount(Connection con, String hotel_name) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			
			String query="select count(*) from (select rev_no, user_id, hotel_no, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count, hotel_name, hotel_link from " +
					"(select rev_no, hotel_no, user_id, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count from reservation left join member using(user_id) order by rev_date desc) "
					+"left join ahotel using(hotel_no) where hotel_name = ?)";
			
			try {
				
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, hotel_name);
				
				rset = pstmt.executeQuery();
				
				
				if(rset.next()){
					listCount = rset.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				close(rset);
				close(pstmt);
			}
			
			return listCount;
		}

		public int getListCount(Connection con, String hotel_name, String keyword) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			
			String query="select count(*) from (select rev_no, user_id, hotel_no, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count, hotel_name, hotel_link from " +
					"(select rev_no, hotel_no, user_id, rev_checkin, rev_checkout, rev_date, "
					+"rev_price, rev_person_count from reservation left join member using(user_id) order by rev_date desc) "
					+"left join ahotel using(hotel_no) where user_id = ? and hotel_name = ?)";
			
			try {
				
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, keyword);
				pstmt.setString(2, hotel_name);
				
				
				rset = pstmt.executeQuery();
				
				
				if(rset.next()){
					listCount = rset.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				close(rset);
				close(pstmt);
			}
			
			return listCount;
		}
		}
		
	

