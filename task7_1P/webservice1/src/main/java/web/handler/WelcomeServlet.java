package web.handler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws IOException, ServletException {	
		System.out.println("[RegistrationServlet] GET");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws IOException, ServletException {		
		System.out.println("[WelcomeServlet] POST");
		// post a message
		resp.getWriter().println("Welcome, server is running!");
	}
}