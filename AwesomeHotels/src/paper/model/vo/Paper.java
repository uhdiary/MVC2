package paper.model.vo;

import java.io.*;
import java.sql.*;

public class Paper implements Serializable {
	private int paper_no;
	private int paper_hotel_no;
	private String paper_title;
	private String paper_writer;
	private String paper_content;
	private Date paper_date;
	private int paper_count;
	private int paper_ref;
	private int paper_step;
	private int paper_depth;
	private int paper_reply_ref;
	private int paper_reply_lev;
	private int paper_reply_seq;
	
	

	public Paper(int paper_no, int paper_hotel_no, String paper_title, String paper_writer, String paper_content,
			Date paper_date, int paper_count, int paper_ref, int paper_step, int paper_depth, int paper_reply_ref,
			int paper_reply_lev, int paper_reply_seq) {
		super();
		this.paper_no = paper_no;
		this.paper_hotel_no = paper_hotel_no;
		this.paper_title = paper_title;
		this.paper_writer = paper_writer;
		this.paper_content = paper_content;
		this.paper_date = paper_date;
		this.paper_count = paper_count;
		this.paper_ref = paper_ref;
		this.paper_step = paper_step;
		this.paper_depth = paper_depth;
		this.paper_reply_ref = paper_reply_ref;
		this.paper_reply_lev = paper_reply_lev;
		this.paper_reply_seq = paper_reply_seq;
	}


	public int getPaper_reply_ref() {
		return paper_reply_ref;
	}


	public void setPaper_reply_ref(int paper_reply_ref) {
		this.paper_reply_ref = paper_reply_ref;
	}


	public int getPaper_reply_lev() {
		return paper_reply_lev;
	}


	public void setPaper_reply_lev(int paper_reply_lev) {
		this.paper_reply_lev = paper_reply_lev;
	}


	public int getPaper_reply_seq() {
		return paper_reply_seq;
	}


	public void setPaper_reply_seq(int paper_reply_seq) {
		this.paper_reply_seq = paper_reply_seq;
	}


	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Paper(String paper_title, String paper_writer, String paper_content) {
		super();
		this.paper_title = paper_title;
		this.paper_writer = paper_writer;
		this.paper_content = paper_content;
	}


	public Paper(int paper_no, String paper_title, String paper_writer, String paper_content,
			Date paper_date, int paper_count) {
		super();
		this.paper_no = paper_no;
		this.paper_title = paper_title;
		this.paper_writer = paper_writer;
		this.paper_content = paper_content;
		this.paper_date = paper_date;
		this.paper_count = paper_count;
	}
	

	public Paper(String paper_title, String paper_content, int paper_no) {
		super();
		this.paper_title = paper_title;
		this.paper_content = paper_content;
		this.paper_no = paper_no;
	}




	public Paper(String paper_title, String paper_writer, String paper_content, int paper_no, int paper_reply_lev, int paper_reply_seq) {
		super();
		this.paper_title = paper_title;
		this.paper_writer = paper_writer;
		this.paper_content = paper_content;
		this.paper_no = paper_no;
		this.paper_reply_lev = paper_reply_lev;
		this.paper_reply_seq = paper_reply_seq;
	}


	public int getPaper_hotel_no() {
		return paper_hotel_no;
	}


	public void setPaper_hotel_no(int paper_hotel_no) {
		this.paper_hotel_no = paper_hotel_no;
	}


	public int getPaper_no() {
		return paper_no;
	}


	public void setPaper_no(int paper_no) {
		this.paper_no = paper_no;
	}


	public String getPaper_title() {
		return paper_title;
	}


	public void setPaper_title(String paper_title) {
		this.paper_title = paper_title;
	}


	public String getPaper_writer() {
		return paper_writer;
	}


	public void setPaper_writer(String paper_writer) {
		this.paper_writer = paper_writer;
	}


	public String getPaper_content() {
		return paper_content;
	}


	public void setPaper_content(String paper_content) {
		this.paper_content = paper_content;
	}


	public Date getPaper_date() {
		return paper_date;
	}


	public void setPaper_date(Date paper_date) {
		this.paper_date = paper_date;
	}


	public int getPaper_count() {
		return paper_count;
	}


	public void setPaper_count(int paper_count) {
		this.paper_count = paper_count;
	}


	@Override
	public String toString() {
		return paper_hotel_no + ", " + paper_no + ", " + paper_title + ", " + paper_writer + ", " + paper_content + ", "
				+ paper_date + ", " + paper_count;
	}


	public int getPaper_ref() {
		return paper_ref;
	}


	public void setPaper_ref(int paper_ref) {
		this.paper_ref = paper_ref;
	}


	public int getPaper_step() {
		return paper_step;
	}


	public void setPaper_step(int paper_step) {
		this.paper_step = paper_step;
	}


	public int getPaper_depth() {
		return getPaper_depth();
	}


	public void setPaper_depth(int paper_depth) {
		this.paper_depth = paper_depth;
	}

}