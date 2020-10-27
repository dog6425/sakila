package sakila.controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;


@WebServlet({"/","/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	// 로그인폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff")!=null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		Stats stats = statsService.getStats();
		request.setAttribute("stats", stats);
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}
	//로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: LoginServlet doPost 실행");
		
		String email = request.getParameter("email");
		System.out.println("Debug: getParameter staffEmail("+email+")");
		String password = request.getParameter("password");
		System.out.println("Debug: getParameter staffPassword("+passowrd+")");
		
		staffService = new StaffService();
		Staff staff = new Staff();
		staff.setEmail(email);
		staff.setPassword(password);
		
		System.out.println("Debug: 로그인 Staff 객체 생성");
		System.out.println("Debug: staffEmail("+staff.getEmail+")");
		System.out.println("Debug: staffPassword("+staff.getPassword()+")");
		
		Staff returnStaff = staffService.getStaffByKey(staff);
		
		if(returnStaff !=null) {
			System.out.println("Debug: 로그인 성공");
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff);
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		System.out.println("Debug: 로그인 실패");
		response.sendRedirect(request.getContextPath()+"/LoginServlet");
	}
		}
}
