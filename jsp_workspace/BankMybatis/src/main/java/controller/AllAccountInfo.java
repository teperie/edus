package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allAccountInfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllAccountInfo() {
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
		if (spage != null) {
			page = Integer.parseInt(spage);
		}

		RequestDispatcher dispatcher = null;
		AccountService service = new AccountServiceImpl();

		try {
			Map<String, Object> resultMap = service.allAccountInfo(page);

			request.setAttribute("accList", resultMap.get("accList"));
			request.setAttribute("curPage", resultMap.get("curPage"));
			request.setAttribute("totalPage", resultMap.get("totalPage"));

			dispatcher = request.getRequestDispatcher("allaccountinfo.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}
}
