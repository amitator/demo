package com.prus.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String user = ctx.getInitParameter("USER");
        String pswd = ctx.getInitParameter("PASS");
        String url = ctx.getInitParameter("URL");
        System.out.println("Creating DB connection");
        ctx.setAttribute("Connection", "DB connection created with following params:" +
                "<br/>User: " + user +
                "<br/>Password: " + pswd +
                "<br/>DB URL: " + url);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.removeAttribute("Connection");
        System.out.println("DB connection closed");
    }
}
