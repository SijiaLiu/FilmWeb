package com.hand.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by LiuSijia on 2017/8/15.
 * 编码格式 com.hand.Filter
 */
public class EncodingFilter implements Filter {

    private String charEncoding = null;

    public EncodingFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        charEncoding = filterConfig.getInitParameter("encoding");
        if (charEncoding == null){
            throw new ServletException("EncodingFilter中的编码格式设置为空");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!charEncoding.equals(servletRequest.getCharacterEncoding())){
            servletRequest.setCharacterEncoding(charEncoding);
        }
        servletResponse.setCharacterEncoding(charEncoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
