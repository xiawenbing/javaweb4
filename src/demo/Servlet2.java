package demo;

import Dao.DownloadDao.IDownloadDaofinsh;
import Dao.UserDao.UserDaofinsh;
import Vo.User;
import Vo.download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //将传回来的数据库文件数组传到实例化对象ido中
        IDownloadDaofinsh ido=new IDownloadDaofinsh();
        List<download> downloadList = ido.findbady();
        HttpSession session=request.getSession();
        session.setAttribute("downlist",downloadList);
        request.getRequestDispatcher("jsp/download.jsp").forward(request,response);

        String id=request.getParameter("id");

        download dd=new download();
        try {
            dd=ido.findAll(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path=request.getServletContext().getRealPath(dd.getId());
         String fileName=path.substring(path.lastIndexOf("\\"+1));
         response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        InputStream in=new FileInputStream(path);
        int len=0;

        byte[] buttf=new byte[1024];
        ServletOutputStream out=response.getOutputStream();

        while((len=in.read(buttf))!=-1)
        {
          out.write(buttf,0,len);
        }
        in.close();
        out.close();

    }
}
