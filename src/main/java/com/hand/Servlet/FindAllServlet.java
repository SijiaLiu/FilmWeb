package com.hand.Servlet;

import com.hand.Entity.Film;
import com.hand.Service.FindAllService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class FindAllServlet extends HttpServlet {

    public FindAllServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上下文
        ServletContext sc = req.getSession().getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);

        FindAllService fas = wac.getBean("findService", FindAllService.class);

        List<Film> list = fas.findAll();

        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("filmList", list);
        req.getRequestDispatcher("filmList.jsp")
                .forward(req, resp);
    }
}
