package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FinalPracDAO {
	Connection conn = null;
	public FinalPracDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setInsert(FinalPracVO vo) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into hoewon values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getAddress()+"')";
			stmt.executeUpdate(sql);
			System.out.println("등록이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<FinalPracVO> getList() {
		ArrayList<FinalPracVO> vos = new ArrayList<FinalPracVO>();
		FinalPracVO vo = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoewon";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				vo = new FinalPracVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("Name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vos;
	}

	public FinalPracVO getSearch(String name) {
		FinalPracVO vo = new FinalPracVO();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from hoewon where name = '"+name+"'");
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
