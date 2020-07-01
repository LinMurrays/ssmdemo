package com.jt.common.filter;

import javax.servlet.*;
import java.io.IOException;

//依赖于servlet
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //第五步
        System.out.println("init");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //先执行这个方法再执行perhandle
        //每一次get请求，先执行这个方法再去执行perhandler
        System.out.println("do filter----MyFilter process...");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        //先执行filter的的story方法再执行监听contextDestroyed
        System.out.println("destroy");

    }
}
