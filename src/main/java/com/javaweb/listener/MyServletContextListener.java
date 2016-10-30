package com.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Jesse on 29/9/16.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servlet context initialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet context destroyed");
    }
}
