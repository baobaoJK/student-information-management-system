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
 * 更新学生信息
 */
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");

        DaoFromDB db = new DaoFromDB();

        boolean result = db.update(id, name, age, tel, address);

        if(result) {
            ArrayList<Student> students = db.display(1);
            req.setAttribute("students", students);
            req.getRequestDispatcher("/admin/display.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/admin/error.jsp").forward(req, resp);
        }
    }
}
