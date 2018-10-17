package com.prus.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "HelloFilter", urlPatterns={"/hello"})
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter HelloFilter started.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter is working now!");
        servletRequest.setAttribute("hi", "Hi from FILTER");
        System.out.println("Filter forwards variable hi which contains - " + servletRequest.getAttribute("hi"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter HelloFilter Destroyed.");
    }
}
