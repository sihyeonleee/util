package main.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConn {
	public void test(){
		String driver = "com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://52.231.161.190:3306/ebsesof2";
		String userNm = "esofedu2";
		String userPw = "esofedu2";
		  
		Connection conn = null;
		PreparedStatement pstmt = null;
		  
		String sql="SELECT * FROM TB_SUM_USER_INFO WHERE USER_SN = ?";
		  
		try {
			  
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			  
			conn = DriverManager.getConnection(url, userNm, userPw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "2");
			  
			ResultSet result = pstmt.executeQuery();
			while(result.next()) { 
				System.out.println( result.getString("USER_ID") );
			}

		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!= " + e.getMessage());
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
			} catch (Exception ignored) {
			
			}
			
			try {
				conn.close();
			} catch (Exception ignored) {
			
			}
			
		}		
	}
}
