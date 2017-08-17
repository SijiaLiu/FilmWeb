package com.hand.Servlet;

import com.hand.Entity.Film;
import com.hand.Service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by LiuSijia on 2017/8/15.
 */

public class AddServlet extends HttpServlet {

    public AddServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getSession().getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        //ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");

        AddService as = wac.getBean("addService", AddService.class);

        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        int lang_id = Integer.parseInt(req.getParameter("language"));

        Film film = new Film();
        film.setTitle(title);
        film.setDescription(desc);
        film.setLanguage_id(lang_id);


        as.Add(film);
        resp.sendRedirect("findAll");

    }
}
