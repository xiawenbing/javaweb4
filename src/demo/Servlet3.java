package demo;

import Dao.UserDao.UserDaofinsh;
import Vo.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //验证二维码
        System.out.println("64945489786546549844684646846");
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        String code= (String) request.getSession().getAttribute("verityCode");
        String vcode=request.getParameter("vcode");
        String autoLogin=request.getParameter("autoLogin");
        //创建HashMap
        Map<String,Object> map=new HashMap<String,Object>();

        UserDaofinsh userDao=new UserDaofinsh();
        User u=null;
        //调用User实例化对象 ，调用DAO中findALL函数查找用户账户和密码
        try {
            u=userDao.findAll(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //验证用户名和密码
        if (vcode.equals(code))
        {
            if (u.getUserName()==null)
            {
                map.put("code",2);
                map.put("info","用户名不存在");
                System.out.println("2");
            }
            else {
                if (password.equals(u.getPassword()))
                {
                    request.setAttribute("user","u");

                    //配置一周免密登录
                    if (autoLogin!=null)
                    {
                        System.out.println("xiaixiaixiaiisdad");
                        Cookie cookieName=new Cookie("username",username);
                        response.addCookie(cookieName);
                        Cookie cookiePwd=new Cookie("Password",password);
                        response.addCookie(cookiePwd);
                        cookieName.setMaxAge(60*60*24*7);
                        cookiePwd.setMaxAge(60*60*24*7);
                    }
                    Cookie cookieRole=new Cookie("Role",u.getRole());
                    response.addCookie(cookieRole);
                    cookieRole.setMaxAge(60*60*24*7);
                    map.put("code",0);
                    map.put("info","欢迎进入");
                    System.out.println("0");
                }
                else
                {
                    map.put("code",3);
                    map.put("info","密码不正确");
                    System.out.println("3");

                }
            }
        }
        else {
            map.put("code",1);
            map.put("info","验证码错误");
            System.out.println("1");
        }

        String jsonStr=new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        System.out.println(jsonStr);
        out.print(jsonStr);
        out.close();
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
