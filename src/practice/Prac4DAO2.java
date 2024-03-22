package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prac4DAO2 {
	Connection conn = null;
	public Prac4DAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Prac4VO getList() {
		Prac4VO vo = new Prac4VO();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoewon";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			rs.next();
			rs.next();
			vo.setIdx(rs.getInt("idx"));  
			vo.setName(rs.getString("name")); 
			vo.setAge(rs.getInt("age")); 
			vo.setGender(rs.getString("gender")); 
			vo.setAddress(rs.getString("address")); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}

}
