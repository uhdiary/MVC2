package common;

import java.sql.*;
import java.util.*;
import java.io.*;

public class JDBCTemplate {
	//public static Connection getConnection() {
		// null point 오류인 경이 이파일을 확인해 봐야한다.
		/*Connection con = null;
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("/testw/driver.properties"));

			Class.forName(prop.getProperty("driver"));

			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("password"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}*/

	public static Connection getConnection(){
		
		Connection con = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hotel","hotel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	
	
	
	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed()){
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt) {

		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
