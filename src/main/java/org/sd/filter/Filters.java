package org.sd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author KSaMar
 * @version 1.0
 * 过滤器
 */
public class Filters extends HttpServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String name = (String) session.getAttribute("name");

        if(name == null) {
            PrintWriter out = servletResponse.getWriter();
            out.print("您还没有登录");
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
