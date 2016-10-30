package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Jesse on 29/9/16.
 */
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter doFilter");
//        System.out.println(chain);
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("MyFilter destroy");
    }
}
