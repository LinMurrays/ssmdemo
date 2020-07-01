package com.jt.common.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 思考:
 * 1)此类何时被加载? tomcat 启动时
 * 2)加载的流程是怎样的?
 * 2.1) tomcat 启动时会读取类路径下的如下文件
 * META-INF/services/javax.servlet.ServletContainerInitializer
 * 2.2) 获取文件中定义的具体类,并且加载此类
 * 2.3) 然后加载修饰此类的@HandlesTypes注解中定义的类型的子类类型.
 */

/**
 * 任意继承自AbstractAnnotationConfigDispatcherServletInitializer的类都会被自动用来配置DispatcherServlet，
 * 这个类负责配置DispatcherServlet、初始化Spring MVC容器和Spring容器。
 *
 * SpittrWebAppInitializer重写了三个方法，getRootConfigClasses()方法用于获取Spring应用容器的配置文件，
 * 这里我们给定预先定义的RootConfig.class；getServletConfigClasses()负责获取SpringMVC应用容器，
 * 这里传入预先定义好的WebConfig.class；getServletMappings()方法负责指定需要由DispatcherServlet映射的路径，
 * 这里给定的是"/"，意思是由DispatcherServlet处理所有向该应用发起的请求。
 *
 */
//web.xml
public class AppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public AppWebInitializer() {
        System.out.println("------AppWebInitializer() ");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("-------getRootConfigClasses()");
        return new Class[]{AppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("-------getServletConfigClasses()");
        return new Class[]{AppServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("-------getServletMappings()");
        return new String[]{"/"};
    }
}


