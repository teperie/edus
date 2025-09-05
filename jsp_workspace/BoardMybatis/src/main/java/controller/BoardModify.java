package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.Article;
import service.ArticleService;
import service.ArticleServiceImpl;

/**
 * Servlet implementation class BoardModify
 */
@WebServlet("/boardModify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardModify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numStr = request.getParameter("num");
		if (numStr == null) {
			response.sendRedirect("error.jsp");
			return;
		}
		Integer num = Integer.parseInt(numStr);

		try (ArticleService service = new ArticleServiceImpl();) {
			Article article = service.detail(num);
			request.setAttribute("article", article);
			request.getRequestDispatcher("modifyform.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = getServletContext().getRealPath("upload");
		request.setCharacterEncoding("UTF-8");
		int size = 1024 * 1024 * 10; // 10MB
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		Integer num = Integer.parseInt(multi.getParameter("num"));
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");

		String filename = multi.getFilesystemName("filename");
		if (filename == null) {
			filename = multi.getParameter("originFilename");
		}
		String imgfilename = multi.getFilesystemName("imgfilename");
		if (imgfilename == null) {
			imgfilename = multi.getParameter("originImgfilename");
		}

		Article article = new Article(num, title, content, writer, filename, imgfilename);
		ArticleService service = new ArticleServiceImpl();
		try {
			service.modify(article);
			response.sendRedirect("BoardDetail?num=" + num);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}