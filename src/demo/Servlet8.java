package demo;

import Dao.UserDao.UserMangeDao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "Servlet8")
public class Servlet8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("欢迎进入");
        String ids = request.getParameter("ids");
        UserMangeDao dao = new UserMangeDao();
        boolean success = dao.delete(ids);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (success) {
            map.put("code", 0);
            map.put("info", "删除成功");
        } else {
            map.put("code", 1);
            map.put("info", "删除失败");
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
