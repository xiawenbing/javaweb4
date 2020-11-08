package Dao.UserDao;

import Tools.Connectiontool;
import Vo.Page;
import Vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class UserMangeDao {
    Connectiontool tool;

    {
        try {
            tool = new Connectiontool();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    Connection con = tool.getConnection();
    PreparedStatement ps;

    public ArrayList<User> query(User user,Page page) {
        System.out.println("query.do");
        ArrayList<User> list = new ArrayList<User>(); // 存放查询结果的集合
        User use = new User();
        String sql = "select * from user";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                use.setUserName(rs.getString("userName"));
                use.setPassword(rs.getString("password"));
                use.setRole(rs.getString("role"));
                use.setChrName(rs.getString("chrName"));
                list.add(use);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int count(User user, Page page) {
        System.out.println("count");
        int counts = 0;
        String sql = "select * from user";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                counts++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counts;
    }

    //批量删除
    public boolean delete(String ids) {
        boolean bon = false;
        String[] array = ids.split(",");
        try {
            String sql = "delete from user where userName in(";
            StringBuffer s = new StringBuffer("?");
            for (int i = 0; i < array.length - 1; i++) {
                s.append(",?");
            }
            sql = sql + s.toString() + ")";
            System.out.println(sql);
            PreparedStatement pst = con.prepareStatement(sql);
            for (int i = 0; i < array.length; i++) {
                pst.setString(i + 1, array[i]);
            }
            int i = pst.executeUpdate();
            if (i > 0) {
                bon = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bon;
    }


    //查改数据
    public boolean update(User user) {
        boolean bon = false;
        String sql = "update user set chrName=?,password=?,role=? where userName=? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getChrName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getUserName());
            int i = ps.executeUpdate();
            if (i > 0) {
                bon = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bon;
    }

    //新增数据
    public boolean insert(User user){
        boolean bon=false;
        String sql = "insert into user(userName,chrName,password,role) value (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getChrName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            int i = ps.executeUpdate();
            if (i > 0) {
                bon = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bon;
    }
}