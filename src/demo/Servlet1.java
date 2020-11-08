package demo;

import Dao.CreateVerificationCodeImage;
import Dao.UserDao.UserDaofinsh;
import Vo.User;



import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateVerificationCodeImage createVCodeImage=new CreateVerificationCodeImage();
        //产生四位随机字符
        String vcode=createVCodeImage.createCode();
        //获取httpSession对象
        HttpSession session =request.getSession();
        session.setAttribute("verityCode",vcode);
        //设置返回内容
        response.setContentType("img/jpeg");
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        //设置失效时间
        response.setDateHeader("Expires",0);
        //以字节流发过去，交给img的scr属性中解析
        BufferedImage image=createVCodeImage.CreateImage(vcode);
        ServletOutputStream out=response.getOutputStream();
        ImageIO.write(image,"JPEG",out);
        out.flush();
        out.close();

    }
}
