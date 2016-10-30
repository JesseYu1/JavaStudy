package com.javaweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Jesse on 29/9/16.
 */
public class MyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet is initing...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println(this.getServletContext().getContext("/javaweb"));
//        System.out.println(request.getServletContext().getRealPath("/"));

        ServletConfig servletConfig = this.getServletConfig();
        PrintWriter out = response.getWriter();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String header = enumeration.nextElement();
            out.println(header);
            out.println(":");
            out.println(request.getHeader(header));
            out.println("<br>");
        }

        out.println("<hr>");

        for (Cookie cookie : request.getCookies()) {
            out.println(cookie.getName());
            out.println(":");
            out.println(cookie.getValue());
            out.println("<br>");
        }

        String cookie = "hhh=hhh;path=/;HttpOnly;";
        response.addHeader("Set-Cookie", cookie);

        Cookie cookie1 = new Cookie("hhh1", "hhh1");
        cookie1.setHttpOnly(true);
        cookie1.setPath("/");
        response.addCookie(cookie1);

        response.setContentType("text/html;charset=UTF-8");
        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyServlet at " + request.getRequestURI() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "MyServlet";
    }

    @Override
    public void destroy() {
        System.out.println("MyServlet destroy");
    }
}
