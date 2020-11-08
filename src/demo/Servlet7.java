package demo;

import Dao.UserDao.UserMangeDao;
import Vo.Page;
import Vo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分页显示
        request.setCharacterEncoding("utf-8");
        System.out.println("进入分页管理");
        String queryParams=request.getParameter("queryParams");
        String pageParams = request.getParameter("pageParams");
        System.out.println("查询参数"+pageParams);
        System.out.println("分页参数"+queryParams);

        Gson gson=new GsonBuilder().serializeNulls().create();
        HashMap<String,Object> mapPage=gson.fromJson(pageParams,HashMap.class);
        Page page= Page.getPageParams(mapPage);
        User user=new User();
        if (queryParams!=null)
        {
            user = gson.fromJson(queryParams, User.class);
        }

        UserMangeDao dao=new UserMangeDao();
        ArrayList<User> rows=dao.query(user,page);
        System.out.println(rows);
        int total=dao.count(user,page);
        System.out.println(total);
        HashMap<String, Object> mapReturn = new HashMap<String, Object>();
        mapReturn.put("total",total);
        mapReturn.put("rows",rows);
        String jsonStr = gson.toJson(mapReturn);
        System.out.println(jsonStr);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.flush();
        out.close();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
