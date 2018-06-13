package manager.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.*;

import manager.model.dao.ManagerDao;
import manager.model.vo.*;
import paper.model.dao.PaperDao;
import paper.model.vo.Paper;

public class ManagerService {
	public ManagerService() {
	}

	public ArrayList<Manager> selectList() {
		Connection con = getConnection();
		ArrayList<Manager> list = new ManagerDao().selectList(con);
		close(con);
		return list;
	}

	public int insertManager(Manager manager) {
		Connection con = getConnection();
		int result = new ManagerDao().insertManager(con, manager);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);
		return result;
	}

	public int deleteNotice(int hotel_no) {
		Connection con = getConnection();
		int result = new ManagerDao().deleteManager(con, hotel_no);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public ArrayList<Manager> selectNameList(String keyword, int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Manager> list = new ManagerDao().selectNameList(con, keyword);
		close(con);
		return list;
	}
	
	public ArrayList<Manager> selectAddressList(String keyword, int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Manager> list = new ManagerDao().selectAddressList(con, keyword);
		close(con);
		return list;
	}


	public ArrayList<Manager> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Manager> list = new ManagerDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new ManagerDao().getListCount(con);
		close(con);
		return listCount;
	}

	public int getListCount(String keyword) {
		Connection con = getConnection();
		int listCount = new ManagerDao().getListCount(con, keyword);
		close(con);
		return listCount;
	}

	public ArrayList<Manager> selectList(String keyword, int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Manager> list = new ManagerDao().selectList(con, keyword, currentPage, limit);
		close(con);
		return list;
	}

	public int updateManager(Manager manager) {
		Connection con = getConnection();
		int result = new ManagerDao().updateManager(con, manager);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public Manager selectManager(int hotel_no) {
		Connection con = getConnection();
		Manager result = new ManagerDao().selectManager(con, hotel_no);
		if (result != null)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public int deleteManager(int hotel_no) {
		Connection con = getConnection();
		int result = new ManagerDao().deleteManager(con, hotel_no);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		return result;
	}

	public int getListHotelCount(String keyword) {
		      Connection con = getConnection();
		      int listCount = new ManagerDao().getListHotelCount(con, keyword);
		      close(con);
		      
		      return listCount;
		   }

	public ArrayList<Manager> selectHotelList(int currentPage, int limit, String keyword) {
	      Connection con = getConnection();
	         ArrayList<Manager> list = new ManagerDao().selectManagerHotelList(con, keyword, currentPage, limit);
	         close(con);
	         return list;
	   }

	public int getListAddressCount(String keyword) {
		  Connection con = getConnection();
	      int listCount = new ManagerDao().getListAddressCount(con, keyword);
	      close(con);
	      return listCount;
	   }

	public ArrayList<Manager> selectAddressList(int currentPage, int limit, String keyword) {
		 Connection con = getConnection();
         ArrayList<Manager> list = new ManagerDao().selectManagerAddressList(con, keyword, currentPage, limit);
         close(con);
         return list;
   }
}
