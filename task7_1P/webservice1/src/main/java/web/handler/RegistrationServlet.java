package web.handler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import web.service.RegistrationService;


// HTTP end-point to handle registration request.
public class RegistrationServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {	
		System.out.println("[RegistrationServlet] GET");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {		
		System.out.println("[RegistrationServlet] POST");
		String fName = req.getParameter("fname");
		String lName = req.getParameter("lname");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		
		// Call registration business logic
		RegistrationService.register(fName, lName, email, dob);
		
		// Writes a status ok message: just to test servlet functionality.
		resp.setContentType("application/json");
		resp.setStatus(HttpServletResponse.SC_OK);				
		resp.getWriter().println("{\"status\": \"ok\"}");
	}
}