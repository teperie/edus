import java.util.List;

import dao.ArticleDao;
import dto.Article;

public class ArticleMain {
	public static void main(String[] args) {
		Article article = ArticleDao.select(1);
		System.out.println(article);

		article.setNum(1);
		article.setTitle("장길동");
		ArticleDao.update(article);

		List<Article> ls = ArticleDao.selectList();
		for (Article u : ls) {
			System.out.println(u);
		}
	}
}
