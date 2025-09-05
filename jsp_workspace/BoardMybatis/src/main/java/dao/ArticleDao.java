package dao;

import java.util.List;

import dto.Article;

public interface ArticleDao extends AutoCloseable {
	Article insert(Article article) throws Exception;
	Article select(Integer num) throws Exception;
	List<Article> selectList(Integer row) throws Exception;
	Integer selectCount() throws Exception;
	int update(Article article) throws Exception;
	void updateViewCount(Integer num);
	boolean delete(Integer num) throws Exception;
}
