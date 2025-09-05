package service;

import java.util.List;

import dto.Article;
import util.PageInfo;

public interface ArticleService {
	void write(Article article) throws Exception;
	Article detail(Integer num) throws Exception;
	List<Article> listByPage(PageInfo pageInfo) throws Exception;
	void updateViewCount(Integer num) throws Exception;
	Article modify(Article article) throws Exception;
	boolean delete(Integer num) throws Exception;
}