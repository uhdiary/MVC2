package reservation.model.vo;



import java.io.Serializable;
import java.sql.Date;

public class MReservation extends Reservation implements Serializable{

	private String hotel_name;
	private String hotel_link;
	private String user_id;
	
	
	
	public MReservation(){
		
	}

	public MReservation(String hotel_name, String hotel_link, String user_id) {
		super();
		this.hotel_name = hotel_name;
		this.hotel_link = hotel_link;
		this.user_id = user_id;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


	public String getHotel_link() {
		return hotel_link;
	}


	public void setHotel_link(String hotel_link) {
		this.hotel_link = hotel_link;
	}


	@Override
	public String toString(){
		
		return super.getRev_no() + ", " +
		super.getUser_id() + ", " +
		super.getRev_no() + ", " +
		super.getRev_checkin() + ", " + 
		super.getRev_checkout() + ", " +
		super.getRev_date()+ ", " +
		super.getRev_price()+ ", " +
		super.getRev_person_count() + this.hotel_name + ", " +
		this.hotel_link;
	}
	
	
}
