package dao;

import java.util.List;

import dto.Article;

public interface ArticleDao {
	Article insert(Article article) throws Exception;
	Article select(Integer num) throws Exception;
	List<Article> selectList(Integer row) throws Exception;
	Integer selectCount() throws Exception;
}
