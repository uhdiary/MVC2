package member.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;

import member.model.vo.*;

public class MemberDao {
	public MemberDao() {
	}

	public Member loginCheck(Connection con, String user_id, String user_pwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select user_name, user_code, hotel_name from member where " + "user_id = ? and user_pwd = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pwd);
			
			
			rset = pstmt.executeQuery(); 

			if (rset.next()) {
				member = new Member(user_id, user_pwd, rset.getString(1), rset.getString(2), rset.getString(3)); 
																			
																			
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int insertMember(Connection con, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '1', null, sysdate)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(2, member.getUser_pwd());
			pstmt.setString(3, member.getUser_name());
			pstmt.setString(4, member.getUser_no());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getPhone_o());
			pstmt.setString(7, member.getPhone_t());
			pstmt.setString(8, member.getPostal());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getEmail());
			pstmt.setString(11, member.getEmail_o());
			pstmt.setString(12, String.valueOf(member.getGender()));

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection con, String user_id) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where user_id = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				member = new Member();

				member.setUser_id(rset.getString("user_id"));
				member.setUser_pwd(rset.getString("user_pwd"));
				member.setUser_name(rset.getString("user_name"));
				member.setUser_no(rset.getString("user_no"));
				member.setPhone(rset.getString("phone"));
				member.setPhone_o(rset.getString("phone_o"));
				member.setPhone_t(rset.getString("phone_t"));
				member.setPostal(rset.getString("postal"));
				member.setAddress(rset.getString("address"));
				member.setEmail(rset.getString("email"));
				member.setEmail_o(rset.getString("email_o"));
				member.setGender(rset.getString("gender").charAt(0));
				member.setUser_code(rset.getString("user_code"));
				member.setEnroll_date(rset.getDate("enroll_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return member;
	}

	public int deleteMember(Connection con, String user_id) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from member where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);

			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;
	
	}

	public int updateMember(Connection con, Member member) {
		int result = 0;
	      PreparedStatement pstmt = null;

	      String query = "update member set user_pwd = ?, email = ?, email_o = ?, " +
	            "postal = ?, address = ?, phone = ?, phone_o = ?, phone_t = ?,"
	    		  + "user_no = ? where user_id = ?";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, member.getUser_pwd());
	         pstmt.setString(2, member.getEmail());
	         pstmt.setString(3, member.getEmail_o());
	         pstmt.setString(4, member.getPostal());
	         pstmt.setString(5, member.getAddress());
	         pstmt.setString(6, member.getPhone());
	         pstmt.setString(7, member.getPhone_o());
	         pstmt.setString(8, member.getPhone_t());
	         pstmt.setString(9, member.getUser_no());
	         pstmt.setString(10, member.getUser_id());

	         result = pstmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();

	      } finally {
	         close(pstmt);
	      }
	         return result;
	}

	public Map<String, Member> selectAll(Connection con, String user_code) {
		Map<String, Member> resultMap = null;
		Statement stmt = null;
		ResultSet rest = null;

		String query = "select * from member";

		try {
			stmt = con.createStatement();

			rest = stmt.executeQuery(query);

		if(rest != null){
			resultMap = new HashMap<String, Member>();
			
		while(rest.next()){
			Member member = new Member();
		
			member.setUser_id(rest.getString("user_id"));
			member.setUser_pwd(rest.getString("user_pwd"));
			member.setUser_name(rest.getString("user_name"));
			member.setUser_no(rest.getString("user_no"));
			member.setPhone(rest.getString("phone"));
			member.setPhone_o(rest.getString("phone_o"));
			member.setPhone_t(rest.getString("phone_t"));
			member.setPostal(rest.getString("postal"));
			member.setAddress(rest.getString("address"));
			member.setEmail(rest.getString("email"));
			member.setEmail_o(rest.getString("email_o"));
			member.setGender(rest.getString("gender").charAt(0));
			member.setUser_code(rest.getString("user_code"));
			member.setEnroll_date(rest.getDate("enroll_date"));
			
			resultMap.put(member.getUser_id(), member);
		}
		}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(rest);
			close(stmt);
		}
		return resultMap;
	}

	public int intsertMember(Connection con, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(2, member.getUser_pwd());
			pstmt.setString(3, member.getUser_name());
			pstmt.setString(4, member.getUser_no());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getPhone_o());
			pstmt.setString(7, member.getPhone_t());
			pstmt.setString(8, member.getPostal());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getEmail());
			pstmt.setString(11, member.getEmail_o());
			pstmt.setString(12, String.valueOf(member.getGender()));
			pstmt.setString(13, String.valueOf(member.getUser_code()));
			pstmt.setString(14, member.getHotel_name());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;
	}

	public int idoverCheck(Connection con, String user_id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from member where user_id = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			
			rset = pstmt.executeQuery();
			if(rset.next())
				result = rset.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;
	}

	public int idpwdMember(Connection con, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into member values (?, ?, ?, sysdate)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUser_name());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getEmail_o());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;
	}

	public String memberId(Connection con, String user_name, String phone, String phone_o, String phone_t) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String query = "select user_id  from member where user_name = ? and  phone = ? and phone_o = ? and phone_t = ?";
	      String user_id ="";
	      String result = "";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, user_name);
	         pstmt.setString(2, phone);
	         pstmt.setString(3, phone_o);
	         pstmt.setString(4, phone_t);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()){
	            user_id = rset.getString(1);
	             
	         }
	         result = user_id;
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }   
	      return result;
	   }

	public String memberId(Connection con, String user_name, String email, String email_o) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String query = "select user_id  from member where user_name = ? and  email = ? and email_o = ?";
	      String user_id ="";
	      String result = "";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, user_name);
	         pstmt.setString(2, email);
	         pstmt.setString(3, email_o);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()){
	        	 user_id  = rset.getString(1);
	             
	         }
	         result = user_id;
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }	      
	   
	      return result;
	}

	public String memberPwd(Connection con, String user_id, String user_name, String phone, String phone_o, String phone_t) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String query = "select user_pwd from member where user_id = ? and user_name = ? and  phone = ? and phone_o = ? and phone_t = ?";
	      String user_pwd ="";
	      String result = "";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, user_id);
	         pstmt.setString(2, user_name);
	         pstmt.setString(3, phone);
	         pstmt.setString(4, phone_o);
	         pstmt.setString(5, phone_t);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()){
	        	 user_pwd  = rset.getString(1);
	             
	         }
	         result = user_pwd;
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }	      
	   
	      return result;
	}

	public String memberPwd(Connection con, String user_id, String user_name, String email, String email_o) {
		PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String query = "select user_pwd from member where user_id = ? and user_name = ? and  email = ? and email_o = ?";
	      String user_pwd ="";
	      String result = "";

	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1, user_id);
	         pstmt.setString(2, user_name);
	         pstmt.setString(3, email);
	         pstmt.setString(4, email_o);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()){
	        	 user_pwd  = rset.getString(1);
	             
	         }
	         result = user_pwd;
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }	      
	   
	      return result;
	}

	public int insertManager(Connection con, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(2, member.getUser_pwd());
			pstmt.setString(3, member.getUser_name());
			pstmt.setString(4, member.getUser_no());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getPhone_o());
			pstmt.setString(7, member.getPhone_t());
			pstmt.setString(8, member.getPostal());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getEmail());
			pstmt.setString(11, member.getEmail_o());
			pstmt.setString(12, String.valueOf(member.getGender()));
			pstmt.setString(13, String.valueOf(member.getUser_code()));
			pstmt.setString(14, member.getHotel_name());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}
		return result;
	}

}