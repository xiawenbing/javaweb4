package demo;

import Dao.Provincial.provincialDao;
import Vo.ProvinceCity;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String provinceCode = request.getParameter("provinceCode");
        System.out.println(provinceCode);
        String jsonStr="";
        Map<String,Object> map=new HashMap<String,Object>();
        provincialDao dao=new provincialDao();
        if (provinceCode==null)
        {
            ArrayList<ProvinceCity> list= null;
            try {
                list = (ArrayList<ProvinceCity>) dao.queryProvince();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            jsonStr=new Gson().toJson(list);
         }
        else {
            ArrayList<ProvinceCity> list= null;
            try {
                list = (ArrayList<ProvinceCity>) dao.queryCity(provinceCode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            jsonStr=new Gson().toJson(list);

        }
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
