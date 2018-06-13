package member.model.vo;

import java.sql.Date;

@SuppressWarnings("serial")
public class Member implements java.io.Serializable {
	// Field
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_no;
	private String phone;
	private String phone_o;
	private String phone_t;
	private String postal;
	private String address;
	private String email;
	private String email_o;
	private char gender;
	private String user_code;
	private String hotel_name;
	private Date enroll_date;
	
	public Member() {}

	public Member(String user_id, String user_pwd, String user_name, String user_code,String hotel_name) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_code = user_code;
		this.hotel_name = hotel_name;
	}

	public Member(String user_id, String user_pwd, String user_name, String user_no, String phone, String phone_o,
			String phone_t, String postal, String address, String email, String email_o, char gender, String user_code,
			Date enroll_date) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_no = user_no;
		this.phone = phone;
		this.phone_o = phone_o;
		this.phone_t = phone_t;
		this.postal = postal;
		this.address = address;
		this.email = email;
		this.email_o = email_o;
		this.gender = gender;
		this.user_code = user_code;
		this.enroll_date = enroll_date;
	}

	public Member(String user_id, String user_pwd, String user_name, String user_no, String phone, String phone_o,
			String phone_t, String postal, String address, String email, String email_o, char gender, String user_code,
			String hotel_name, Date enroll_date) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_no = user_no;
		this.phone = phone;
		this.phone_o = phone_o;
		this.phone_t = phone_t;
		this.postal = postal;
		this.address = address;
		this.email = email;
		this.email_o = email_o;
		this.gender = gender;
		this.user_code = user_code;
		this.hotel_name = hotel_name;
		this.enroll_date = enroll_date;
	}
	
	public Member(String user_name, String email, String email_o, Date enroll_date) {
		super();
		this.user_name = user_name;
		this.email = email;
		this.email_o = email_o;
		this.enroll_date = enroll_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone_o() {
		return phone_o;
	}

	public void setPhone_o(String phone_o) {
		this.phone_o = phone_o;
	}

	public String getPhone_t() {
		return phone_t;
	}

	public void setPhone_t(String phone_t) {
		this.phone_t = phone_t;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_o() {
		return email_o;
	}

	public void setEmail_o(String email_o) {
		this.email_o = email_o;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	
	
	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	@Override
	public String toString() {
		return this.user_id + ", " + this.user_pwd + ", " + this.user_name + ", "
				+ this.user_no + ", " + this.phone + ", " + this.phone_o + ", " + this.phone_t + ", " + this.postal + ", " 
				+ this.address + ", " + this.email + ", " + this.email_o + ", " + this.gender + ", " + this.user_code + ", " + this.enroll_date+this.hotel_name;
	}

	
}