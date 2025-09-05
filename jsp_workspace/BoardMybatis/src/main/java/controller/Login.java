package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String autologin = request.getParameter("autologin");
		try (MemberService service = new MemberServiceImpl()) {
			Member member = service.login(id, password);
			member.setPassword("");
			HttpSession session = request.getSession();
			session.setAttribute("user", member);

			// 쿠키 설정
			Cookie cookie1 = null;
			Cookie cookie2 = null;
			Cookie cookie3 = null;
			if (autologin == null || autologin.equals("")) {
				cookie1 = new Cookie("autoLogin", null);
				cookie2 = new Cookie("id", null);
				cookie3 = new Cookie("password", null);
			} else {
				cookie1 = new Cookie("autoLogin", autologin);
				cookie2 = new Cookie("id", id);
				cookie3 = new Cookie("password", password);
			}

			cookie1.setMaxAge(24 * 60 * 60); // 하루(24시간)
			cookie2.setMaxAge(24 * 60 * 60);
			cookie3.setMaxAge(24 * 60 * 60);

			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.sendRedirect("boardList");
		} catch (Exception e) {
			request.setAttribute("err", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
