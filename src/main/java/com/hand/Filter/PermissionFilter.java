package com.hand.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LiuSijia on 2017/8/15.
 * 登陆过滤器
 */
public class PermissionFilter implements Filter {

    public PermissionFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将servlet请求强制转换为Http请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取当前请求的路径
        String servletPath = request.getServletPath();
        String url = request.getRequestURI();
        //获取请求的session
        HttpSession session = request.getSession();
        //session.setAttribute(String s, Object o)设置键值对
        String flag = (String) session.getAttribute("flag");
        //设置不需要过滤的页面
        if (servletPath != null && (servletPath.equals("/login.jsp"))||(servletPath.equals("/index.jsp"))
                        || (servletPath.equals("/LoginServlet"))||(servletPath.equals("/login"))){
            filterChain.doFilter(servletRequest, servletResponse);
        }//有些页面包含css和js 防止被过滤
        else if (url.endsWith(".css") || url.endsWith(".js")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        //下面这些是要过滤的页面，根据session中设置的键值对中的value值 判断用户是否处于登录状态
        else {
            if (flag != null&&flag.equals("login_success")){
                //处于登录状态的话将请求传回过滤链
                filterChain.doFilter(servletRequest, servletResponse);
            }else if(flag != null&&flag.equals("login_error")){
                request.setAttribute("msg", "登陆失败");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }else {
                request.setAttribute("msg", "未登陆");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        }
    }

    public void destroy() {

    }
}
