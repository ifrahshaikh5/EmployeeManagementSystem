package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		//read request means dat from form
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmpDAO.delte(id);
		
		resp.sendRedirect("ViewServlet");
	}
	
	

}
