package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet  {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		//read req means data from form
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		
		//asign data to object 
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
	     e.setPassword(password);
	      e.setEmail(email);
	      e.setCountry(country);
	      
	      
	      int ans=EmpDAO.update(e);
	      if(ans>0) {
	    	  resp.sendRedirect("ViewServlet");
	      }else {
	    	  out.print("something went wrong");
	      }
	      
	      
				
	}
	
	

}
