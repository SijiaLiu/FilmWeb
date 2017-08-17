package com.hand.Servlet;

import com.hand.Entity.Film;
import com.hand.Service.FindAllService;
import com.hand.Service.FindOneService;
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
public class FindOneServlet extends HttpServlet {

    public FindOneServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

//        ApplicationContext ctx=
//                new ClassPathXmlApplicationContext("beans.xml");

        //获取上下文
        ServletContext sc = req.getSession().getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);

        FindOneService fos = wac.getBean("findOneService", FindOneService.class);

        List<Film> list = fos.findOne(id);

        req.setAttribute("oneList", list);
        req.getRequestDispatcher("update.jsp")
                .forward(req, resp);
    }
}
