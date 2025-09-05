package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberDAO  extends DBConnection {
	
	public static void insert(Member member) throws Exception {
		Connection conn = getConnection();
		String sql = "insert member (id,name,password,email,address) values (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public static Member select(String id) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				String name=rset.getString("name");
				String password=rset.getString("password");
				String email=rset.getString("email");
				String address=rset.getString("address");
				member = new Member(id,name,password,email,address);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return member;
	}

}
