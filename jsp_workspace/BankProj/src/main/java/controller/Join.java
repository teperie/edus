package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.MemberServiceImpl;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Join() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Boolean isDuplicate = request.getParameter("action").equals("duplicate");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		MemberServiceImpl service = new MemberServiceImpl();
		RequestDispatcher rd = null;
		try {
			if (isDuplicate) {
				Member mem = service.searchById(id);
				if (mem != null) {
					request.setAttribute("isDuplicated", true);
					request.setAttribute("id", id);
					request.setAttribute("name", name);
					request.setAttribute("email", email);
					request.setAttribute("address", address);
					request.getRequestDispatcher("join.jsp").forward(request, response);
					return;
				} else {
					request.setAttribute("isDuplicated", false);
					request.getRequestDispatcher("join.jsp").forward(request, response);
					return;
				}
			}
			Member member = new Member(id, name, password, email, address);
			service.makeMember(member);
			request.setAttribute("member", member);
			rd = request.getRequestDispatcher("login.jsp");
		} catch (Exception e) {
			System.err.println(e);
			request.setAttribute("err", e);
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}

}
