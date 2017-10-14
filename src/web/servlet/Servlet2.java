package web.servlet;

import doMain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
        User user = new User();
            try{
                BeanUtils.populate(user ,request.getParameterMap());
            }catch (Exception e ){
                e.printStackTrace();
            }

        UserService us = new UserServiceImpl();
            User u = new User();
            try {
               u =  us.login(user);
               if(u!=null){
                   request.getSession().setAttribute("u", user);//如果登录成功，就把user对象放到session对象 中
                   request.getRequestDispatcher("/H-ui.admin/index.html").forward(request, response);
               }else {
                   request.getRequestDispatcher("/login.jsp").forward(request, response);
               }
            }catch (Exception e ){
                e.printStackTrace();
            }



    }
}
