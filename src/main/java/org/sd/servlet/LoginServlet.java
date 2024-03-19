package org.sd.servlet;

import org.sd.dao.DaoFromDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author KSaMar
 * @version 1.0
 * 用户登录控制器
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        DaoFromDB dao = new DaoFromDB();

        boolean result = dao.login(name, password);

        if (result) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            req.getRequestDispatcher("/admin/main.jsp").forward(req, resp);
        }
        else {
            PrintWriter out = resp.getWriter();
            out.print("<script>alert('账号或密码错误');window.location.replace('login.jsp')</script>");
            out.flush();
            out.close();
        }
    }
}
