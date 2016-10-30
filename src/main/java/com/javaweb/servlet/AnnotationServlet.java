package com.javaweb.servlet;

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
@WebServlet(name = "AnnotationServlet", urlPatterns = {"/AnnotationServlet"})
public class AnnotationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("AnnotationServlet is initing...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AnnotationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet AnnotationServlet at " + request.getRequestURI() + "</h2>");
            out.println("<h2>Hello from " + request.getAttribute("hello") + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "AnnotationServlet";
    }

    @Override
    public void destroy() {
        System.out.println("AnnotationServlet destroy");
    }
}
