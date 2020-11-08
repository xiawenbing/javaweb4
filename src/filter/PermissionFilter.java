package filter;

import Vo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.net.http.HttpResponse;


@WebFilter("/PermissionFilter")
public class PermissionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        int flag=0;
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("username"))
            {
                flag=1;
            }
        }
        if (flag==1)
        {
            chain.doFilter(req,resp);
        }
        else {
            request.setAttribute("errorInf","请重新输入账号和密码");
            request.getRequestDispatcher("/jsp/other/error.jsp").forward(req,resp);
    }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
