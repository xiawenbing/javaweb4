package demo;

import Dao.UserDao.UserDaofinsh;
import Vo.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet( "/Servlet5")
public class Servlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证注册账号和密码
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        System.out.println(userName);
        UserDaofinsh dao=new UserDaofinsh();
        boolean result=false;
        try {
            result = dao.find(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>();

        if(result)
        {
            map.put("code", 0);
        }
        else {
            map.put("code", 1);
        }
        String jsonStr = new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
