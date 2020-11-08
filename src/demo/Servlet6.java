package demo;

import Tools.Connectiontool;
import Vo.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet6")
public class Servlet6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //重注册界面跳转到主页面
        request.setCharacterEncoding("utf-8");
        Connectiontool tool= null;
        try {
            tool = new Connectiontool();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        Connection con= tool.getConnection();
        PreparedStatement pst;
        String username=request.getParameter("userName");
        String chrName = request.getParameter("chrName");
        String password = request.getParameter("password");
        String role="user";
        String sql = "insert into user(chrName,userName,password,role) value('?', '? ','?','?');";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.setString(1, chrName);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        String jsonStr=new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        System.out.println(jsonStr);
        out.close();
        out.flush();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
