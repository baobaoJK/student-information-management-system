package org.sd.dao;

import org.sd.entity.Grade;
import org.sd.entity.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author KSaMar
 * @version 1.0
 * 接口实现类
 */
public class DaoFromDB implements Dao {

    /**
     * 数据库驱动名称
     */
    private final String driverName = "com.mysql.jdbc.Driver";
    /**
     * 数据库连接地址
     */
    private final String dbUrl = "jdbc:mysql://localhost:3306/student";
    /**
     * 数据库用户名称
     */
    private final String dbUsername = "root";
    /**
     * 数据库用户密码
     */
    private final String dbPassword = "123456";
    /**
     * 数据库连接
     */
    private Connection connection;
    /**
     * 数据库操作
     */
    private Statement statement;
    /**
     * 数据库预处理操作语句
     */
    private PreparedStatement preparedStatement;
    /**
     * 数据库返回集
     */
    private ResultSet resultSet;
    /**
     * 页面大小
     */
    private int size = 5;

    /**
     * 数据库连接
     */
    public DaoFromDB() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 此方法完成学生信息的插入
     * 控制层调用此方法需要传递 id、name、age、tel、address、gid 几个参数到此方法中。插入成功返回 true 给控制层，否则返回 false 给控制层
     *
     * @param id      ID
     * @param name    学生名称
     * @param age     学生年龄
     * @param tel     学生手机号码
     * @param address 学生地址
     * @param gid     学生班级
     * @return 插入信息状态
     */
    @Override
    public boolean insert(String id, String name, String age, String tel, String address, int gid) {
        try {
            String sql = "insert into student values(?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, tel);
            preparedStatement.setString(5, address);
            preparedStatement.setInt(6, gid);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 此方法用于学生信息删除
     * 控制层调用此方法需要传递 id 参数到此方法中。删除成功返回 true 给控制层，否则返回 false 给控制层
     *
     * @param id ID
     * @return 删除信息状态
     */
    @Override
    public boolean delete(String id) {
        try {
            String sql = "delete from student where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 此方法用于学生信息的更新
     * 控制层调用此方法需要床底 id、name、age、tel、address、gid 几个参数到此方法中，更新成功返回 true 给控制层，否则返回 false 给控制层
     *
     * @param id      ID
     * @param name    学生名称
     * @param age     学生年龄
     * @param tel     学生手机号码
     * @param address 学生地址
     * @return 更新信息状态
     */
    @Override
    public boolean update(String id, String name, String age, String tel, String address) {
        try {
            String sql = "update student set name=?,age=?,tel=?,address=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, tel);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 此方法用于管理员登录
     * 控制层调用此方法需要传递管理员的 name 和 pwd 两个参数到此方法中。此方法判断其用户名密码是否和数据库中的记录一直，如果一直则返回 true 给控制层，否则返回 false 给控制层
     *
     * @param name     用户名
     * @param password 密码
     * @return 登录状态
     */
    @Override
    public boolean login(String name, String password) {
        try {
            String sql = "select * from user where name=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();

                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 此方法用于计算总页数
     *
     * @return 页数
     */
    @Override
    public int countPage() {
        int countPage = 0;

        try {
            String sql = "select count(*) total from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                countPage = total % size == 0 ? total / size : total / size + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();

                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return countPage;
    }

    /**
     * 此方法完成学生信息查询
     * 通过控制层传递过来的查询页码查出该页的所有记录，并遍历此结果集，把查询的信息存于 students 这个集合中，返回给控制层
     *
     * @param currentPage 页码
     * @return 学生信息
     */
    @Override
    public ArrayList<Student> display(int currentPage) {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            String sql = "select s.id,s.name,s.age,s.tel,s.address,g.gid,g.gname " +
                    "from student s,grade g where s.gid=g.gid " +
                    "order by id asc" + " " +
                    "limit " + (currentPage - 1) * size + "," + size;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();
                Grade grade = new Grade();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getString("age"));
                student.setTel(resultSet.getString("tel"));
                student.setAddress(resultSet.getString("address"));
                grade.setGid(resultSet.getInt("gid"));
                grade.setGname(resultSet.getString("gname"));
                student.setGrade(grade);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    /**
     * 此方法用于学生信息的模糊查询
     * 遍历此查询结果集，把查询的信息存于 Students 这个集合中，返回给控制层。控制层调用此方法需要传递 name 参数到此方法中
     *
     * @param name 学生名称
     * @return 学生信息
     */
    @Override
    public ArrayList<Student> search(String name) {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            String sql = "select * from student where name like ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getString("age"));
                student.setTel(resultSet.getString("tel"));
                student.setAddress(resultSet.getString("address"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }

    /**
     * 此方法实现查询所有的班级信息，并遍历此结果集，把查询的信息存于 grades 这个集合中，返回给控制层
     *
     * @return 班级信息
     */
    @Override
    public ArrayList<Grade> disGrade() {
        ArrayList<Grade> grades = new ArrayList<Grade>();

        try {
            String sql = "select * from grade";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setGid(resultSet.getInt("gid"));
                grade.setGname(resultSet.getString("gname"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return grades;
    }
}
