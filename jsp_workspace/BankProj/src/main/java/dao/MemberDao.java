package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dto.Member;

public class MemberDao extends DBConnection {
	public static void insert(Member mem) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static Member select(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=?";
		Member mem = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				mem = new Member(rs.getString("id"), rs.getString("name"), rs.getString("password"),
						rs.getString("email"), rs.getString("address"));
			}
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return mem;
	}

	public static List<Member> selectList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from member";
		List<Member> list = new java.util.ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Member mem = new Member(rs.getString("id"), rs.getString("name"), rs.getString("password"),
						rs.getString("email"), rs.getString("address"));
				list.add(mem);
			}
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return list;
	}
}
