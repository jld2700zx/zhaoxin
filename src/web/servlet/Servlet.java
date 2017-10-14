package web.servlet;

import doMain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        try{
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            BeanUtils.populate(user,request.getParameterMap());
            UserService us = new UserServiceImpl();
            us.register(user);
        }catch(Exception e ) {
            e.printStackTrace();
        }

        response.getWriter().write("注册成功！");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/index.jsp" );
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
