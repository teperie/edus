package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.Article;
import dto.Member;
import service.ArticleService;
import service.ArticleServiceImpl;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWrite() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("writeform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String path = request.getServletContext().getRealPath("upload");
		String path = "C:\\lcj\\downloads";
		File dir = new File(path);

		if (dir.exists() == false) {
			dir.mkdirs();
		}

		int size = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

		Member writer = (Member) request.getSession().getAttribute("user");

		String title = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("dfile");
		String imgfilename = multi.getFilesystemName("ifile");

		Article article = new Article(title, content, writer.getId(), filename, imgfilename);

		try (ArticleService service = new ArticleServiceImpl();) {
			service.write(article);
			System.out.println(article);
			request.setAttribute("article", article);
			request.getRequestDispatcher("boarddetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 작성시 오류가 발생했습니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
