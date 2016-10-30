package com.javaweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jesse on 29/9/16.
 */
@WebServlet(name = "ForwardServlet", urlPatterns = {"/ForwardServlet"})
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AnnotationServlet");
        request.setAttribute("hello", "ForwardServlet");
        rd.forward(request, response);
    }
}
