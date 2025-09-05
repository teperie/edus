package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDown
 */
@WebServlet("/fileDown")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
//		String path = request.getServletContext().getRealPath("upload");
		String path = "C:\\lcj\\downloads";
		
		try {
			String mimeType=request.getServletContext().getMimeType(path+"\\"+filename);
			if(mimeType==null) {
				mimeType="application/octet-stream"; //octet-stream: 8비트로 된 일련의 데이터를 뜻함. 지정되지 않은 타입을 의미
			}
			response.setContentType(mimeType);
			String encodingFileName = new String(filename.getBytes("utf-8"), "8859_1"); //파일명 한글깨짐 방지
			response.setHeader("content-Disposition", "attatchment; filename= "+encodingFileName);
			
			FileInputStream fis = new FileInputStream(new File(path, filename));
			OutputStream out = response.getOutputStream();
			
			byte[] buff = new byte[4096];
			int len;
			while((len=fis.read(buff))>0) {
				out.write(buff,0,len);
			}
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write("파일 다운로드 실패");
		}
	}
}
