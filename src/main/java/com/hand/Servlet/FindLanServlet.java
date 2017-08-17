package com.hand.Servlet;

import com.hand.Entity.Film;
import com.hand.Service.FindLanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class FindLanServlet extends HttpServlet {

    public FindLanServlet() {
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

        FindLanService fl = wac.getBean("findLanService", FindLanService.class);
        List<Film> list = fl.findLan();

        req.setAttribute("lanList", list);
        req.getRequestDispatcher("add.jsp")
                .forward(req, resp);
    }
}
