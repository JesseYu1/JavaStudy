package com.javaweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jesse on 29/9/16.
 */
@WebServlet(name = "IncludeServlet", urlPatterns = {"/IncludeServlet"})
public class IncludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<h2>Servlet IncludeServlet at " + request.getRequestURI() + "</h2>");
        } finally {
            out.close();
        }
    }
}
