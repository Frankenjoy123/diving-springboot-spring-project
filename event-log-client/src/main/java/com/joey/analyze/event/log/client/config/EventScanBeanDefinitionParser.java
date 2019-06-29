package com.joey.analyze.event.log.client.config;

import com.joey.analyze.event.log.client.aop.EventLogMethodInterceptor;
import com.joey.analyze.event.log.client.aop.EventMethodMatcher;
import com.joey.analyze.event.log.client.aop.PackageClassFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.lang.Nullable;
import org.w3c.dom.Element;

/**
 * Created by xiaowu.zhou on 2019/6/20.
 */
public class EventScanBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private static final String DEFAULT_BEAN_NAME = "eventLogAdvisor";

    private static final String SCAN_PACKAGES = "scan-packages";

    @Nullable
    @Override
    protected Class<?> getBeanClass(Element element) {
        return DefaultPointcutAdvisor.class;
    }



    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);
        if (StringUtils.isBlank(id)) {
            id = DEFAULT_BEAN_NAME;
        }
        return id;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String scanPackages = element.getAttribute(SCAN_PACKAGES);

        //class过滤器，根据包名
        BeanDefinition packageFilterDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(PackageClassFilter.class)
                .addPropertyValue("packages",scanPackages)
                .getBeanDefinition();
        parserContext.getRegistry().registerBeanDefinition("packageClassFilter", packageFilterDefinition);


        //静态方法匹配
        BeanDefinition staticMethodMatcher =
                BeanDefinitionBuilder.genericBeanDefinition(EventMethodMatcher.class)
                .getBeanDefinition();
        parserContext.getRegistry().registerBeanDefinition("eventLogMethodMatcher",staticMethodMatcher);


        //组合切点
        BeanDefinition composablePointCut =
                BeanDefinitionBuilder.genericBeanDefinition(ComposablePointcut.class)
                .addConstructorArgReference("packageClassFilter")
                .addConstructorArgReference("eventLogMethodMatcher")
                .getBeanDefinition();
        parserContext.getRegistry().registerBeanDefinition("eventLogPointCut",composablePointCut);


        //具体的拦截内容做的事
        // MethodInterceptor 继承 Interceptor 继承 Advice
        BeanDefinition eventLogAdvice =
                BeanDefinitionBuilder.genericBeanDefinition(EventLogMethodInterceptor.class)
                .setScope(BeanDefinition.SCOPE_SINGLETON)
                .getBeanDefinition();
        parserContext.getRegistry().registerBeanDefinition("eventLogAdvice",eventLogAdvice);

        //DefaultPointcutAdvisor将切入点pointCut和具体拦截做的事 advice组合在一起
        builder.addPropertyReference("pointcut","eventLogPointCut")
                .addPropertyReference("advice", "eventLogAdvice");

    }
}
