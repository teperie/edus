package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Article;

public class ArticleDao extends DBConnection {
	public static void insert(Article article) {
		Connection conn = getConnection();
		String sql = "insert into article (title,content,writer) values(?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static void update(Article article) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update article set title = ?, content = ? where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static Article select(int num) {
		Article article = null;
		Connection conn = getConnection();
		String sql = "select * from article where num = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			if (rset != null && rset.next()) {
				String title = rset.getString("title");
				String content = rset.getString("content");
				String writer = rset.getString("writer");
				article = new Article(title, content, writer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return article;
	}

	public static void delete(int num) {
		Connection conn = getConnection();
		String sql = "delect from user where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}

	public static List<Article> selectList() {
		List<Article> articleList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = "select * from article";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				int num = rset.getInt("num");
				String title = rset.getString("title");
				String content = rset.getString("content");
				String writer = rset.getString("writer");
				articleList.add(new Article(num, title, content, writer));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(conn);
		}
		return articleList;
	}
}
