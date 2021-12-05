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
        context.setAttribute("cb", context.getContextPath());
        System.err.println("---------Servlet容器创建成功 cb被放到ServletContext作用域-------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
