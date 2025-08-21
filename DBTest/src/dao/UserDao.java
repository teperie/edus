package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.User;

public class UserDao extends DBConnection {
	public static void insert(User user) {
		Connection conn = getConnection();
		String sql = "insert into user (id,name) values(?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static void update(User user) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update user set name = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static User select(String id) {
		User user = null;
		Connection conn = getConnection();
		String sql = "select * from user where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset != null && rset.next()) {
				String rid = rset.getString("id");
				String name = rset.getString("name");
				user = new User(rid, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return user;
	}

	public static void delete(String id) {
		Connection conn = getConnection();
		String sql = "delect from user where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static List<User> selectList() {
		List<User> userList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = "select * from user";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				String id = rset.getString("id");
				String name = rset.getString("name");
				userList.add(new User(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(conn);
		}
		return userList;
	}
}
