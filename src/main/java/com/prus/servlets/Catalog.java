package com.prus.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Catalog", urlPatterns = {"/catalog"})
public class Catalog extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //ServletContext to transfer data to any servlet in app
        ServletContext ctx = request.getServletContext();
        //Session
        HttpSession session = request.getSession();
        if (session.isNew()){
            session.setAttribute("auth", "empty");
        }
        if (request.getParameter("auth") != null){
            session.setAttribute("auth", request.getParameter("auth"));
        }
        if (request.getParameter("out") != null){
            session.setAttribute("auth", "empty");
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<! DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Catalog</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Catalog</h1>");
            out.println("<h3>" + ctx.getAttribute("Connection") + "</h3>");
            out.println("<a href='cart'>Cart</a>");
            if (session.getAttribute("auth") == "empty"){
                out.println("<div><a href='catalog?auth=Usver'>Login</a></div>");
            } else {
                out.println("<div>You logged in as " + session.getAttribute("auth") + "</div>");
                out.println("<div><a href='catalog?out=yes'>Exit</a></div>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
