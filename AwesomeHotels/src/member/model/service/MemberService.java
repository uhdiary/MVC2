package member.model.service;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.Map;

import member.model.dao.MemberDao;
import member.model.vo.*;

public class MemberService {
	public MemberService(){}
	
	public Member loginCheck(String user_id, String user_pwd){
		Connection con = getConnection();
		Member loginUser = new MemberDao().loginCheck(con, user_id, user_pwd);
		close(con);
		return loginUser;
	}

	public int insertMember(Member member){
		Connection con = getConnection();
		int result = new MemberDao().insertMember(con, member);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
		return result;
	}
	
	public Member selectMember(String user_id){
		Connection con = getConnection();
		Member member = new MemberDao().selectMember(con, user_id);
		close(con);
		return member;
		
	}

	public int deleteMember(String user_id) {
		Connection con = getConnection();
		int result = new MemberDao().deleteMember(con, user_id);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
		return result;
	}

	public int updateMember(Member member) {
		Connection con = getConnection();
	      int result = new MemberDao().updateMember(con, member);

	      if (result > 0)
	         commit(con);
	      else
	         rollback(con);

	      close(con);
	      return result;

	}

	public Map<String, Member> selectAll(String user_code) {
		Connection con = getConnection();
		Map<String, Member> resultMap = new MemberDao().selectAll(con, user_code);
		close(con);
		return resultMap;
	}

	public int idoverCheck(String user_id) {
		Connection con = getConnection();
		int member = new MemberDao().idoverCheck(con, user_id);
		close(con);
		return member;
	}

	public int intsertMember(Member member) {
		Connection con = getConnection();
		int result = new MemberDao().intsertMember(con, member);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
		return result;
	}

	public int idpwdMember(Member member) {
		Connection con = getConnection();
		int result = new MemberDao().idpwdMember(con, member);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
		return result;
	}

	public String memberId(String user_name, String email, String email_o) {
		Connection con = getConnection();
		String result = new MemberDao().memberId(con, user_name, email, email_o);
		
		close(con);
		return result;
	}

	public String memberId(String user_name, String phone, String phone_o, String phone_t) {
		Connection con = getConnection();
		String result = new MemberDao().memberId(con, user_name, phone, phone_o, phone_t);
		
		close(con);
		return result;
	}
	
	public String memberPwd(String user_id, String user_name, String phone, String phone_o, String phone_t) {
		Connection con = getConnection();
		String result = new MemberDao().memberPwd(con, user_id, user_name, phone, phone_o, phone_t);
		
		close(con);
		return result;
	}

	public String memberPwd(String user_id, String user_name, String email, String email_o) {
		Connection con = getConnection();
		String result = new MemberDao().memberPwd(con, user_id, user_name, email, email_o);
		
		close(con);
		return result;
	}

	public int insertManager(Member member) {
		Connection con = getConnection();
		int result = new MemberDao().insertManager(con, member);
		
		if(result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
		return result;
	}
}


