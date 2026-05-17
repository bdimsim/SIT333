package web.handler;

import web.model.User;

import java.io.PrintWriter;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

// HTTP end-point to handle registration request.
public class RegistrationServlet extends HttpServlet {
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
		String password = req.getParameter("passwd");
		String dob = req.getParameter("dob");

		System.out.println(
			"first_name/last_name/email/password/DoB: " 
			+ fName + ", " 
			+ lName + ", "
			+ email + ", "
			+ password + ", " 
			+ dob
		);

		String regStatus = "fail";

		User user = RegistrationService.register(fName, lName, email, password, dob);
		if (user != null) regStatus = "success";

		resp.setContentType("text/html");

		String htmlResponse = "<html>";
		htmlResponse += "<head><title>" + regStatus + "</title></head>";
		htmlResponse += "<h2>Registration status: " + regStatus + "</h2>";
		htmlResponse += "</html>";

		PrintWriter writer = resp.getWriter();
		writer.println(htmlResponse);
		writer.flush();
	}
}