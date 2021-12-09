package com.cb.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lx
 * @create 2021-11-29 11:52
 */
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //取到ServletContext
        ServletContext context=servletContextEvent.getServletContext();
        //将cb放到ServletContext作用域，前台通过${cb}获取项目根目录
        context.setAttribute("cb", context.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
