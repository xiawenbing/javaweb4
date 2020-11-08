package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/managerFilter")
public class managerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        int flag=0;
        String name="manager";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
           if (cookie.getValue().equals(name)) {
            flag=1;
           }
        }
        if (flag==1) {
            chain.doFilter(req, resp);
        }
        else {
            request.setAttribute("errorInf","没有权限查看");
            request.getRequestDispatcher("/jsp/other/error.jsp").forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
