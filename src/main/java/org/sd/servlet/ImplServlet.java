package org.sd.servlet;

import org.sd.dao.DaoFromDB;
import org.sd.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 信息显示控制器
 */
public class ImplServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        req.getSession().setAttribute("currentPage", currentPage);
        DaoFromDB db = new DaoFromDB();
        int countPage = db.countPage();
        req.getSession().setAttribute("countPage", countPage);
        ArrayList<Student> students = db.display(currentPage);
        req.setAttribute("students", students);
        req.getRequestDispatcher("/admin/display.jsp").forward(req, resp);
    }
}
