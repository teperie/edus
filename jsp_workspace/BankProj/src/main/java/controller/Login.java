package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
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
		// TODO Auto-generated method stub
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
		Boolean isAutoLogin = request.getParameter("autoLogin") != null
				&& request.getParameter("autoLogin").equals("true");

		MemberServiceImpl service = new MemberServiceImpl();
		try {
			Member member = service.matchIdPw(id, password); // 로그인 검증 및 회원 정보 반환
			request.setAttribute("isCorrect", true);
			// 로그인 성공 시 세션에 loginInfo 저장
			request.getSession().setAttribute("loginInfo", member);

			Cookie cookie1 = null;
			Cookie cookie2 = null;
			Cookie cookie3 = null;
			int cookieMaxAge = 60 * 60 * 24 * 7; // 7일

			if (isAutoLogin) {
				cookie1 = new Cookie("id", id);
				cookie2 = new Cookie("password", password); // 보안상 위험, 실서비스 금지
				cookie3 = new Cookie("autoLogin", isAutoLogin.toString());
				cookie1.setMaxAge(cookieMaxAge);
				cookie2.setMaxAge(cookieMaxAge);
				cookie3.setMaxAge(cookieMaxAge);
			} else {
				cookie1 = new Cookie("id", "");
				cookie2 = new Cookie("password", "");
				cookie3 = new Cookie("autoLogin", "");
				cookie1.setMaxAge(0);
				cookie2.setMaxAge(0);
				cookie3.setMaxAge(0);
			}
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.sendRedirect("header.jsp");

		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("id", id);
			request.setAttribute("isCorrect", false);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

	}

}