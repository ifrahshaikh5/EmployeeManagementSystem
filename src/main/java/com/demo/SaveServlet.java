package com.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        Employee e1 = new Employee();
        e1.setName(name);
        e1.setPassword(password);
        e1.setEmail(email);
        e1.setCountry(country);

        int status = EmpDAO.Save(e1);

        if (status > 0) {
            resp.sendRedirect("ViewServlet");
        } else {
            resp.getWriter().println("<h3>Sorry, unable to save record.</h3>");
        }
    }
}
