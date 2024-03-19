package org.sd.servlet;

import org.sd.dao.DaoFromDB;
import org.sd.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 搜索用户信息
 */
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");

        DaoFromDB db = new DaoFromDB();
        ArrayList<Student> students = db.search(name);

        if(students != null) {
         req.setAttribute("students", students);
         req.getRequestDispatcher("/admin/display.jsp").forward(req, resp);
        }
    }
}
