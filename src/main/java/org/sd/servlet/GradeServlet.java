package org.sd.servlet;

import org.sd.dao.DaoFromDB;
import org.sd.entity.Grade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 获取班级信息
 */
public class GradeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        DaoFromDB db = new DaoFromDB();
        ArrayList<Grade> grades = db.disGrade();
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("/admin/insert.jsp").forward(req, resp);
    }
}
