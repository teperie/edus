package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Article;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public Article insert(Article article) throws Exception {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "insert into article (title,content,writer,filename,imgfilename) values (?,?,?,?,?);";
		try {
			pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.setString(4, article.getFilename());
			pstmt.setString(5, article.getImgfilename());
			pstmt.executeUpdate();
			DBConnection.commit(conn);
			rset = pstmt.getGeneratedKeys();
			if(rset!=null && rset.next()) {
				article.setNum(rset.getInt(1));
			}
		} catch(Exception e) {
			DBConnection.rollback(conn);
			e.printStackTrace();
		} finally {
			DBConnection.close(rset);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return article;
	}

	@Override
	public Article select(Integer num) throws Exception {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Article article = null;
		String sql = "select * from article where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				String title = rset.getString("title");
				String content = rset.getString("content");
				String writer = rset.getString("writer");
				String filename = rset.getString("filename");
				String imgfilename = rset.getString("imgfilename");
				Integer viewcnt = rset.getInt("viewcnt");
				Date createdate = rset.getDate("createdate");
				article = new Article(num,title,content,writer,filename,imgfilename,viewcnt,createdate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rset);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		 
		return article;
	}

	@Override
	public List<Article> selectList(Integer row) throws Exception {
		List<Article> articleList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from article order by num desc limit ?, 10";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, row);
			rset=pstmt.executeQuery();
			if(rset!=null) {
				while(rset.next()) {
					Integer num=rset.getInt("num");
					String title=rset.getString("title");
					String content=rset.getString("content");
					String writer=rset.getString("writer");
					String filename=rset.getString("filename");
					String imgfilename=rset.getString("imgfilename");
					Integer viewcnt=rset.getInt("viewcnt");
					Date createdate=rset.getDate("createdate");
					articleList.add(new Article(num,title,content,writer,filename,imgfilename,viewcnt,createdate));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rset);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return articleList;
	}

	@Override
	public Integer selectCount() throws Exception {
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		Integer cnt = 0;
		String sql = "select count(*) from article";
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(sql);
			if(rset!=null && rset.next()) {
				cnt=rset.getInt(1);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rset);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return cnt;
	}

}
