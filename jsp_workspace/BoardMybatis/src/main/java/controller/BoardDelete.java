package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.ArticleService;
import service.ArticleServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/boardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer num = Integer.parseInt(request.getParameter("num"));

		try (ArticleService articleService = new ArticleServiceImpl();
				MemberService memberService = new MemberServiceImpl();) {
			Member member = (Member) request.getSession().getAttribute("user");
			if (member == null) {
				response.getWriter().write("로그인 후 삭제하세요");
				return;
			} else if (articleService.detail(num).getWriter().equals(member.getId()) == false) {
				response.getWriter().write("본인 글만 삭제 가능합니다");
				return;

			}

			response.getWriter().write(String.valueOf(articleService.delete(num)));
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("삭제 실패");
		}
	}

}
