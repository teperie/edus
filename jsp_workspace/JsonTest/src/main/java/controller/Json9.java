package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Json9
 */
@WebServlet("/json9")
public class Json9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Json9() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// {"team":"코스타","area":"서울 금천구
		// 독산동","pers":[{"name":"홍길동","age":30},{"name":"김길동","age":20},{"name":"송길동","age":40}]}
		request.setCharacterEncoding("utf-8");

		Map<String, Object> map = new HashMap<>();
		map.put("team", "코스타");
		map.put("area", "서울 금천구 독산동");
		
		List<Map<String, Object>> pers = new ArrayList<>();
		Map<String, Object> p1 = new HashMap<>();
		p1.put("name", "홍길동");
		p1.put("age", 30);
		pers.add(p1);
		
		p1 = new HashMap<>();
		p1.put("name", "김길동");
		p1.put("age", 20);
		pers.add(p1);
		
		p1 = new HashMap<>();
		p1.put("name", "송길동");
		p1.put("age", 40);
		pers.add(p1);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
		
		//		JSONObject json = new JSONObject();
//		json.put("team", "코스타");
//		json.put("area", "서울 금천구 독산동");
//
//		JSONArray pers = new JSONArray();
//		JSONObject p1 = new JSONObject();
//		p1.put("name", "홍길동");
//		p1.put("age", 30);
//		pers.add(p1);
//		JSONObject p2 = new JSONObject();
//		p2.put("name", "김길동");
//		p2.put("age", 20);
//		pers.add(p2);
//		JSONObject p3 = new JSONObject();
//		p3.put("name", "송길동");
//		p3.put("age", 40);
//		pers.add(p3);
//		json.put("pers", pers);
//		System.out.println(json.toJSONString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
