package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 필터
		System.out.print("/auth/IndexServlet 호출 성공");
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
	}

}
