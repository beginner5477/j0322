package t6_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "";
	ResultSet rs = null;
	int res = 0;
	InsaVO vo = new InsaVO();
	
	public InsaDAO() {
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
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rsClose() {
		try {
			if(rs != null)
			{
				rs.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//전체 조회
	public ArrayList<InsaVO> getList() {
		ArrayList<InsaVO> vos = new ArrayList<InsaVO>();
		try {
			sql = "select * from insa";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vo = new InsaVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSabun(rs.getString("sabun"));
				vo.setBuseo(rs.getString("buseo"));
				vo.setName(rs.getString("name"));
				vo.setJikkub(rs.getString("jikkub"));
				vo.setAge(rs.getInt("age"));
				vo.setIpsail(rs.getString("ipsail").substring(0,10));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vos.add(vo);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}
	
	//사번만들기용 날짜 검색
	public int DateSearch(String ipsail) {
		int cnt = 0;
		try {
			sql = "select sabun from insa where ipsail = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ipsail);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return cnt;
	}

	//자료 등록
	public int setSalary(InsaVO vo) {
		try {
			sql = "insert into insa values (default,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSabun());
			pstmt.setString(2, vo.getBuseo());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getJikkub());
			pstmt.setInt(5, vo.getAge());
			pstmt.setString(6, vo.getIpsail());
			pstmt.setString(7, vo.getGender());
			pstmt.setString(8, vo.getAddress());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	
}
