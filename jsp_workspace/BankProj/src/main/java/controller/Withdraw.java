package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountServiceImpl;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("withdraw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		RequestDispatcher rd = null;
		AccountServiceImpl service = new AccountServiceImpl();
		
		try {
			Account acc = service.withdraw(id, money);
			request.setAttribute("acc", acc);
			rd = request.getRequestDispatcher("accountinfo.jsp");
		} catch (Exception e) {
			System.err.println(e);
			request.setAttribute("err", e);
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
	}

}
