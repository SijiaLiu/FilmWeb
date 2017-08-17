package com.hand.Servlet;

import com.hand.Entity.Customer;
import com.hand.Service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class LoginServlet extends HttpServlet{

    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext ctx=
//                new ClassPathXmlApplicationContext("beans.xml");
        //获取上下文
        ServletContext sc = req.getSession().getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);

        LoginService ls = wac.getBean("loginService", LoginService.class);

        String name = req.getParameter("uname");  //获取页面输入的用户名
        RequestDispatcher rd = null;
        String forward = null;
        if (name == null){
            req.setAttribute("msg", "用户名或密码为空！");
            rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }else {
            Customer customer = new Customer();
            customer.setFirst_name(name);
            boolean bool = ls.checkUser(customer);


            if (bool){
                //用户登录成功 设置session value值为"login_success"
                req.getSession().setAttribute("flag", "login_success");
                forward = ("/success.jsp");
            } else {
                req.getSession().setAttribute("flag", "login_error");
                req.setAttribute("msg", "用户名或密码错误！");
                forward = ("/fail.jsp");
            }
            rd = req.getRequestDispatcher(forward);
            rd.forward(req, resp);
        }
    }
}
