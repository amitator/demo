package com.prus.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FirstCookie extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        Cookie address = new Cookie("address", request.getRemoteAddr() + new Date().toString());
        Cookie lang = new Cookie("lang", request.getLocale().toString());
        response.addCookie(address);
        response.addCookie(lang);
        Cookie[] cookies = request.getCookies();
        if (request.getParameter("clear") != null){
            address.setMaxAge(0);
            lang.setMaxAge(0);
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cookie</title>");
            out.println("</head>");
            out.println("<body>");
            if (cookies != null){
                for (Cookie c : cookies){
                    out.println(c.getName() + " = " + c.getValue() + "<br/>");
                }
            } else {
                out.println("No cookies");
            }
            out.println("<h1>Servlet Cookie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
