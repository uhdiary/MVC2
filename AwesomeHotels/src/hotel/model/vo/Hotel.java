package hotel.model.vo;

public class Hotel implements java.io.Serializable {
	public Hotel(){} // 기본 생성자
	private int hotel_no; // 호텔 고유번호, primary key
	private String hotel_name; // 호텔명
	private String hotel_address; // 호텔주소와 좌표값, 예) 주소/lat/lng
	private String hotel_info; // 호텔 설명
	private String hotel_link; // 사진이 들어있는 위치
	private String hotel_fac1; // 일반사항
	private String hotel_fac2; // 서비스
	private String hotel_fac3; // 인터넷
	private String hotel_fac4; // 주차
	private String hotel_start_time; // 체크인 시간
	private String hotel_end_time; // 체크아웃 시간
	private String hotel_travel; // 주변 관광지
	private int hotel_price; // 1박 가격
	public Hotel(int hotel_no, String hotel_name,
			String hotel_address, String hotel_info,
			String hotel_link, String hotel_fac1, 
			String hotel_fac2, String hotel_fac3, 
			String hotel_fac4, String hotel_start_time,
			String hotel_end_time, String hotel_travel,
			int hotel_price) { // 모든 매개변수가 들어가는 생성자
		super();
		this.hotel_no = hotel_no;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_info = hotel_info;
		this.hotel_link = hotel_link;
		this.hotel_fac1 = hotel_fac1;
		this.hotel_fac2 = hotel_fac2;
		this.hotel_fac3 = hotel_fac3;
		this.hotel_fac4 = hotel_fac4;
		this.hotel_start_time = hotel_start_time;
		this.hotel_end_time = hotel_end_time;
		this.hotel_travel = hotel_travel;
		this.hotel_price = hotel_price;
	}
//	모든 getter 와 setter
	public int getHotel_no() {
		return hotel_no;
	}
	public void setHotel_no(int hotel_no) {
		this.hotel_no = hotel_no;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getHotel_info() {
		return hotel_info;
	}
	public void setHotel_info(String hotel_info) {
		this.hotel_info = hotel_info;
	}
	public String getHotel_link() {
		return hotel_link;
	}
	public void setHotel_link(String hotel_link) {
		this.hotel_link = hotel_link;
	}
	public String getHotel_fac1() {
		return hotel_fac1;
	}
	public void setHotel_fac1(String hotel_fac1) {
		this.hotel_fac1 = hotel_fac1;
	}
	public String getHotel_fac2() {
		return hotel_fac2;
	}
	public void setHotel_fac2(String hotel_fac2) {
		this.hotel_fac2 = hotel_fac2;
	}
	public String getHotel_fac3() {
		return hotel_fac3;
	}
	public void setHotel_fac3(String hotel_fac3) {
		this.hotel_fac3 = hotel_fac3;
	}
	public String getHotel_fac4() {
		return hotel_fac4;
	}
	public void setHotel_fac4(String hotel_fac4) {
		this.hotel_fac4 = hotel_fac4;
	}
	public String getHotel_start_time() {
		return hotel_start_time;
	}
	public void setHotel_start_time(String hotel_start_time) {
		this.hotel_start_time = hotel_start_time;
	}
	public String getHotel_end_time() {
		return hotel_end_time;
	}
	public void setHotel_end_time(String hotel_end_time) {
		this.hotel_end_time = hotel_end_time;
	}
	public String getHotel_travel() {
		return hotel_travel;
	}
	public void setHotel_travel(String hotel_travel) {
		this.hotel_travel = hotel_travel;
	}
	public int getHotel_price() {
		return hotel_price;
	}
	public void setHotel_price(int hotel_price) {
		this.hotel_price = hotel_price;
	}
}
