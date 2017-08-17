package com.hand.Servlet;

import com.hand.Entity.Film;
import com.hand.Service.UpdateService;
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

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class UpdateServlet extends HttpServlet {

    public UpdateServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        int lang_id = Integer.parseInt(req.getParameter("language"));

        Film film = new Film();
        film.setFilm_id(id);
        film.setTitle(title);
        film.setDescription(desc);
        film.setLanguage_id(lang_id);

         //获取上下文
        ServletContext sc = req.getSession().getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);

        UpdateService us = wac.getBean("updateService", UpdateService.class);

        us.Update(film);
        resp.sendRedirect("findAll");
    }

}
