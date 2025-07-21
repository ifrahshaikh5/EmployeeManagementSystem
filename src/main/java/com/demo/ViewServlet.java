package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		out.print("<a href='index.html'> Add New Employee </a>");
		
		out.print("<h1>Employee Details !!! </h1>");
		
		
		List<Employee> list=EmpDAO.getAllEMployee()	;	
		
		out.print("<table border='2' cellspacing='0' cellpadding='5'");
		
		 out.print("<tr>");
         out.print("<th>Id</th>");
         out.print("<th>Name</th>");
         out.print("<th>Password</th>");
         out.print("<th>EMail</th>");
         out.print("<th>Country</th>");
         out.print("<th>Update</th>");
         out.print("<th>Delete</th>");
    out.print("</tr>");
    
    
    
    for(Employee e : list)
    {
   	  out.print("<tr>");
             out.print("<td>"+ e.getId() +"</td>");
             out.print("<td>"+e.getName()+"</td>");
             out.print("<td>"+e.getPassword()+"</td>");
             out.print("<td>"+e.getEmail()+"</td>");
             out.print("<td>"+e.getCountry()+"</td>");
          out.print("<td><a href='editServlet?id="+e.getId()+"'>Edit</a></td>");
       out.print("<td><a href='deleteServlet?id="+e.getId()+"'>Delete</a></td>");
        
              out.print("</tr>");
   	 
    }


out.print("</table>");

}
}
