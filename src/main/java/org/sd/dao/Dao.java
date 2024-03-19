package org.sd.dao;

import org.sd.entity.Grade;
import org.sd.entity.Student;

import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * DAO 接口
 */
public interface Dao {
    /**
     * 学生信息插入
     *
     * @param id      ID
     * @param name    学生名称
     * @param age     学生年龄
     * @param tel     学生手机号码
     * @param address 学生地址
     * @param gid     学生班级
     * @return 插入状态
     */
    boolean insert(String id, String name, String age, String tel, String address, int gid);

    /**
     * 学生信息删除
     *
     * @param id ID
     * @return 删除状态
     */
    boolean delete(String id);

    /**
     * 学生信息更新
     *
     * @param id      ID
     * @param name    学生名称
     * @param age     学生年龄
     * @param tel     学生手机号码
     * @param address 学生地址
     * @return 更新状态
     */
    boolean update(String id, String name, String age, String tel, String address);

    /**
     * 用户登录
     *
     * @param name     用户名称
     * @param password 用户密码
     * @return
     */
    boolean login(String name, String password);

    /**
     * 信息页数
     * @return 页数
     */
    int countPage();

    /**
     * 学生信息查询
     * @param currentPage 页码
     * @return 学生信息
     */
    ArrayList<Student> display(int currentPage);

    /**
     * 学生信息模糊查询
     * @param name 学生名称
     * @return
     */
    ArrayList<Student> search(String name);

    /**
     * 班级信息查询
     * @return 班级信息
     */
    ArrayList<Grade> disGrade();
}
