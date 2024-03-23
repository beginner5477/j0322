package t6_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	SalaryVO vo = null;
	public SalaryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaclass", "atom", "1234");
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

	//자료 전체 조회
	public ArrayList<SalaryVO> getList() {
		ArrayList<SalaryVO> vos = new ArrayList<SalaryVO>();
		try {
			sql = "select * from salary";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vo = new SalaryVO();
				vo.setJikkub(rs.getString("jikkub"));
				vo.setBonbong(rs.getInt("bonbong"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vos;
	}

	//자료 개별 서치
	public SalaryVO salarySearch(String ans) {
		vo = new SalaryVO();
		try {
			sql = "select * from salary where jikkub = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ans);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				vo.setJikkub(rs.getString("jikkub"));
				vo.setBonbong(rs.getInt("bonbong"));
			}
			else vo.setBonbong(-1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vo;
	}

	//자료 등록하기
	public int setSalary(String ans, int ans2) {
		int res = 0;
		try {
			sql = "insert into salary values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ans);
			pstmt.setInt(2, ans2);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return res;
	}

	//자료 수정하기
	public int setSalaryEdit(SalaryVO vo, String ans) {
		int res = 0;
		try {
			sql = "update salary set jikkub = ?, bonbong = ? where jikkub = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getJikkub());
			pstmt.setInt(2, vo.getBonbong());
			pstmt.setString(3, ans);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	//자료 삭제처리하기
	public int setDelete(SalaryVO vo) {
		int res = 0;
		try {
			sql = "delete from salary where jikkub = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println(vo);
			pstmt.setString(1, vo.getJikkub());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return res;
	}

}
