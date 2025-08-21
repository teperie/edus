import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.UserDao;
import dto.User;

public class TestMain {
	public static void insert(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "7564");
			System.out.println("DB 접속 성공");
//			String sql = "insert into user values('kong','공길동')";
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "행이 추가되었습니다.");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void insertPrepared(String sql, String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "7564");
			pstmt = conn.prepareStatement(sql);

			int i = 1;
			for (String arg : args) {
				pstmt.setString(i, arg);
				i++;
			}

//			pstmt.setString(1, "게시글제목");
//			pstmt.setString(2, "게시글내용");
//			pstmt.setString(3, "kong");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "행이 추가되었습니다.");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "7564");
			System.out.println("DB 접속 성공");
//			String sql = "insert into user values('kong','공길동')";
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "행이 수정되었습니다.");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ResultSet select(String sql, String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "7564");
			pstmt = conn.prepareStatement(sql);

			int i = 1;
			for (String arg : args) {
				pstmt.setString(i, arg);
				i++;
			}
			rs = pstmt.executeQuery();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	public static void insertArticle() {
		String sql = "insert into article (title, content, writer) values(?,?,?)";
		insertPrepared(sql, new String[] { "게시글제목", "게시글내용", "kong" });
	}

	public static void insertUser() {
		String sql = "insert into user values('kong','공길동')";
		insert(sql);
	}

	public static void updateUser() {
		String sql = "update user set name='송송송' where id = 'song'";
		update(sql);
	}

	public static void selectUser() {
		String sql = "select * from user";
		ResultSet rs = select(sql, new String[] {});
		try {
			while (rs != null && rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("id: %s, name: %s", id, name);
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void selectArticleList() {
		String sql = "select * from article";
		ResultSet rs = select(sql, new String[] {});
		try {
			while (rs != null && rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				System.out.printf("title: %s, content: %s, writer: %s", title, content, writer);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		insertArticle();
//		updateUser();
//		selectUser();
		selectArticleList();

	}
}
