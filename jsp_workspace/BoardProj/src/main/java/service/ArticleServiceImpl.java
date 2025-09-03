package service;

import java.util.List;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import dto.Article;
import util.PageInfo;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDao articleDao;
	public ArticleServiceImpl() {
		articleDao = new ArticleDaoImpl();
	}

	@Override
	public void write(Article article) throws Exception {
		articleDao.insert(article);
	}

	@Override
	public Article detail(Integer num) throws Exception {
		articleDao.updateViewCount(num);
		return articleDao.select(num);
	}
	
	

	@Override
	public List<Article> listByPage(PageInfo pageInfo) throws Exception {
		Integer articleCnt = articleDao.selectCount(); //전체 게시글 수
		Integer allPage = (int)Math.ceil((double)articleCnt/10); //전체 페이지 수
		//startPage : 1~10=>1, 11~20=>11
		Integer startPage = (pageInfo.getCurPage()-1)/10*10+1; //10,20,30
		Integer endPage = startPage+10-1;
		if(endPage>allPage) endPage=allPage;
		
		pageInfo.setAllPage(allPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		Integer row=(pageInfo.getCurPage()-1)*10+1;
		return articleDao.selectList(row-1);
	}

	@Override
	public void updateViewCount(Integer num) throws Exception {
		
	}
}
