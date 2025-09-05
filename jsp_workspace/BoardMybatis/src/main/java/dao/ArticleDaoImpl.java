package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Article;
import util.MybatisSqlSessionFactory;

public class ArticleDaoImpl implements ArticleDao {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void close() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}

	@Override
	public Article insert(Article article) throws Exception {
		sqlSession.insert("mapper.article.insertArticle", article);
		sqlSession.commit();
		Article res = sqlSession.selectOne("mapper.article.selectArticle", article.getNum());
//		sqlSession.close();
		return res;
	}

	@Override
	public Article select(Integer num) throws Exception {
		Article article = sqlSession.selectOne("mapper.article.selectArticle", num);
//		sqlSession.close();
		return article;
	}

	@Override
	public List<Article> selectList(Integer row) throws Exception {
		List<Article> articleList = new ArrayList<>();
		articleList = sqlSession.selectList("mapper.article.selectArticleList", row);
//		sqlSession.close();
		return articleList;
	}

	@Override
	public Integer selectCount() throws Exception {
		Integer count = sqlSession.selectOne("mapper.article.selectArticleCount");
//		sqlSession.close();
		return count;
	}

	@Override
	public int update(Article article) throws Exception {
		int result = sqlSession.update("mapper.article.updateArticle", article);
		sqlSession.commit();
//		sqlSession.close();
		return result;
	}

	@Override
	public void updateViewCount(Integer num) {
		sqlSession.update("mapper.article.updateViewCount", num);
		sqlSession.commit();
//		sqlSession.close();
	}

	@Override
	public boolean delete(Integer num) throws Exception {
		int result = sqlSession.delete("mapper.article.deleteArticle", num);
		sqlSession.commit();
//		sqlSession.close();
		return result > 0;
	}

}