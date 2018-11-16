package com.imooc.web.servlet.support;

import com.imooc.web.config.DispatcherServletConfig;
import org.springframework.lang.Nullable;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.annotation.HandlesTypes;

/**
 * 替换 web.xml
 * {@link WebApplicationInitializer} 的一种实现，作为dispatcherServlet的web.xml配置
 *
 * @see ServletContainerInitializer  servlet 3.0规范，servlet容器启动的时候执行，实现该接口的方式
 * @see SpringServletContainerInitializer spring的实现，配合@HandlesTypes(WebApplicationInitializer.class)
 * @see HandlesTypes 该注解指明org.springframework.web.SpringServletContainerInitializer
 * #onStartup(java.util.Set, javax.servlet.ServletContext) 的class 列表
 *
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() { //web.xml
        return new Class[0];
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() { //<servlet>便签 DispatcherServlet
        return new Class[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() { //<servlet-mapping>便签
        return new String[]{"/"};
    }
}
