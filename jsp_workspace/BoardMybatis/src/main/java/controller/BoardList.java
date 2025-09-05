package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Article;
import service.ArticleService;
import service.ArticleServiceImpl;
import util.PageInfo;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String spage = request.getParameter("page");
		Integer page = 1;
		if (spage != null)
			page = Integer.parseInt(spage);

		PageInfo pageInfo = new PageInfo(page);

		try (ArticleService service = new ArticleServiceImpl();) {
			List<Article> articleList = service.listByPage(pageInfo);
			request.setAttribute("articleList", articleList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("boardlist.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 목록 조회 오류");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
