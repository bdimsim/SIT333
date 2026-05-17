package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import web.service.LoginService;

// HTTP end-point to handle login service.
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {	
		System.out.println("[LoginServlet] GET");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {		
		System.out.println("[LoginServlet] POST");
		
		// Get parameters from HTTP request body by name (form data)
		String username = req.getParameter("username");
		String password = req.getParameter("passwd");
		String dob = req.getParameter("dob");
		
		System.out.println("Username/password/DoB: " + username + ", " 
			+ password + ", " + dob
		);

		String loginStatus = "fail";
		
		if (LoginService.login(username, password, dob)) loginStatus = "success";
		
		String htmlResponse = "<html>";
		htmlResponse += "<head><title>"+ loginStatus + "</title></head>";
		htmlResponse += "<h2>Login status: " + loginStatus + "</h2>";
		htmlResponse += "</html>";
		
		PrintWriter writer = resp.getWriter();
		writer.println(htmlResponse);
	}
}