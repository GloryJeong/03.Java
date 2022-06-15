package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	// step01
	// Driver 로딩
	// 표준 (형식정해져있음) - Class.forName("com.mysql.cj.jdbc.Driver");
	static {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	   }
	
	
	// DB 연결 기능 메소드
	// step02*
    // DB연결
    // ip주소, DB 이름, 계정 이름/비밀번호, ....
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","scott","tiger");
	}

	
	// DB 자원반환 : close
	public static void close(ResultSet rset, Statement stmt, Connection conn)  {
		try {
			if(rset != null) {
				rset.close();
				rset=null;
			}
			if(stmt != null) {
				stmt.close();
				stmt=null;
			}
			if(conn != null) {
				conn.close();
				conn=null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt, Connection conn)  {
		try {
			if(stmt != null) {
				stmt.close();
				stmt=null;
			}
			if(conn != null) {
				conn.close();
				conn=null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
