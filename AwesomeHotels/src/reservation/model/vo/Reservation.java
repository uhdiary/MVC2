package reservation.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable{
	private int rev_no;
	private String	user_id;
	private int	hotel_no;
	private int	rev_checkin;
	private int rev_checkout;
	private Date rev_date;
	private int	rev_price;
	private int	rev_person_count;
	
	
	public Reservation(){}


	public Reservation(int rev_no, String user_id, int hotel_no, int rev_checkin, int rev_checkout, Date rev_date,
			int rev_price, int rev_person_count) {
		super();
		this.rev_no = rev_no;
		this.user_id = user_id;
		this.hotel_no = hotel_no;
		this.rev_checkin = rev_checkin;
		this.rev_checkout = rev_checkout;
		this.rev_date = rev_date;
		this.rev_price = rev_price;
		this.rev_person_count = rev_person_count;
	}

	public Reservation(String user_id, int hotel_no, int rev_checkin, int rev_checkout,
			int rev_price, int rev_person_count) {
		super();
		this.user_id = user_id;
		this.hotel_no = hotel_no;
		this.rev_checkin = rev_checkin;
		this.rev_checkout = rev_checkout;
		this.rev_price = rev_price;
		this.rev_person_count = rev_person_count;
	}
	
	public Reservation(int hotel_no, int rev_checkin, int rev_checkout,
			int rev_price, int rev_person_count) {
		super();
		this.user_id = user_id;
		this.hotel_no = hotel_no;
		this.rev_checkin = rev_checkin;
		this.rev_checkout = rev_checkout;
		this.rev_price = rev_price;
		this.rev_person_count = rev_person_count;
	}
	
	
	

	public int getRev_no() {
		return rev_no;
	}


	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public int getHotel_no() {
		return hotel_no;
	}


	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}


	public int getRev_checkin() {
		return rev_checkin;
	}


	public void setRev_checkin(int rev_checkin) {
		this.rev_checkin = rev_checkin;
	}


	public int getRev_checkout() {
		return rev_checkout;
	}


	public void setRev_checkout(int rev_checkout) {
		this.rev_checkout = rev_checkout;
	}


	public Date getRev_date() {
		return rev_date;
	}


	public void setRev_date(Date rev_date) {
		this.rev_date = rev_date;
	}


	


	public int getRev_price() {
		return rev_price;
	}


	public void setRev_price(int rev_price) {
		this.rev_price = rev_price;
	}


	public int getRev_person_count() {
		return rev_person_count;
	}


	public void setRev_person_count(int rev_person_count) {
		this.rev_person_count = rev_person_count;
	}
	
	@Override
	public String toString(){
		
		return this.rev_no + ", " +
		this.user_id + ", " +
		this.hotel_no + ", " +
		this.rev_checkin + ", " + 
		this.rev_checkout + ", " +
		this.rev_date + ", " +
		this.rev_price + ", " +
		this.rev_person_count;
	}
	
}
