package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		Employee e= EmpDAO.getEMployeeByid(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		 out.print("<input type ='hidden' name='id'  value='"+e.getId()+"'><br><br><br> ");
	      
	       out.print("<label> Name </label>");
	       out.print("<input type ='text' name='name'  value='"+e.getName()+"'><br><br> ");
	       out.print("<label> Password </label>");
	       out.print("<input type ='text' name='password'  value='"+e.getPassword()+"'><br><br> ");
	       out.print("<label> Email </label>");
	       out.print("<input type ='text' name='email'  value='"+e.getEmail()+"'><br><br> ");
	       out.print("<label> Country </label>");
	       out.print("<input type ='text' name='country'  value='"+e.getCountry()+"'><br><br> ");
	     
	       out.print("<input type ='submit' value='Edit&Submit' >");
	       
	       
	       out.print("</form>");
		
	}
	
}

